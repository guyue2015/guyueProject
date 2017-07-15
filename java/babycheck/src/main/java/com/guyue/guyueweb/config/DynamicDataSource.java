package com.guyue.guyueweb.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
* @ClassName: DynamicDataSource  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2017年7月15日 下午3:14:18 
*
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
