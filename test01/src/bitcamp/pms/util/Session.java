package bitcamp.pms.util;

import java.util.HashMap;

public class Session {
  HashMap<String, Object> pool = new HashMap<>();
  
  public void setAttribute(String name, Object value) {
    pool.put(name, value);
  }
  
  public Object getAttribute(String name) {
    return pool.get(name);
  }
}
