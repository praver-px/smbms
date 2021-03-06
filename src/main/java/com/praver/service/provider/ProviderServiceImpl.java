package com.praver.service.provider;

import com.praver.dao.BaseDao;
import com.praver.dao.bill.BillDao;
import com.praver.dao.bill.BillDaoImpl;
import com.praver.dao.provider.ProviderDao;
import com.praver.dao.provider.ProviderDaoImpl;
import com.praver.pojo.Pro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProviderServiceImpl implements ProviderService{

    private ProviderDao providerDao;
    private BillDao billDao;
    public ProviderServiceImpl(){
        providerDao = new ProviderDaoImpl();
        billDao =  new BillDaoImpl();
    }


    public List<Pro> getProviderList(String proName, String proCode) {
        Connection connection = null;
        List<Pro> proList = null;

        try {
            connection = BaseDao.getConnection();
            proList = providerDao.getProviderList(connection,proName,proCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return proList;
    }

    public Pro getProviderById(String id) {
        Pro provider = null;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            provider = providerDao.getProviderById(connection, id);
        }catch (Exception e) {
            e.printStackTrace();
            provider = null;
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return provider;
    }

    public boolean modify(Pro provider) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            if(providerDao.modify(connection,provider) > 0)
                flag = true;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean add(Pro provider) {
        Connection connection = null;
        boolean flag =false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            if (providerDao.add(connection,provider)>0){
                flag =true;
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }



    /**
     * ???????????????ID??????????????????????????????????????????????????????????????????????????????
     * ???????????????????????????????????????????????????????????????
     * ??????????????????????????????????????????????????????
     * ?????????billCount
     * 1> billCount == 0  ??????---1 ?????? ???0??? 2 ????????? ???-1???
     * 2> billCount > 0    ???????????? ???????????????0?????????????????????-1???
     *
     * ---??????
     * ??????billCount = -1 ??????
     * ???billCount >= 0 ??????
     */
    public int deleteProviderById(String delId) {
        Connection connection = null;
        int billCount = -1;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            billCount = billDao.getBillCountByProviderId(connection,delId);
            if(billCount == 0){
                providerDao.deleteProviderById(connection, delId);
            }
            connection.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            billCount = -1;
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return billCount;

    }
}

