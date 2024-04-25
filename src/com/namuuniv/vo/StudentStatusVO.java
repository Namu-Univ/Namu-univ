package com.namuuniv.vo;

public class StudentStatusVO {

	private int id;
	private String status; //학적상태
	private String statYear; // 시작연도
	private String startSemester; // 시작학기
	private String finishYear; // 종료연도
	private String finishSemester; // 종료학기
	private String reporingDate; // 신청일
	private String approvalStatus; // 승인여부
	//---------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatYear() {
		return statYear;
	}
	public void setStatYear(String statYear) {
		this.statYear = statYear;
	}
	public String getStartSemester() {
		return startSemester;
	}
	public void setStartSemester(String startSemester) {
		this.startSemester = startSemester;
	}
	public String getFinishYear() {
		return finishYear;
	}
	public void setFinishYear(String finishYear) {
		this.finishYear = finishYear;
	}
	public String getFinishSemester() {
		return finishSemester;
	}
	public void setFinishSemester(String finishSemester) {
		this.finishSemester = finishSemester;
	}
	public String getReporingDate() {
		return reporingDate;
	}
	public void setReporingDate(String reporingDate) {
		this.reporingDate = reporingDate;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	@Override
	public String toString() {
		return "StudentStatusVO [id=" + id + ", status=" + status + ", statYear=" + statYear + ", startSemester="
				+ startSemester + ", finishYear=" + finishYear + ", finishSemester=" + finishSemester
				+ ", reporingDate=" + reporingDate + ", approvalStatus=" + approvalStatus + "]";
	}


	
}