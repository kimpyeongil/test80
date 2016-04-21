package bitcamp.pms.domain;

public class ProjectMember {
  private int projectNo;
  private int memberNo;
  
  public ProjectMember() {}

  public ProjectMember(int projectNo, int memberNo) {
    this.projectNo = projectNo;
    this.memberNo = memberNo;
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
}
