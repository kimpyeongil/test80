package bitcamp.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Member;

@Component
public class MemberDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Member> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("MemberDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);    
    try {
      return sqlSession.selectOne("MemberDao.selectOne", paramMap);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Member selectOneByEmail(String email) {
    SqlSession sqlSession = sqlSessionFactory.openSession();  
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);  
    try {
      return sqlSession.selectOne("MemberDao.selectOne", paramMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert("MemberDao.insert", member);      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }  
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete("MemberDao.delete", no);       
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void list() throws Exception {
    List<Member> members = this.selectList();    
    for (Member member : members) {
      System.out.println(member);
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("MemberDao.update", member); 
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public boolean isMember(String email, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession();    
    try {
      HashMap<String, String> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      int count = sqlSession.selectOne("MemberDao.isMember", paramMap);
      if (count > 0)
        return true;
      else 
        return false;
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }    
  }
}
