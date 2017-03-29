package cn.edu.muc.ilab.hbaseadmin.dao.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDao;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/25.
 */
@Repository
public class HTableDaoImpl implements HTableDao {
    @Autowired
    private HBaseAdmin hBaseAdmin;

    public boolean tableExists(TableName tableName){
        boolean result=false;
        try {
            result=hBaseAdmin.tableExists(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean tableExists(String tableName){
        boolean result=false;
        try {
            result=hBaseAdmin.tableExists(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public HTableDescriptor[] listTables(){
        HTableDescriptor[] hTableDescriptors =null;
        try {
            hTableDescriptors = hBaseAdmin.listTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }
    public HTableDescriptor[] listTables(Pattern pattern){
        HTableDescriptor[] hTableDescriptors =null;
        try {
            hTableDescriptors = hBaseAdmin.listTables(pattern);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }

    public HTableDescriptor[] listTables(String regex){
        HTableDescriptor[] hTableDescriptors =null;
        try {
            hTableDescriptors = hBaseAdmin.listTables(regex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }
}