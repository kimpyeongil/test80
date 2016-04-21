package bitcamp.pms.util;

import java.util.Scanner;

public class CommandUtil {
  
  public static boolean confirm(Scanner keyScan, String message) {
    String input = null;    
    while (true) {
      System.out.printf("%s ", message);
      input = keyScan.nextLine().toLowerCase();
      switch (input) {
        case "y": return true;
        case "n": return false;
        default: System.out.println("잘못된 명령어입니다.");
      }
    }
  }
}
