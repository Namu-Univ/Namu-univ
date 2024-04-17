package com.namuuniv.dao;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;

public class StaffDAO {
	
	// 교직원 추가
	public static int insertStaff(StaffVO vo) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.insert("NAMU.insertStaff", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 학생 추가
	public static int insertStudent(StudentVO vo) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			if (validDeptId(vo.getDeptId())) {
				return ss.insert("NAMU.insertStudent", vo);
			} else {
				// 학과 id가 null이거나 없는 값이 전달되었을 때 처리
				throw new IllegalArgumentException("해당 학과가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	
	// 학과 id가 존재하는지 확인
	public static boolean validDeptId(int deptId) {
		SqlSession ss = DBService.getFactory().openSession();
		return ss.selectOne("NAMU.validDeptId", deptId);
	}
	
}
