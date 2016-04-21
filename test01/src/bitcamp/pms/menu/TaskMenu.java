package bitcamp.pms.menu;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.domain.Item;
import bitcamp.pms.domain.ProjectMember;

public class TaskMenu {
  Scanner keyScan = new Scanner(System.in);
  private ProjectMember projectMember;
  private Item item;
  
  public void service(ProjectMember projectMember, Item item) {
    this.projectMember = projectMember;
    this.item = item;
    String input = null;
    do {
      input = prompt();
      menu(input);
    } while(!input.equals("9"));    
  }
  
  private String prompt() {    
    System.out.println("[작업 메뉴]");
    System.out.println("메뉴를 선택하세요.");
    System.out.println("1) 작업 목록");
    System.out.println("2) 새 작업 등록");
    System.out.println("3) 작업 내용 수정");
    System.out.println("4) 기존 작업 삭제");
    System.out.println("9) 이전 메뉴");
    return keyScan.nextLine();
  }  

  private void menu(String input) {
    switch(input) {
      case "1": doMenu("task/list.do"); break;
      case "2": doMenu("task/add.do"); break;
      case "3": doMenu("task/update.do"); break;
      case "4": doMenu("task/delete.do"); break;
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

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
