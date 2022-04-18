package com.praver.service.bill;

import com.praver.pojo.Bill;

import java.util.List;

public interface BillService {

    public List<Bill> getBillList(Bill bill);

    //添加订单
    public boolean add(Bill bill);

    public Bill getBillById(String id);

    public boolean modify(Bill bill);

    public boolean deleteBillById(String delId);
}
