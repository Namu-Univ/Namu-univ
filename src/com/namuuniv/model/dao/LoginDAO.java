package com.namuuniv.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.UsersVO;

public class LoginDAO {
	
	public static List<UsersVO> getLogin(String id, String password) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("password", password);
			
			return ss.selectList("namu.login", map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public static List<UsersVO> getRole(String id) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("namu.role", id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
