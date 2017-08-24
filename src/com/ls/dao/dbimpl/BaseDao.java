package com.ls.dao.dbimpl;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/21 12:34.
 * To Be or Not to Be
 */
public class BaseDao {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/cinema";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    //获取连接
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
        }
        return con;
    }

    //增删改操作
    public boolean update(String sql, List parms) {
        Connection conn = null;
        PreparedStatement statement = null;
        conn = getConnection();
        int i = 0;
        try {
            statement = conn.prepareStatement(sql);
            for (int j = 0; j < parms.size(); j++) {
                statement.setObject(j + 1, parms.get(j));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,conn, statement);
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public void close(ResultSet rs,Connection connection,
                      PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭出错");
        }
    }

    //查询
    public <T>List<T> query(String sql, List<Object> parms, Class<T> als) {
        List<T> list = new ArrayList();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        conn=getConnection();
        ResultSetMetaData metaData = null;
        try {
            statement = conn.prepareStatement(sql);
            if (parms != null) {
                for (int i = 0; i < parms.size(); i++) {
                    statement.setObject(i + 1, parms.get(i));
                }
            }
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //获取表的结构
            metaData = rs.getMetaData();
            while (rs.next()){
                T t=als.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    Object obj=rs.getObject(columnName);
                    Field field=als.getDeclaredField(formatString(columnName));
                    field.setAccessible(true);
                    field.set(t,obj);// 将查询到的值赋值给t对象
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }finally {
            close(rs, conn, statement);
        }
        if (list.size()>0){
            return list;
        }
        return null;
    }
    public static String formatString(String s){
        String[] split = s.split("_");
        s=split[0];
        for (int i = 1; i < split.length; i++) {
            String s1;
            char c = split[i].charAt(0);
            c-=32;
            s1=c+split[i].substring(1);
            s+=s1;
        }
        return s;
    }
}
