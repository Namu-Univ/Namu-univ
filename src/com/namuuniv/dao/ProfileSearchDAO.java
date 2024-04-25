package com.namuuniv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.namuuniv.vo.StudentVO;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.mybatis.DBService;

public class ProfileSearchDAO {
			//학생 조회
			public static StudentVO studentOne(String id) {
				try(SqlSession ss = DBService.getFactory().openSession()){
					return ss.selectOne("NAMU.studentOne",id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			//학생 동적검색(이름, 학번, 전공)
			public static List<StudentVO> getStudentSearch(String idx, String keyword){
				try(SqlSession ss = DBService.getFactory().openSession()){
					Map<String, String> map = new HashMap<>();
					map.put("idx", idx);
					map.put("keyword", keyword);
					
					return ss.selectList("namu.SearchStudent", map);
				}catch(Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			//교수 조회
			public static ProfessorVO professorOne(String id) {
				try(SqlSession ss = DBService.getFactory().openSession()){
					return ss.selectOne("namu.professorOne",id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			//교수 동적검색(이름, 교번, 전공)
			public static List<ProfessorVO> getProfessorSearch(String idx, String keyword){
				try(SqlSession ss = DBService.getFactory().openSession()){
					Map<String, String> map = new HashMap<>();
					map.put("idx", idx);
					map.put("keyword", keyword);
					
					return ss.selectList("namu.SearchProfessor", map);
				}catch(Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			//교직원 조회
			public static StaffVO staffOne(String id) {
				try(SqlSession ss = DBService.getFactory().openSession()){
					return ss.selectOne("namu.staffOne",id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			//교직원 동적검색(이름, 교번, 부서)
			public static List<StaffVO> getStaffSearch(String idx, String keyword){
				try(SqlSession ss = DBService.getFactory().openSession()){
					Map<String, String> map = new HashMap<>();
					map.put("idx", idx);
					map.put("keyword", keyword);
					
					return ss.selectList("namu.SearchStaff", map);
				}catch(Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}
