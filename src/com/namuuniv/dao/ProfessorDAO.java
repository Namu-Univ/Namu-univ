package com.namuuniv.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StudentVO;

public class ProfessorDAO {

	// 교수 정보 조회
	public static List<ProfessorVO> getProInfo() {
		SqlSession sqlSession = null;
		List<ProfessorVO> list = null;

		try {
			sqlSession = DBService.getFactory().openSession();
			list = sqlSession.selectList("namu.prolist");
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

	// 교수 정보 수정
	public static boolean updateProfessor(ProfessorVO professor) {
		try (SqlSession sqlSession = DBService.getFactory().openSession()) {
			int count = sqlSession.update("namu.updateProfessor", professor);
			if (count > 0) { // 0 이상일시 DB에 커밋
				sqlSession.commit();
				return true;
			} else {
				sqlSession.rollback();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
