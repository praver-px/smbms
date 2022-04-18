package com.praver.dao.bill;

import com.praver.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillDao {

    //通过查询条件获取供应商列表-模糊查询-getBillList
    public List<Bill> getBillList(Connection connection, Bill bill)throws Exception;

    //增加订单
    public int add(Connection connection, Bill bill)throws Exception;

    int getBillCountByProviderId(Connection connection, String delId) throws SQLException;

    public Bill getBillById(Connection connection, String id)throws Exception;

    public int modify(Connection connection, Bill bill)throws Exception;

    public int deleteBillById(Connection connection, String delId)throws Exception;
}
