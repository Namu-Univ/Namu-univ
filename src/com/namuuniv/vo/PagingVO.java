package com.namuuniv.vo;

public class PagingVO {
	private int nowPage = 1;
	private int nowBlock = 1;
	
	private int numPerPage = 5;
	private int pagePerBlock = 5;
	
	private int totalRecord = 0;
	private int totalPage = 0;
	private int totalBlock = 0;
	
	private int begin = 0;
	private int end = 0;
	
	private int beginPage = 0;
	private int endPage = 0;
	
	public void calculatePaging() {
		// 전체 페이지 수 계산
		totalPage = totalRecord / numPerPage;
		if (totalRecord % numPerPage > 0) totalPage++;
		
		// 현재 페이지에 표시할 게시글 시작번호, 끝번호 계산
		begin = (nowPage - 1) * numPerPage + 1;
		end = nowPage * numPerPage;
		if (end > totalRecord) {
			end = totalRecord;
		}
		
		// 페이징 블록 계산
		nowBlock = (nowPage - 1) / pagePerBlock + 1;
		beginPage = (nowBlock - 1) / pagePerBlock + 1;
		endPage = nowBlock * pagePerBlock;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "PagingVO [nowPage=" + nowPage + ", nowBlock=" + nowBlock + ", numPerPage=" + numPerPage
				+ ", pagePerBlock=" + pagePerBlock + ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
				+ ", totalBlock=" + totalBlock + ", begin=" + begin + ", end=" + end + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + "]";
	}
	
}
