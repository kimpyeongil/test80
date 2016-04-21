package bitcamp.pms.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.domain.Task;

public class TaskController implements Controller {

  private Scanner keyScan;
  private ArrayList<Task> tasks;
  
  public TaskController() throws Exception {
  tasks = new ArrayList<>();
  }

  public void insert() {
  Task task = new Task();

  System.out.print("작업명? ");
  task.setTitle(keyScan.nextLine());

  System.out.print("작업내용? ");
  task.setContent(keyScan.nextLine());

  System.out.print("시작일? ");
  task.setStartDate(Date.valueOf(keyScan.nextLine()));

  System.out.print("종료일? ");
  task.setEndDate(Date.valueOf(keyScan.nextLine()));
  }

  public void delete() {
    System.out.print("삭제할 작업 번호는? ");
    int no = Integer.parseInt(keyScan.nextLine());
    
    if (confirm("정말 삭제하시겠습니까? ")) {
      tasks.remove(no);
      System.out.println("삭제 완료하였습니다. ");
    } else {
      System.out.println("삭제를 취소하였습니다. ");
    }
    
  }

  public void update() {
    System.out.print("변경할 작업 번호는? ");
    int no = Integer.parseInt(keyScan.next());
    
    Task oldTask = tasks.get(no);
    Task task = new Task();
    
    System.out.print("작업명? ");
    task.setTitle(keyScan.nextLine());

    System.out.print("작업내용? ");
    task.setContent(keyScan.nextLine());

    System.out.print("시작일? ");
    task.setStartDate(Date.valueOf(keyScan.nextLine()));

    System.out.print("종료일? ");
    task.setEndDate(Date.valueOf(keyScan.nextLine()));
    
    if(confirm("변경하시겠습니까? ")) {
      tasks.set(no, task);
      System.out.println("변경하였습니다. ");
    } else {
      System.out.println("변경을 취소하였습니다. ");
    }
    
  }

  
  public void list() {
   Task task = null;
   for (int i = 0; i < tasks.size(); i++) {
     task = tasks.get(i);
     System.out.printf("%d, &s,", i, task.toString());
   }
  }

  private boolean confirm(String message) {
  while (true) {
    System.out.printf("%s(y/n) ", message);
    String input = keyScan.nextLine().toLowerCase();
    if (input.equals("y")) {
      return true;
    } else if (input.equals("n")) {
      return false;
    } else {
      System.out.println("잘못된 명령어입니다.");
    }
   }
  }

}
