package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;
import bitcamp.pms.util.CommandUtil;

@Controller
@RequestMapping("board/")
public class BoardController {
  private BoardDao boardDao;

  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    try {
      Board board = new Board();
      System.out.print("제목? ");
      board.setTitle(keyScan.nextLine());
      System.out.print("내용? ");
      board.setContent(keyScan.nextLine());
      System.out.print("암호? ");
      board.setPassword(keyScan.nextLine());           
      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        boardDao.insert(board);
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
      System.out.print("삭제할 게시판의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan, "삭제하시겠습니까?")) {
        int count = boardDao.delete(no);
        if (count > 0) System.out.println("삭제하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }      
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list() {    
    try {
      boardDao.list();
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {     
      System.out.print("변경할 게시판의 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      Board board = boardDao.selectOne(no);   
      System.out.printf("제목? (기존 게시판명: %s)", board.getTitle());
      board.setTitle(keyScan.nextLine());
      System.out.printf("내용? (기존 내용: %s)", board.getContent());
      board.setContent(keyScan.nextLine());
      System.out.printf("암호? (기존 암호: %s)", board.getPassword());
      board.setPassword(keyScan.nextLine());  
      
      
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = boardDao.update(board);
        if (count > 0) System.out.println("변경하였습니다.");
        else System.out.println("유효한 번호가 아닙니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch(IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아닙니다.");
    } catch(Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
      e.printStackTrace();
    }
  }
}
