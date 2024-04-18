package com.namuuniv.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
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
				user.setPassword(formatDate(vo.getBirthDate()));
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
		SqlSession ss = DBService.getFactory().openSession();
		try {
			if (!validDeptId(vo.getDeptId())) {
				throw new IllegalArgumentException("해당 학과가 존재하지 않습니다.");
			}
			int studentId = ss.selectOne("NAMU.nextStudentId");
			vo.setId(studentId);
			int result = ss.insert("NAMU.insertStudent", vo);
			if (result > 0) {
				UsersVO user = new UsersVO();
				user.setId(studentId);
				user.setPassword(formatDate(vo.getBirthDate()));
				user.setRole("student");
				ss.insert("NAMU.insertUsers");
				ss.commit();
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
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			if (validDeptId(vo.getDeptId())) {
				return ss.insert("NAMU.insertProfessor", vo);
			} else {
				throw new IllegalArgumentException("해당 학과가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 생년월일 YYYYMMDD형식 문자열로 변환
	private static String formatDate(java.util.Date birthDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(birthDate);
	}
	
	// 학과 id가 존재하는지 확인
	public static boolean validDeptId(int deptId) {
		SqlSession ss = DBService.getFactory().openSession();
		return ss.selectOne("NAMU.validDeptId", deptId);
	}
	
}
