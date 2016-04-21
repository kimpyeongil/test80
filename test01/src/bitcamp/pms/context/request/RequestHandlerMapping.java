package bitcamp.pms.context.request;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.context.ApplicationContext;

public class RequestHandlerMapping {
  ApplicationContext appContext;
  HashMap<String, RequestHandler> handlerMap = new HashMap<>();

  public RequestHandlerMapping(ApplicationContext appContext) {
    this.appContext = appContext;
    Map<String, Object> controlsMap = appContext.getBeansWithAnnotation(Controller.class);
    Collection<Object> controllers = controlsMap.values();
    
    RequestMapping classAnno = null;
    String baseName = "";
    
    Method[] methods = null;
    RequestMapping anno = null;    
    
    for (Object controller : controllers) {
      classAnno = controller.getClass().getAnnotation(RequestMapping.class);
      baseName = (classAnno != null) ? classAnno.value() : "";
      
      methods = controller.getClass().getMethods();
      for (Method method : methods) {
        anno = method.getAnnotation(RequestMapping.class);
        if (anno == null)
          continue;
        handlerMap.put(baseName + anno.value(), new RequestHandler(method, controller));
      }
    }    
  }

  public RequestHandler getRequestHandler(String name) {
    return handlerMap.get(name);
  }   
}
