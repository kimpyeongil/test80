package bitcamp.pms.domain;

import java.sql.Date;

public class Task {
  private int     no;
  private String  content;
  private Date    startDate;
  private Date    endDate;
  
  public Task() {}

  public Task(int no, String content, Date startDate, Date endDate) {
    this.no = no;
    this.content = content;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return no + ", " + content + ", " + startDate + ", " + endDate;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

}
