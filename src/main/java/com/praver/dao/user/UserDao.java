package com.praver.dao.user;

import com.praver.pojo.Role;
import com.praver.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到要登录的用户
    public User getLoggedUser(Connection connection, String userCode,String userPassword) throws SQLException;

    //修改当前用户密码
    public int updatePwd(Connection connection,int id, String password) throws SQLException;

    //根据用户名或角色查询用户的数量
    public int getUserCount(Connection connection,String username, int userRole)throws SQLException;

    //获取用户列表
    public List<User> getUserList(Connection connection,String userName,int userRole,int currentPageNo,int pageSize)throws Exception;

    //添加用户
    public int add(Connection connection,User user) throws SQLException;

    //通过用户id删除用户信息
    public int deleteUserById(Connection connection, Integer delId)throws Exception;

    //通过userId查看当前用户信息
    public User getUserById(Connection connection, String id)throws Exception;

    //修改用户信息
    public int modify(Connection connection, User user)throws Exception;

}
