package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.domain.Member;
import bitcamp.pms.util.CommandUtil;
import bitcamp.pms.util.PatternTest;
import bitcamp.pms.util.Session;

public class AuthMenu {
  private Scanner keyScan;
  private MemberDao memberDao;
  private Session session;
  private SubjectMenu subMenu = new SubjectMenu();

  public void setSession(Session session) {
    this.session = session;
  }

  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }

  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  public void service() {
    String input = null;
    while (true) {
      System.out.println("메뉴를 선택하세요.");
      System.out.println("1)로그인  2)회원가입  9) 종료");
      input = keyScan.nextLine();
      try {
        switch (input) {
          case "1": 
            if(doLogin()) return; 
            break;
          case "2": 
            doSignup(); 
            break;
          case "9": 
            System.out.println("안녕히 가세요.");
            System.exit(0); 
            break;
          default: 
            System.out.println("올바르지 않은 번호입니다.");
        }
      } catch (Exception e) {
        System.out.println("서버와 연결할 수 없습니다.");
        e.printStackTrace();
      }
    }
  }
  
  private boolean doLogin() {
    System.out.print("E-mail: ");
    String email = keyScan.nextLine();
    System.out.print("Password: ");
    String password = keyScan.nextLine();    
    Member member = memberDao.selectOneByEmail(email);
    if (member == null) {
      System.out.println("등록되지 않은 사용자입니다.");
      return false;
    } else if (!member.getPassword().equals(password)) {
      System.out.println("암호가 맞지 않습니다.");
      return false;
    }
    session.setAttribute("loginUser", member);    
    System.out.printf("환영합니다. %s님!\n", member.getName());
    return true;
  }
  
  private void doSignup() {
    Member member = new Member();
    String value;
    
    System.out.print("이름? ");
    member.setName(keyScan.nextLine());
    while (true) { 
      System.out.print("이메일? ");    
      value = keyScan.nextLine();
      if (PatternTest.checkEmail(value)) 
        break;
      System.out.println("이메일 형식이 맞지 않습니다. (유효 형식: xxx@xxx.xxx)");
    }
    member.setEmail(value);    
    
    while (true) { 
      System.out.print("암호? ");    
      value = keyScan.nextLine();
      if (PatternTest.checkPassword(value)) 
        break;
      System.out.println("암호는 4 ~ 10자 까지만 가능합니다. 최소 알파벳1개, 숫자1개, 특수문자(?,!,@)1개 반드시 포함.");
    }
    member.setPassword(value);
    
    while (true) { 
      System.out.print("전화? ");    
      value = keyScan.nextLine();
      if (PatternTest.checkPhone(value)) 
        break;
      System.out.println("전화 번호 형식이 맞지 않습니다.(3~4-4자), (2~4-3~4-4)");
    }
    member.setTel(value);
    try {
      memberDao.insert(member);
      System.out.println("가입 완료!");
    } catch (Exception e) {
      System.out.println("회원 가입 실패!");
    }    
  }
  
  @RequestMapping("unsubscribe")
  public void unsubscribe(Session se) {
    if (CommandUtil.confirm(keyScan, "정말 탈퇴하시겠습니까?")) {
      try {
        Member loginUser = (Member)se.getAttribute("loginUser");
        memberDao.delete(loginUser.getNo());
        System.out.println("탈퇴 처리가 완료되었습니다. 안녕히 가세요.");
      } catch (Exception e) {
        System.out.println("탈퇴 처리중 서버에 이상이 발생하였습니다.");
      }
    }
  }
}
