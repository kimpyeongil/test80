package bitcamp.pms.menu;

import java.util.Scanner;

public class ClassMenu implements Menu {
  Scanner keyScan = new Scanner(System.in);
  private ProjectMenu proMenu = new ProjectMenu();
  
  public void service() {
    String input = null;
    do {
      input = prompt();
      menu(input);
    } while(!input.equals("9"));    
  }
  
  private String prompt() {    
    System.out.println("[내 강의]");
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 커리큘럼 확인");
    System.out.println("2) 프로젝트 목록");
    System.out.println("3) 프로젝트 생성");
    System.out.println("4) 프로젝트 멤버 등록");
    System.out.println("5) 내 프로젝트");
    System.out.println("9) 이전 메뉴");
    return keyScan.nextLine();
  }  

  private void menu(String input) {
    switch(input) {
      case "1": printCurriculum(); break;
      case "2": doProjectList(); break;
      case "3": makeProject(); break;
      case "4": doRegister(); break;
      case "5": doProjectMenu(); break;
      case "9": break;
      default : doErr(); 
    }
  }

  private void printCurriculum() {
    System.out.println("자바 프로그래밍 80기");
    System.out.println("강사 : 엄진영");
  }

  private void doProjectList() {
    System.out.println("프로젝트 목록");
  }
  
  private void makeProject() {
    System.out.println("프로젝트 생성");
  }
  
  private void doRegister() {
    System.out.println("프로젝트 멤버 등록");
  }
  
  private void doProjectMenu() {
    proMenu.service();
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
