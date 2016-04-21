package bitcamp.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Board;

@Component
public class BoardDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Board> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("BoardDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Board selectOne(int no) throws Exception {   
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("BoardDao.selectOne", no);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int insert(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert("BoardDao.insert", board);      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }  
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete("BoardDao.delete", no);       
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void list() throws Exception {
    List<Board> boards = this.selectList();    
    for (Board board : boards) {
      System.out.println(board);
    }
  }
  
  public int update(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("BoardDao.update", board); 
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
}
