package kr.ac.kopo.board.vo;

/*
 * 자바빈즈 클래스
 * 1. package 포함
 * 2. 클래스의 접근제한자 public
 * 3. 멤버 변수의 접근 
 */
public class BoardVO {

   private int no;
   private String title;
   private String writer;
   private String regDate;
   
   
   public BoardVO() {
   }
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
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
   public String getRegDate() {
      return regDate;
   }
   public void setRegDate(String regDate) {
      this.regDate = regDate;
   }
   
   
}