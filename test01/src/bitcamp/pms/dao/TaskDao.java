package bitcamp.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Task;

@Component
public class TaskDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Task> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("TaskDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Task selectOne(int no) throws Exception {   
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("TaskDao.selectOne", no);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int insert(Task task) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert("TaskDao.insert", task);      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }  
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete("TaskDao.delete", no);       
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void list() throws Exception {
    List<Task> tasks = this.selectList();    
    for (Task task : tasks) {
      System.out.println(task);
    }
  }
  
  public int update(Task task) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("TaskDao.update", task); 
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
}
