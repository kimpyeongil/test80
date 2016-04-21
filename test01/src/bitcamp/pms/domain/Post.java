package bitcamp.pms.domain;

import java.sql.Date;

public class Post {
  private int     no;
  private String  title;
  private int     projectNo;
  private int     memberNo;
  private String  content;
  private int     views;
  private String  password;
  private Date    createdDate;
  
  
  @Override
  public String toString() {
    return "Post [no=" + no + ", title=" + title + ", projectNo=" + projectNo + ", memberNo=" + memberNo + ", content="
        + content + ", views=" + views + ", password=" + password + ", createdDate=" + createdDate + "]";
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
  public int getProjectNo() {
    return projectNo;
  }
  public void setProjectNo(int projectNo) {
    this.projectNo = projectNo;
  }
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViews() {
    return views;
  }
  public void setViews(int views) {
    this.views = views;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  
}
