package com.stoldog.daoImp;


import com.stoldog.entity.User;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by RL on 2017/4/8.
 */
@Repository("userDao")
public class UserDaoImp extends CommonDaoImp{
    //查询用户
    public User userCheck(User user) throws SQLException {
        String sql="SELECT * FROM users WHERE username=? AND PASSWORD=?";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        User yy= runner.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        System.out.println(yy);
        return yy;
    }
}
