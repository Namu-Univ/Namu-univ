package com.namuuniv.vo;

import java.sql.Date;

public class ProfessorVO {
	
	private int id;
	private String name;
	private String birthDate; // Date -> String 으로 수정
	private String gender;
	private String address;
	private String tel;
	private Date hireDate;
	private int deptId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public String toString() {
		return "ProfessorVO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", address=" + address + ", tel=" + tel + ", hireDate=" + hireDate + ", deptId=" + deptId + "]";
	}

}
