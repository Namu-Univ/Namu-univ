package com.namuuniv.dao;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.StudentVO;
import com.namuuniv.vo.UsersVO;

public class LoginDAO {
	
	public static UsersVO getLogin(UsersVO user) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("namu.login", user);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public static UsersVO getRole(UsersVO user) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("namu.role", user);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
