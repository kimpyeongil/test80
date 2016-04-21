package bitcamp.pms;

import java.util.Scanner;

import bitcamp.pms.menu.AuthMenu;

public class ProjectApp {
  static Scanner keyScan = new Scanner(System.in);
  private static AuthMenu authMenu = new AuthMenu();
//  private static SubjectMenu subMenu = new SubjectMenu();
  
  public static void main(String[] args) {
    System.out.println("프로젝트 관리 프로그램에 오신 것을 환영합니다.");
    authMenu.setScanner(keyScan);
    authMenu.service();
  }  
}
