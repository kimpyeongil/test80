package bitcamp.pms.domain;

import java.sql.Date;

public class Task {
 private int no;
 private String title;
 private int projectNo;
 private int memberNo;
 private String content;
 private Date startDate;
 private Date endDate;
  
public Task() {}

public Task(int no, String title, int projectNo, int memberNo, String content, Date startDate, Date endDate) {
this.no = no;
this.title = title;
this.projectNo = projectNo;
this.memberNo = memberNo;
this.content = content;
this.startDate = startDate;
this.endDate = endDate;
}

@Override
public String toString() {
return no + ", " + title + ", " + content + ", " + startDate + ", " + endDate;
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
