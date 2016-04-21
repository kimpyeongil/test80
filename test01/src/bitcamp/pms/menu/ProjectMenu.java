package bitcamp.pms.menu;

import java.util.Scanner;

public class ProjectMenu {
  Scanner keyScan = new Scanner(System.in);
  private BoardMenu boardMenu = new BoardMenu();
  private TaskMenu taskMenu = new TaskMenu();
  
  public void service() {
    String input = null;
    do {
      input = prompt();
      menu(input);
    } while(!input.equals("9"));    
  }
  
  private String prompt() {    
    System.out.println("[내 프로젝트]");
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 프로젝트 정보");
    System.out.println("2) 프로젝트 수정");
    System.out.println("3) 게시판 메뉴");
    System.out.println("4) 작업 메뉴");
    System.out.println("5) 프로젝트 삭제(팀장 전용)");
    System.out.println("9) 이전 메뉴");
    return keyScan.nextLine();
  }  

  private void menu(String input) {
    switch(input) {
      case "1": printProjectInfo(); break;
      case "2": updateProject(); break;
      case "3": toBoard(); break;
      case "4": toTask(); break;
      case "5": deleteProject(); break;
      case "9": break;
      default : doErr(); 
    }
  }

  private void printProjectInfo() {
    System.out.println("-- 7번 팀 -- ");
    System.out.println("주제: 프로젝트 관리 시스템");
    System.out.println("팀원: 최춘호, 배윤호, 김평일, 이천배, 박현신");
    System.out.println("");
  }

  private void updateProject() {
    System.out.println("프로젝트 수정");
  }
  
  private void toBoard() {
    boardMenu.service();
  }
  
  private void toTask() {
    taskMenu.service();
  }
  
  private void deleteProject() {
    System.out.println("프로젝트 삭제(팀장 전용)");
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
