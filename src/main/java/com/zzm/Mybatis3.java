package com.zzm;

import com.zzm.dao.BlogMapper;
import com.zzm.entity.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-07-22
 * @time 19:26
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>  User user = mapper.selectUser(1);
 * --------------------------------------------------
 * </pre>
 */
public class Mybatis3 {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();
            Blog blog = session.selectOne(
                    "com.zzm.dao.BlogMapper.selectBlog", 1);
            System.out.println(blog);


        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog1 = mapper.selectBlog(2);

        System.out.println(blog1);



    }



}
