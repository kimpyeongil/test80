package bitcamp.pms.menu;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.domain.Item;
import bitcamp.pms.domain.Member;

public class ClassMenu {
  Scanner keyScan = new Scanner(System.in);
  private ProjectMenu proMenu = new ProjectMenu();
  private Member loginMember;
  private Item item;
  
  public void service(int classNo, Member member, Item item) {
    this.item = item;
    loginMember = member;
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
      case "2": doMenu("project/list.do"); break;
      case "3": doMenu("project/add.do"); break;
      case "4": doRegister(); break;
      case "5": doProjectMenu(); break;
      case "9": break;
      default : doErr(); 
    }
  }
  
  private void doMenu(String input) {
    RequestHandler requestHandler = 
        item.getRequestHandlerMapping().getRequestHandler(input);
    if (requestHandler == null) {
      System.out.println("존재하지 않는 메뉴입니다.");
      return;
    }
    Method method = requestHandler.getMethod();
    Object obj = requestHandler.getObj();
    
    try {      
      ArrayList<Object> args = new ArrayList<>();       
      Parameter[] params = method.getParameters();
      Object arg = null;
      for (Parameter param : params) {        
        arg = item.getAppContext().getBean(param.getType());
        args.add(arg);
      }
      method.invoke(obj, args.toArray());
    } catch (Exception e) {
      System.out.println("명령 처리중 에러 발생");
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
