package com.stoldog.daoImp;

import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by RL on 2017/4/23.
 */
@Repository
public class CommonDaoImp {
    //获得表内数据的总数
    public Long getTableCount(String tableName) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT COUNT(*) FROM "+tableName;
        return (Long) queryRunner.query(sql,new ScalarHandler());
    }


}
