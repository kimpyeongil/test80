package bitcamp.pms.domain;

public class Member {
  private int    no;
  private String name;
  private String email;
  private String password;
  private String tel;
  private boolean level;
  
  public Member() {}

  public Member(int no, String name, String email, String password, String tel, boolean level) {
    this.no = no;
    this.name = name;
    this.email = email;
    this.password = password;
    this.tel = tel;
    this.level = level;
  }

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", tel=" + tel
        + ", level=" + level + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public boolean isLevel() {
    return level;
  }

  public void setLevel(boolean level) {
    this.level = level;
  }
}