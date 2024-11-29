package dao;

import java.lang.reflect.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.JenisMember;

public class MemberDao {

    private final  SqlSessionFactory sqlSessionFactory;

    public MemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.insert("mapper.member.insert", member);
        }
        return result;
    }

    public int update(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.update("mapper.member.update", member);
        }
        return result;
    }

    public int delete(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.delete("mapper.member.delete", member);
        }
        return result;
    }

    public List<Member> findAll(){
        list<Member> result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.selectList("mapper.member.findAll");
        }
        return result;
    }
}
