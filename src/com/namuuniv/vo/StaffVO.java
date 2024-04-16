package com.namuuniv.vo;

import java.sql.Date;

public class StaffVO {
	
	private int id;
	private String password;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private Date hireDate;
	private String dept;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "StaffVO [id=" + id + ", password=" + password + ", name=" + name + ", birthDate=" + birthDate
				+ ", gender=" + gender + ", address=" + address + ", tel=" + tel + ", hireDate=" + hireDate + ", dept="
				+ dept + "]";
	}

}
