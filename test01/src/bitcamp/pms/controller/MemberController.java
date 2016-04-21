package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.util.CommandUtil;

@Controller
@RequestMapping("member/")
public class MemberController {
  private MemberDao memberDao;

  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    try {
      Member member = new Member();
      System.out.print("이름? ");
      member.setName(keyScan.nextLine());
      System.out.print("이메일? ");
      member.setEmail(keyScan.nextLine());
      System.out.print("암호? ");
      member.setPass(keyScan.nextLine());
      System.out.print("전화? ");
      member.setPhone(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        memberDao.insert(member);
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
      System.out.print("삭제할 회원의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "삭제하시겠습니까?")) {
        int count = memberDao.delete(no);
        if (count > 0) System.out.println("삭제하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아닙니다.");
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list() {    
    try {
      memberDao.list();
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }

  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 회원의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      Member member = memberDao.selectOne(no);
      System.out.printf("이름? (기존 이름: %s)", member.getName());
      member.setName(keyScan.nextLine());
      System.out.printf("이메일? (기존 이메일: %s)", member.getEmail());
      member.setEmail(keyScan.nextLine());
      System.out.printf("암호? (기존 암호: %s)", member.getPass());
      member.setPass(keyScan.nextLine());
      System.out.printf("전화? (기존 전화: %s)", member.getPhone());
      member.setPhone(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = memberDao.update(member);
        if (count > 0) System.out.println("변경하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아닙니다.");
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
}
