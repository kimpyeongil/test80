package bitcamp.pms.domain;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandlerMapping;

public class Item {
  private ApplicationContext appContext;
  private RequestHandlerMapping requestHandlerMapping;
  
  public ApplicationContext getAppContext() {
    return appContext;
  }
  
  public void setAppContext(ApplicationContext appContext) {
    this.appContext = appContext;
  }
  
  public RequestHandlerMapping getRequestHandlerMapping() {
    return requestHandlerMapping;
  }
  
  public void setRequestHandlerMapping(RequestHandlerMapping requestHandlerMapping) {
    this.requestHandlerMapping = requestHandlerMapping;
  }  
}
