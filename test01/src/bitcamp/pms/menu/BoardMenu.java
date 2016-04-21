package bitcamp.pms.menu;

import java.util.Scanner;

import bitcamp.pms.controller.BoardController;

public class BoardMenu implements Menu {
  Scanner keyScan = new Scanner(System.in);
  private BoardController controller = new BoardController();
  
  public void service() {
    String input = null;
    do {
      input = prompt();
      menu(input);
    } while(!input.equals("9"));    
  }
  
  private String prompt() {    
    System.out.println("[게시판 메뉴]");
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 게시글 목록");
    System.out.println("2) 새 글 등록");
    System.out.println("3) 글 내용 수정");
    System.out.println("4) 기존 글 삭제");
    System.out.println("9) 이전 메뉴");
    return keyScan.nextLine();
  }  

  private void menu(String input) {
    switch(input) {
      case "1": controller.list(); break;
      case "2": controller.insert(); break;
      case "3": controller.update(); break;
      case "4": controller.delete(); break;
      case "9": break;
      default : doErr(); 
    }
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
