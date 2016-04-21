package bitcamp.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.pms.domain.Project;
import bitcamp.pms.util.CommandUtil;

@Controller
@RequestMapping("project/")
public class ProjectController {
  private ProjectDao projectDao;
  
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @RequestMapping("add.do")
  public void insert(Scanner keyScan) {
    try {
      Project project = new Project();
      System.out.print("프로젝트명? ");
      project.setTitle(keyScan.nextLine());
      System.out.print("시작일? ");
      project.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("종료일? ");
      project.setEndDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("설명? ");
      project.setDescription(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        projectDao.insert(project);
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 프로젝트의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "삭제하시겠습니까?")) {
        int count = projectDao.delete(no);
        if (count > 0) System.out.println("삭제하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list() {
    try {
      projectDao.list();
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 프로젝트의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      Project project = projectDao.selectOne(no);
      System.out.printf("프로젝트명? (기존 프로젝트명: %s)", project.getTitle());
      project.setTitle(keyScan.nextLine());
      System.out.printf("시작일? (기존 시작일: %s)", project.getStartDate().toString());
      project.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.printf("종료일? (기존 종료일: %s)", project.getEndDate().toString());
      project.setEndDate(Date.valueOf(keyScan.nextLine()));
      System.out.printf("설명? (기존 설명: %s)", project.getDescription());
      project.setDescription(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = projectDao.update(project);
        if (count > 0) System.out.println("변경하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
}
