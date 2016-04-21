package bitcamp.pms.domain;

public class ClassMember {
  private int classNo;
  private int memberNo;
  
  public ClassMember() {}

  public ClassMember(int classNo, int memberNo) {
    this.classNo = classNo;
    this.memberNo = memberNo;
  }

  public int getClassNo() {
    return classNo;
  }

  public void setClassNo(int classNo) {
    this.classNo = classNo;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }  
}
