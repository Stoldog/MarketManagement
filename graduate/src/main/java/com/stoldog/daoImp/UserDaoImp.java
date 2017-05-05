package com.stoldog.daoImp;


import com.stoldog.entity.User;
import com.stoldog.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RL on 2017/4/8.
 */
@Repository("userDao")
public class UserDaoImp extends CommonDaoImp{
    //比对用户
    public User userCheck(User user) throws SQLException {
        String sql="SELECT * FROM users WHERE username=? AND PASSWORD=?";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        User yy= runner.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        System.out.println(yy);
        return yy;
    }
    //查询所有的销售员
    public List getSellManList() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT uid,username FROM users WHERE departType=2";
        return queryRunner.query(sql,new MapListHandler());
    }
    //查询所有的职务
    public List getDepartList() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select departName,departValue from departType where departValue>0";
        return queryRunner.query(sql,new MapListHandler());
    }
    //查询所有的用户
    public List getAllUsers() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from users";
        return queryRunner.query(sql,new MapListHandler());
    }
    //查询所有的用户By职务
    public List getUsersByDepartType(Integer departType) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from users where departType=?";
        return queryRunner.query(sql,new MapListHandler(),departType);
    }
    //修改用户
    public Integer editUser(User user) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update users set username=?,password=?,sex=?,tel=?,email=?,department=?,departType=? where uid=?";
        return queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getTel(),user.getEmail(),user.getDepartment(),user.getDepartType(),user.getUid());
    }

    public Integer delUser(Integer uid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="delete from users where uid=?";
        return queryRunner.update(sql,uid);
    }
}
