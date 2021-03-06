package bitcamp.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.TaskDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.domain.Task;
import bitcamp.pms.util.CommandUtil;

@Controller
@RequestMapping("task/")
public class TaskController {
  private TaskDao taskDao;
  private Member loginMember;
  
  public void setTaskDao(TaskDao taskDao) {
    this.taskDao = taskDao;
  }
  
  public void setLoginMember(Member loginMember) {
    this.loginMember = loginMember;
  }

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    try {
      Task task = new Task();  
      System.out.print("작업이름? ");
      task.setTitle(keyScan.nextLine());
      task.setProjectNo(1);
      task.setMemberNo(loginMember.getNo());
      System.out.print("작업내용? ");
      task.setContent(keyScan.nextLine());
      System.out.print("시작일? ");
      task.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("종료일? ");
      task.setEndDate(Date.valueOf(keyScan.nextLine()));
      
      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {      
        taskDao.insert(task);
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }

  @RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 작업 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "삭제하시겠습니까?")) {
        int count = taskDao.delete(no);
        if (count > 0) System.out.println("삭제하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }

  @RequestMapping("list.do")
  public void list() {
    try {
      taskDao.list();
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }

  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 작업 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      Task task = taskDao.selectOne(no);      
      
      System.out.printf("작업이름? (기존 작업이름명: %s)", task.getTitle());
      task.setTitle(keyScan.nextLine());
      task.setProjectNo(1);
      task.setMemberNo(loginMember.getNo());
      System.out.printf("작업내용? (기존 작업내용명: %s)", task.getContent());
      task.setContent(keyScan.nextLine());
      System.out.printf("작업시작일? (기존 작업시작일: %s)", task.getStartDate());
      task.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.printf("작업종료일? (기존 작업종료일: %s)", task.getEndDate());
      task.setEndDate(Date.valueOf(keyScan.nextLine()));
      
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = taskDao.update(task);
        if (count > 0) System.out.println("변경하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }
}
