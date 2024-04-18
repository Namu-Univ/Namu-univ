package com.namuuniv.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.UsersVO;

public class LoginDAO {
	
	public static List<UsersVO> getLogin(int id, String password) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("password", password);

			System.out.println("map : " + map);
			
			return ss.selectList("namu.login", map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
