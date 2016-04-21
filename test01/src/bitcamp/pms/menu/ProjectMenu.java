package bitcamp.pms.menu;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.domain.Item;
import bitcamp.pms.domain.Project;
import bitcamp.pms.domain.ProjectMember;

public class ProjectMenu {
  Scanner keyScan = new Scanner(System.in);
  private BoardMenu boardMenu = new BoardMenu();
  private TaskMenu taskMenu = new TaskMenu();
  private ProjectMember projectMember;
  private Item item;
  
  public void service(ProjectMember projectMember, Item item) {
    this.projectMember = projectMember;
    this.item = item;
    ApplicationContext appContext = item.getAppContext();
    appContext.addBean("projectNo", (Integer)projectMember.getProjectNo());
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
      case "2": doMenu("project/update.do"); break;
      case "3": toBoard(); break;
      case "4": toTask(); break;
      case "5": deleteProject(); break;
      case "9": break;
      default : doErr(); 
    }
  }
  
  private Object doMenu(String input) {
    RequestHandler requestHandler = 
        item.getRequestHandlerMapping().getRequestHandler(input);
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
      return method.invoke(obj, args.toArray());
    } catch (Exception e) {
      System.out.println("명령 처리중 에러 발생");
      return null;
    }
  }

  private void printProjectInfo() {
    Project project = (Project)doMenu("project/select.do");
    System.out.println(project);
  }

  private void updateProject() {
    System.out.println("프로젝트 수정");
  }
  
  private void toBoard() {
    boardMenu.service(projectMember, item);
  }
  
  private void toTask() {
    taskMenu.service(projectMember, item);
  }
  
  private void deleteProject() {
    System.out.println("프로젝트 삭제(팀장 전용)");
  }

  private void doErr() {
    System.out.println("잘못 입력하셨습니다.");
  }
}
