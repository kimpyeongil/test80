package bitcamp.pms.context;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;

public class ApplicationContext {
  HashMap<String,Object> objPool = new HashMap<>();
  
  public ApplicationContext(String basePackage) {
    String path = "./bin/" + basePackage.replace(".", "/");
    createObject(new File(path));
    injectDependency();
  }

  private void createObject(File file) {
    if (file.isFile() && file.getName().endsWith(".class")) {
      String classNameWithPackage = file.getPath()  
          .replace("./bin/", "")
          .replace(".\\bin\\", "")
          .replace(".class","")
          .replace("/", ".")                                        
          .replace("\\", "."); 
      try {
        Class<?> clazz = Class.forName(classNameWithPackage);
        Annotation[] annos = clazz.getAnnotations();
        for (Annotation anno : annos) {
          if (anno.annotationType() == Component.class) {
            processComponentAnnotation(clazz);
          } else if (anno.annotationType() == Controller.class) {
            processControllerAnnotation(clazz);
          }
        }        
      } catch(Exception e) {
        e.printStackTrace();
      }      
      return;
    }
    
    if (!file.isDirectory()) {
      return;
    }
    
    File[] subFiles = file.listFiles();
    for (File subFile : subFiles) {
      createObject(subFile);
    }    
  }
  
  private void processComponentAnnotation(Class<?> clazz) throws Exception {
    Component anno = clazz.getAnnotation(Component.class);
    String key = anno.value();    
    if(key.equals("")) {
      key = clazz.getName();
    }    
    objPool.put(clazz.getName(), clazz.newInstance());
  }
  
  private void processControllerAnnotation(Class<?> clazz) throws Exception {
    Controller anno = clazz.getAnnotation(Controller.class);
    String key = anno.value();    
    if(key.equals("")) {
      key = clazz.getName();
    }    
    objPool.put(clazz.getName(), clazz.newInstance());
  }

  private void injectDependency() {
    Collection<Object> objects = objPool.values();
    Class<?> clazz = null;
    Method[] methods = null;
    Class<?> paramType = null;
    Object dependency = null;
    
    for (Object obj : objects) {      
      clazz = obj.getClass();
      if (!(clazz.isAnnotationPresent(Component.class)) && 
          !(clazz.isAnnotationPresent(Controller.class))) {
        continue;
      }
      
      methods = clazz.getMethods();
      for (Method m : methods) {
        if (!m.getName().startsWith("set")) 
          continue;        
        paramType = m.getParameterTypes()[0]; 
        dependency = findObjectByType(paramType);        
        if (dependency == null) 
          continue;
        try {
          m.invoke(obj, dependency);
        } catch (Exception e) {}
      }
    }
  }
  
  private Object findObjectByType(Class<?> paramType) {
    Collection<Object> objects = objPool.values();
    for (Object obj : objects) {
      if (paramType.isInstance(obj)) 
        return obj;
    }
    return null;
  }
  
  public void addBean(String name, Object bean) {
    objPool.put(name, bean);
    injectDependency();
  }
  
  public Object getBean(String name) {
    return objPool.get(name);
  }
  
  public Object getBean(Class<?> type) {
    Collection<Object> objects = objPool.values();
    for (Object obj : objects) {
      if (type.isInstance(obj)) 
        return obj;
    }    
    return null;
  }
  
  public List<Object> getBeans(Class<?> beanType) {
    Collection<Object> objects = objPool.values();
    ArrayList<Object> list = new ArrayList<>();
    for (Object obj : objects) {
      if (beanType.isInstance(obj))
        list.add(obj);
    }    
    return list;
  }

  public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annoType) {
    Set<Entry<String,Object>> entrySet = objPool.entrySet();
    HashMap<String,Object> objMap = new HashMap<>();    
    Object obj = null;
    for (Entry<String,Object> entry : entrySet) {
      obj = entry.getValue();
      if (obj.getClass().getAnnotation(annoType) == null) continue;
      objMap.put(entry.getKey(), obj); 
    }
    return objMap;
  }
}
