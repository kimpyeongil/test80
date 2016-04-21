package bitcamp.pms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {  
  public static boolean checkEmail(String email) {
    Pattern emailPattern = Pattern.compile("[a-zA-Z][\\w\\.]*@([\\w+\\.])+\\.[a-zA-Z]{2,}");
    Matcher matcher = emailPattern.matcher(email);
    return matcher.matches();
  }
  
  public static boolean checkPassword(String password) {
    Pattern passwordPattern = Pattern.compile("(?=.*\\d)(?=.*[?!@])(?=.*[a-zA-Z])[a-zA-Z0-9?!@]{4,10}");
    Matcher matcher = passwordPattern.matcher(password);
    return matcher.matches();
  }
  
  public static boolean checkPhone(String phone) {
    Pattern phonePattern = Pattern.compile("(\\d{2,4}-\\d{3,4}-\\d{4})|(\\d{3,4}-\\d{4})");
    Matcher matcher = phonePattern.matcher(phone);
    return matcher.matches();
  }
}
