package com.guyue.guyueweb.config;

/**
 * 
* @ClassName: DbContextHolder  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2017年7月15日 下午3:14:08 
*
 */
public class DbContextHolder {

    public enum DbType {
        SLOWSQLCENTER,
        BABYCHECK
    }

    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

    public static void setDbType(DbType dbType) {
        if (dbType == null) {
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static DbType getDbType() {
    	return DbType.BABYCHECK;
//    	return DbType.SLOWSQLCENTER;
//        return contextHolder.get() == null ? DbType.SLOWSQLCENTER : contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
