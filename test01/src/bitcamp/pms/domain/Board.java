package bitcamp.pms.domain;

import java.sql.Date;

public class Board {
  private int     no;
  private String  title;
  private String  content;
  private int     views;
  private String  password;
  private Date    createdDate;
  
  public Board() {}

  public Board(int no, String title, String content, int views, String password, Date createdDate) {
    this.no = no;
    this.title = title;
    this.content = content;
    this.views = views;
    this.password = password;
    this.createdDate = createdDate;
  }
  
  @Override
  public String toString() {
    return no + ", " + title + ", " + content + ", " + views + ", " + 
          password + ", " + createdDate;
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
