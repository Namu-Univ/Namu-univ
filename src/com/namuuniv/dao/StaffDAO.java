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
			int staffId = ss.selectOne("NAMU.nextStaffId");
			vo.setId(staffId);
			
			int result = ss.insert("NAMU.insertStaff", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(staffId);
				user.setPassword(vo.getBirthDate());
				user.setRole("staff");
				ss.insert("NAMU.insertUsers", user);
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
			int studentId = ss.selectOne("NAMU.nextStudentId");
			vo.setId(studentId);
			int result = ss.insert("NAMU.insertStudent", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(vo.getId());
				user.setPassword(vo.getBirthDate());
				user.setRole("student");
				ss.insert("NAMU.insertUsers", user);
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
			int professorId = ss.selectOne("NAMU.nextProfessorId");
			vo.setId(professorId);
			int result = ss.insert("NAMU.insertProfessor", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(professorId);
				user.setPassword(vo.getBirthDate());
				user.setRole("professor");
				ss.insert("NAMU.insertUsers", user);
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

	// 학과 조회
	public static List<DepartmentVO> getAllDepts() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("NAMU.selectAllDepts");
		}
	}
	
}
