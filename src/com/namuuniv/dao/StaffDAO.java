package com.namuuniv.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;

public class StaffDAO {

	// 교직원 정보 조회
	public static List<StaffVO> getStaffInfo() {
		SqlSession sqlSession = null;
		List<StaffVO> list = null;

		try {
			sqlSession = DBService.getFactory().openSession();
			list = sqlSession.selectList("namu.stafflist");
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
