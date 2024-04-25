package com.namuuniv.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentStatusVO;

public class CheckLeaveAbDAO {
	
	//교직원 -학생 휴학신청서 조회
	public static List<StudentStatusVO> getCheckLeave(String studentId) {
		SqlSession sqlSession = null;
		List<StudentStatusVO> list = null;

		try {
			sqlSession = DBService.getFactory().openSession();
			list = sqlSession.selectList("namu.checkLeave", studentId);
			System.out.println("List : " + list);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return null;
	}

}
