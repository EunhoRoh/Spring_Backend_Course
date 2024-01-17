package com.example.spring_project_test_24_01_11.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//mybatis 장점이 뭐임?
// mybatis 제공하는 if문 그리고 string으로 바로 sql문 적기

@Configuration
@MapperScan(basePackages={"com.example.spring_project_test_24_01_11.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
public class MybatisConfig {
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //? 우리 entity 만들었나?
        // entity는 테이블 객체라고 생각하자.
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.spring_project_test_24_01_11.entity");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}