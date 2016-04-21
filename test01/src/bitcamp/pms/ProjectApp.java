package bitcamp.pms;

import java.util.Scanner;

import bitcamp.pms.menu.SubjectMenu;

public class ProjectApp {
  static Scanner keyScan = new Scanner(System.in);
  static SubjectMenu subMenu = new SubjectMenu();  
  
  public static void main(String[] args) {
    String input = null;    
    System.out.println("프로젝트 관리 프로그램에 오신 것을 환영합니다.");
    do {
      input = startPrompt();
      startMenu(input);
    } while(!input.equals("9"));
  }

  static String startPrompt() {
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 로그인");
    System.out.println("2) 회원가입");
    System.out.println("9) 프로그램 종료");    
    return keyScan.nextLine();
  }
  
  private static void startMenu(String input) {
    switch(input) {
      case "1": doLogin(); break;
      case "2": doJoin(); break;
      case "9": doQuit(); break;
      default : doErr(); 
    }
  }
  
  private static void doLogin() {
    System.out.println("로그인");
    subMenu.service();
  }
  
  private static void doJoin() {
    System.out.println("회원가입");
  }
  
  private static void doQuit() {
    System.out.println("안녕히 가세요.");
  }
  
  private static void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
  
}
