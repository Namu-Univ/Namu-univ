package com.namuuniv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.StudentVO;

public class StudentDAO {

	// 학생 정보 조회
	public static List<StudentVO> getStuInfo() {
		SqlSession sqlSession = null;
		List<StudentVO> list = null;

		try {
			sqlSession = DBService.getFactory().openSession();
			list = sqlSession.selectList("namu.stulist");
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

	 // 학생 정보 수정
    public static boolean updateStudent(StudentVO student) {
        try (SqlSession sqlSession = DBService.getFactory().openSession()) {
            int count = sqlSession.update("namu.updateStudent", student);
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
