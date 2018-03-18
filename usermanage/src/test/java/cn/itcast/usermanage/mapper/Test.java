package cn.itcast.usermanage.mapper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.usermanage.domain.User;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;

    static{
        try{
        	inputStream  = Resources.getResourceAsStream("mybatis-config-new.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
   
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        User user = (User) session.selectOne("selectUserByID", 1);
        System.out.println(user.getUserName());
        } finally {
        session.close();
        }
    }
}