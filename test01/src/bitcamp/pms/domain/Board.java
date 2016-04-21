package bitcamp.pms.domain;

import java.sql.Date;

public class Board {
  private int     no;
  private String  title;
  private int     projectNo;
  private int     memberNo;
  private String  content;
  private int     views;
  private Date    createdDate;
  
  public Board() {}

  public Board(int no, String title, int projectNo, int memberNo, String content, int views, Date createdDate) {
    this.no = no;
    this.title = title;
    this.projectNo = projectNo;
    this.memberNo = memberNo;
    this.content = content;
    this.views = views;
    this.createdDate = createdDate;
  }
  
  @Override
  public String toString() {
    return no + ", " + title + ", " + content + ", " + views + ", " + 
          createdDate;
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
  
  public Date getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
