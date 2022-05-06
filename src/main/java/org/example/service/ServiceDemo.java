package org.example.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.UserMapper;
import org.example.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all =  mapper.findAll();
        System.out.println(all);

        User user = mapper.findById(4);
        System.out.println(user);
        mapper.delete(1);


        User user1=new User();
        user1.setUsername("yuxingwei");
        user1.setPassword("123");
        mapper.insert(user1);

        User user2=new User();
        user2.setId(2);
        user2.setUsername("tom");
        user2.setPassword("aaa");
        mapper.update(user2);
        sqlSession.commit();
        sqlSession.close();
    }

}
