package bitcamp.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Project;

@Component
public class ProjectDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Project> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("ProjectDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Project selectOne(int no) throws Exception {   
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("ProjectDao.selectOne", no);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int insert(Project project) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert("ProjectDao.insert", project);      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }  
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete("ProjectDao.delete", no);       
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void list() throws Exception {
    List<Project> projects = this.selectList();    
    for (Project project : projects) {
      System.out.println(project);
    }
  }
  
  public int update(Project project) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("ProjectDao.update", project); 
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
}
