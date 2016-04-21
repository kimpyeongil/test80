package bitcamp.pms.domain;

import java.sql.Date;

public class Project {
  private int     pno;
  private String  pnm;
  private String  description;
  private Date    startDate;
  private Date    endDate;
  
  
  
  @Override
  public String toString() {
    return "프로젝트번호=" + pno + ", 프로젝트명=" + pnm + ", 내용=" + description + ", 시작일=" + startDate
        + ", 종료일=" + endDate + "]";
  }
  public Project() {
    super();
    // TODO Auto-generated constructor stub
  }
  public Project(int pno, String pnm, String description, Date startDate, Date endDate) {
    super();
    this.pno = pno;
    this.pnm = pnm;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public String getPnm() {
    return pnm;
  }
  public void setPnm(String pnm) {
    this.pnm = pnm;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
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
