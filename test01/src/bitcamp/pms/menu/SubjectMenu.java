package bitcamp.pms.menu;

import java.util.Scanner;

import bitcamp.pms.domain.Item;
import bitcamp.pms.domain.Member;

public class SubjectMenu {
  Scanner keyScan = new Scanner(System.in);
  private ClassMenu classMenu = new ClassMenu();
  private Member loginMember;
  private Item item;
  
  public void service(Member member, Item item) {
    loginMember = member;
    this.item = item;
    String input = null;
    do {
      input = prompt();
      menu(input);
    } while(!input.equals("9"));
  }
  
  private String prompt() {    
    System.out.println("[강의 메뉴]");
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 수강신청");
    System.out.println("2) 내 강의");
    System.out.println("9) 프로그램 종료");
    return keyScan.nextLine();
  }  

  private void menu(String input) {
    switch(input) {
      case "1": doEnrolment(); break;
      case "2": myClass(); break;
      case "9": break;
      default : doErr();
    }
  }
  
  private void doEnrolment() {
    System.out.println("수강신청 나중에 만들꺼");
  }

  private void myClass() {
    classMenu.service(1, loginMember, item);
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
