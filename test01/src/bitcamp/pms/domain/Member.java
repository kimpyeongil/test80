package bitcamp.pms.domain;

public class Member {
  private int    no;
  private String name;
  private String email;
  private String password;
  private String tel;
  private boolean level;
  public boolean isLevel() {
    return level;
  }

  public void setLevel(boolean level) {
    this.level = level;
  }

  public Member() {}

  public Member(int no, String name, String email, String pass, String phone) {
    this.setNo(no);
    this.setName(name);
    this.setEmail(email);
    this.setPassword(pass);
    this.setTel(phone);
  }

  @Override
  public String toString() {
    return no + ", " + name + ", " + email + ", " + password + ", " + tel;
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

  public void setPassword(String pass) {
    this.password = pass;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String phone) {
    this.tel = phone;
  }  
}
