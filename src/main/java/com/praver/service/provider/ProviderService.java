package com.praver.service.provider;

import com.praver.pojo.Pro;

import java.util.List;

public interface ProviderService {

     //通过供应商名称、编码获取供应商列表-模糊查询-providerList
    public List<Pro> getProviderList(String proName, String proCode);

    public Pro getProviderById(String id);

    //修改用户信息
    public boolean modify(Pro provider);

    //添加供应商
    public boolean add(Pro provider);

    //删除供应商
    public int deleteProviderById(String delId);
}
