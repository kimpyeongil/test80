package bitcamp.pms.context.request;

import java.lang.reflect.Method;

public class RequestHandler {
  Method method;
  Object obj;
  
  public RequestHandler() {}

  public RequestHandler(Method method, Object obj) {
    this.method = method;
    this.obj = obj;
  }

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }
}
