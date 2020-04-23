package org.sang.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @author Ma on 20191024
 */
@Configuration
public class MyBatisConfig {
    @Autowired
    @Qualifier("dsOne")
    DataSource dsOne;
    @Autowired
    @Qualifier("dsTwo")
    DataSource dsTwo;

    //数据源1配置
    @Bean
    SqlSessionFactory sqlSessionFactoryBean1(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dsOne);
        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1(ApplicationContext applicationContext) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1(applicationContext));
    }

    //数据源2配置
    @Bean
    SqlSessionFactory sqlSessionFactoryBean2(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dsTwo);
        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate2(ApplicationContext applicationContext) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean2(applicationContext));
    }
}
