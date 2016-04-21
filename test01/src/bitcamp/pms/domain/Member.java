package bitcamp.pms.domain;

public class Member {
  private int    no;
  private String name;
  private String email;
  private String pass;
  private String phone;

  public Member() {}

  public Member(int no, String name, String email, String pass, String phone) {
    this.setNo(no);
    this.setName(name);
    this.setEmail(email);
    this.setPass(pass);
    this.setPhone(phone);
  }

  @Override
  public String toString() {
    return no + ", " + name + ", " + email + ", " + pass + ", " + phone;
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

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }  
}
