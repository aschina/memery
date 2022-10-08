package com.example.memery.tool;


import android.util.Log;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public  class TableAction{

    public static DbManager dbUtils;

    static {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //设置数据库名，默认xutils.db
                .setDbName("soldiers.db")
                //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table){
                        Log.i("JAVA", "onTableCreated：" + table.getName());
                    }
                })
                //设置是否允许事务，默认true
                //.setAllowTransaction(true)
                //设置数据库路径，默认安装程序路径下
                //.setDbDir(new File("/mnt/sdcard/"))
                //设置数据库的版本号
                //.setDbVersion(1)
                //设置数据库更新的监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion,
                                          int newVersion) {
                    }
                })
                //设置数据库打开的监听
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能
                        db.getDatabase().enableWriteAheadLogging();
                    }
                });
        dbUtils = x.getDb(daoConfig);
    }



   
    public static<T> void dbAdd(T enity) throws DbException {
       dbUtils.replace(enity);
    }


    public static<T> void dbDelete(T enity) throws DbException {
        dbUtils.delete(enity);
    }

    public static<T> void dbAddorUpdate(T enity) throws DbException {
        dbUtils.saveOrUpdate(enity);
    }
    public static<T> void dbUpdate(T enity) throws DbException {
        dbUtils.update(enity);
    }

    
    public static   <T> List<T> dbSelectList( Class<T> tClass) throws DbException{
        return dbUtils.findAll(tClass);
    };
    
    public  static <T> T dbSelectSingle(Class<T> tClass) throws DbException{
        return dbUtils.findFirst(tClass);
    };
}
