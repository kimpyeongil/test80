package bitcamp.pms;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.controller.AuthController;
import bitcamp.pms.domain.Item;
import bitcamp.pms.menu.SubjectMenu;
import bitcamp.pms.util.Session;

public class ProjectApp {
  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Item item = new Item();
  SubjectMenu subMenu = new SubjectMenu();
  Scanner keyScan = new Scanner(System.in);
  Session session = new Session();
  
  public ApplicationContext getAppContext() {
    return appContext;
  }
  public RequestHandlerMapping getRequestHandlerMapping() {
    return requestHandlerMapping;
  }

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
    item.setAppContext(appContext);
    item.setRequestHandlerMapping(requestHandlerMapping);
    AuthController authController = 
        (AuthController)appContext.getBean(AuthController.class);
    authController.service(item);
    subMenu.service(authController.getLoginMember(), item);
    keyScan.close();
  }
  
}
