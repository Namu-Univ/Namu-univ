package com.namuuniv.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.DepartmentVO;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;
import com.namuuniv.vo.UsersVO;

public class StaffDAO {
	
	// 교직원 추가
	public static int insertStaff(StaffVO vo) {
		SqlSession ss = DBService.getFactory().openSession();
		try {
			int staffId = ss.selectOne("namu.nextStaffId");
			vo.setId(staffId);
			
			int result = ss.insert("namu.insertStaff", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(staffId);
				user.setPassword(formatDate(vo.getBirthDate()));
				user.setRole("staff");
				ss.insert("namu.insertUsers", user);
				ss.commit();
				return result;
			}
		} catch (Exception e) {
			ss.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return -1;
	}

	// 학생 추가
	public static int insertStudent(StudentVO vo) {
		SqlSession ss = DBService.getFactory().openSession(false);
		try {
			int studentId = ss.selectOne("namu.nextStudentId");
			vo.setId(studentId);
			int result = ss.insert("namu.insertStudent", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(vo.getId());
				user.setPassword(formatDate(vo.getBirthDate()));
				user.setRole("student");
				ss.insert("namu.insertUsers", user);
				ss.commit();
				return result;
			}
		} catch (Exception e) {
			ss.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return -1;
	}

	// 교수 추가
	public static int insertProfessor(ProfessorVO vo) {
		SqlSession ss = DBService.getFactory().openSession();
		try {
			int professorId = ss.selectOne("namu.nextProfessorId");
			vo.setId(professorId);
			int result = ss.insert("namu.insertProfessor", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(professorId);
				user.setPassword(formatDate(vo.getBirthDate()));
				user.setRole("professor");
				ss.insert("namu.insertUsers", user);
				ss.commit();
				return result;
			}
		} catch (Exception e) {
			ss.rollback();
		} finally {
			ss.close();
		}
		return -1;
	}
	
	// 생년월일 YYYYMMDD 형식으로 변환
	private static String formatDate(String birthDate) {
		return birthDate.replaceAll("-", "");
	}

	// 학과 조회
	public static List<DepartmentVO> getAllDepts() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("namu.selectAllDepts");
		}
	}
	
}
