package bitcamp.pms.menu;

import java.util.Scanner;

public class SubjectMenu implements Menu {
  Scanner keyScan = new Scanner(System.in);
  private ClassMenu classMenu = new ClassMenu();
  
  public void service() {
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
    System.out.println("9) 이전 메뉴");
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
    System.out.println("수강신청");
  }

  private void myClass() {
    classMenu.service();
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
