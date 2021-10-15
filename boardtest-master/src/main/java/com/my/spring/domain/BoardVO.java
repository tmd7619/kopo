package com.my.spring.domain;

/* domain == DTO
 * Orcle에서 생성한 테이블 변수들을 적어두는 곳 
 * 변수들을 나타내고(private로 만들어주는게 좋다), Source-generate를 통해 겟터,셋터함수들을 만들어준다
 * lombok을 이용해 어노테이션만 작성하는 방법도 있음 
 * https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html 참고
 */

import java.util.Date;

public class BoardVO {

	int seq, cnt;
	String title, writer, content;
	Date regdate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}