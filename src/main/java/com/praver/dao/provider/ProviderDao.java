package com.praver.dao.provider;

import com.praver.pojo.Pro;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {

    //通过供应商名称、编码获取供应商列表
    public List<Pro> getProviderList(Connection connection, String proName, String proCode)throws Exception;

    //通过proId获取Provider
    public Pro getProviderById(Connection connection, String id)throws Exception;

    //修改供应商信息
    public int modify(Connection connection, Pro provider)throws Exception;

    //添加供应商信息
    public int add(Connection connection, Pro provider)throws Exception;

    //通过proID删除
    public int deleteProviderById(Connection connection, String delId)throws Exception;

}
