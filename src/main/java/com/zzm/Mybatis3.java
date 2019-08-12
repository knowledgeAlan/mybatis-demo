package com.zzm;

import com.zzm.dao.BlogMapper;
import com.zzm.entity.Blog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description zzm
 * @encoding UTF-8
 * @date 2019-07-22
 * @time 19:26
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>  User user = mapper.selectUser(1);
 * --------------------------------------------------
 *
 *
 * https://github.com/mybatis/mybatis-3/issues/215
 * </pre>
 */

public class Mybatis3 {

    private static final Logger logger = LoggerFactory.getLogger(Mybatis3.class);

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();
        Blog blog = session.selectOne(
                "com.zzm.dao.BlogMapper.selectBlog", 1);
        System.out.println(blog);
        session.commit();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog1 = mapper.selectBlog(1);
        System.out.println(blog1);


    }



}
