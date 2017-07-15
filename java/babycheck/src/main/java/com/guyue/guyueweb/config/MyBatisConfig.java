package com.guyue.guyueweb.config;

/**
 * Created by sunxiaodong on 2016/11/12.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages={"com.guyue.guyueweb.mapper"})
@Slf4j
@ConditionalOnClass({ EnableTransactionManagement.class })
public class MyBatisConfig {
    private Class<? extends DataSource> datasourceType = DruidDataSource.class;

    @Bean(name = "slowsqlcenterDataSource")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().type(datasourceType).build();
    }

    @Bean(name = "babycheckDataSource")
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().type(datasourceType).build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    @DependsOn("slowsqlcenterDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("slowsqlcenterDataSource") DataSource slowsqlcenterDataSource,
                                               @Qualifier("babycheckDataSource") DataSource babycheckDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DbContextHolder.DbType.SLOWSQLCENTER, slowsqlcenterDataSource);
        targetDataSources.put(DbContextHolder.DbType.BABYCHECK, babycheckDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(babycheckDataSource);
        return dataSource;
    }
    @Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DynamicDataSource dynamicDataSource) throws IOException, ClassNotFoundException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        org.springframework.core.io.Resource[] mapperResources = new PathMatchingResourcePatternResolver()
        		// 扫描mapper
        				.getResources("classpath*:/com/guyue/guyueweb/mapperxml/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperResources);
        sqlSessionFactoryBean.setTypeAliasesPackage("classpath*:/com/guyue/guyueweb/mapper/*");
		return sqlSessionFactoryBean;
	}
    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
