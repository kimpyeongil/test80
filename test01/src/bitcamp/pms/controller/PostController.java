package bitcamp.pms.controller;

import java.util.List;
import java.util.Scanner;

import bitcamp.pms.domain.Post;

@Controller
@RequestMapping("post/")
public class PostController {
  private PostDao postDao;

  public void setPostDao(PostDao postDao) {
    this.postDao = postDao;
  }

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    Post post = new Post();

    System.out.print("제목? ");
    post.setTitle(keyScan.nextLine());

    System.out.print("내용? ");
    post.setContent(keyScan.nextLine());

    if (confirm(keyScan, "저장하시겠습니까?")) {
      try {
        postDao.insert(post);
        System.out.println("저장하였습니다.");
      } catch (Exception e) {
        System.out.println("데이터를 저장하는데 실패했습니다.");
      }
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }
  
  @RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 게시물 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      if (confirm(keyScan, "정말 삭제하시겠습니까?")) {
        int count = postDao.delete(no);
        if (count > 0) {
          System.out.println("삭제하였습니다.");
        } else {
          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        }
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
      List<Post> posts = postDao.selectList();
      
      for (Post post : posts) {
        System.out.printf("%d, %s, %s, %d, %s\n", post.getNo(),
            post.getTitle(), post.getContent(), post.getViews(),post.getCreatedDate());
      }
    } catch (Exception e) {
      throw new RuntimeException("게시물 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 게시물 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      Post post = postDao.selectOne(no);
      if (post == null) {
        System.out.println("유효하지 않은 번호입니다.");
        return;
      }
      
      System.out.printf("제목(%s)? ", post.getTitle());
      post.setTitle(keyScan.nextLine());
  
      System.out.printf("내용(%s)? ", post.getContent());
      post.setContent(keyScan.nextLine());
  
  
      if (confirm(keyScan, "변경하시겠습니까?")) {
        int count = postDao.update(post);
        if (count > 0) {
          System.out.println("변경하였습니다.");
        } else {
          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        }
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
  public static boolean confirm(Scanner keyScan, String message) {
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










