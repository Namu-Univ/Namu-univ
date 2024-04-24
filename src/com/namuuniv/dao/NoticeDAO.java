package com.namuuniv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.mybatis.DBService;
import com.namuuniv.vo.NoticeVO;

public class NoticeDAO {
	
	// 전체 공지글 수 조회
	public static int totalNoticeCount() {
		int totalCount = 0;
		try (SqlSession ss = DBService.getFactory().openSession()) {
			totalCount = ss.selectOne("namu.totalNoticeCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}
	
	// 페이지에 해당하는 공지글 조회
	public static List<NoticeVO> noticeList(int begin, int end) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", begin);
			map.put("end", end);
			return ss.selectList("namu.noticeList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 교직원 확인 여부
	public static boolean checkStaff(int userId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			int isStaff = ss.selectOne("namu.checkStaff", userId);
			return isStaff == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
