package com.namuuniv.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StudentVO;

public class ProfessorDAO {
	
	//학생 정보 조회
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
}
