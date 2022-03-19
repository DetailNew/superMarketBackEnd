package com.message.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.UUID;

public class UploadImage {
    public static final String BASE_PATH = "C:\\Users\\Administrator\\Desktop\\nginx-1.17.3\\dist\\images";

    public static String upload(MultipartFile file){
//        获取上传文件的名称
        String filename = file.getOriginalFilename();
//        为了保证图片在服务器中名字的唯一性，要用UUID来对名字进行改写
        String uuid = UUID.randomUUID().toString().replace("-","");
//        将生成的UUID和filename进行拼接
        String newFilename = uuid + "-" + filename;
//        创建文件实例
        File image = new File(BASE_PATH,newFilename);
//        对这个文件进行上传操作
        try {
            file.transferTo(image);
            System.out.println(newFilename);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                return null;
            }
            Connection conn = null;
            String jdbcPath = "jdbc:mysql://localhost:3306/message";
            String user = "root";
            String pass = "admin";
            PreparedStatement ps = null;
            ResultSet rs = null;
//            FileInputStream in = null;
            try {
                conn = DriverManager.getConnection(jdbcPath,user,pass);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                //从本地硬盘硬盘读取一张图片保存到数据库
//                in =new FileInputStream(BASE_PATH + "\\" + newFilename);
                ps=conn.prepareStatement("insert into message.photos(image) values(?)");
//                ps.setInt(1,2);
//                ps.setBinaryStream(2, in, in.available());
                ps.setString(1,"istarmarket.com/images/" + newFilename);
                ps.executeUpdate();
//                in.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return newFilename;
    }

}
