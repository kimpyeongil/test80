package bitcamp.pms;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.controller.AuthController;
import bitcamp.pms.util.Session;

public class ProjectApp {
  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Scanner keyScan = new Scanner(System.in);
  Session session = new Session();
  
  public ProjectApp() {
    appContext = new ApplicationContext("bitcamp.pms");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    appContext.addBean("stdinScan", keyScan);
    appContext.addBean("session", session);
    try {
      InputStream inputStream = 
          Resources.getResourceAsStream("conf/mybatis-config.xml");
      appContext.addBean("sqlSessionFactory", 
          new SqlSessionFactoryBuilder().build(inputStream));
    } catch (Exception e) {
      System.out.println("[mybatis 준비 실패] 시스템을 종료합니다.");
      return;
    }
  }
  
  public static void main(String[] args) {
    ProjectApp projectApp = new ProjectApp();
    projectApp.run();
  }  
  
  private void run() {
    AuthController authController = 
        (AuthController)appContext.getBean(AuthController.class);
    authController.service();      
    String input;
    do {
      input = prompt();
      processCommand(input);      
    } while (!input.equals("quit"));
    keyScan.close();    
  }
  
  private String prompt() {
    System.out.print("명령 > ");
    return keyScan.nextLine().toLowerCase();
  }
  
  private void processCommand(String input) {
    switch(input) {
      case "about": doAbout(); break;
      case "quit": doQuit(); break;
      default: doMenu(input);
    }
  }  
  
  private void doMenu(String input) {
    RequestHandler requestHandler = requestHandlerMapping.getRequestHandler(input);
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
        arg = appContext.getBean(param.getType());
        args.add(arg);
      }
      method.invoke(obj, args.toArray());
    } catch (Exception e) {
      System.out.println("명령 처리중 에러 발생");
    }
  }
  
  private void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 프로그램");
  }
  
  private void doQuit() {
    System.out.println("안녕히 가세요.");
  }
}
