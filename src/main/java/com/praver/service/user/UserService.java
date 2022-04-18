package com.praver.service.user;

import com.praver.pojo.User;

import java.util.List;

public interface UserService {
    //用户登陆
    public User Login(String userCode,String password);

    //根据用户id修改密码
    public boolean updatePwd(int id,String  password);

    //查询记录数
    public int getUserCount(String username,int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo,int pageSize);

    //添加用户
    public boolean add(User user);

    //根据用户id删除用户
    public boolean deleteUserById(Integer delId);

    //根据用户id得到当前用户
    public User getUserById(String id);

    //修改用户信息
    public Boolean modify(User user) throws Exception;
}
