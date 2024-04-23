package com.namuuniv.vo;

import java.sql.Date;

public class StudentVO {

	private int id;
	private int deptId;
	private String password;
	private String name;
	private String birthDate; // Date -> String 으로 수정
	private String gender;
	private String address;
	private String tel;
	private int grade;
	private int semester;
	private Date entranceDate;
	private Date graduationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", deptId=" + deptId + ", password=" + password + ", name=" + name
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", address=" + address + ", tel=" + tel
				+ ", grade=" + grade + ", semester=" + semester + ", entranceDate=" + entranceDate + ", graduationDate="
				+ graduationDate + "]";
	}

}
