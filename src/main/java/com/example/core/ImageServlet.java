package com.example.core;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by whydda on 2017-05-25.
 * 이미지파일을 보여주기 위한 custom servlet
 */
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //servlet 이 먼저 올라가서 프로퍼티 정보를 @VALUE ANNOTATION 으로는 가져오지 못함
        InputStream is = getClass().getResourceAsStream("/config/application.properties");
        Properties pro = new Properties();
        pro.load(is);

        String filePath = "";
        if(req.getRequestURI().indexOf("/image") == 0){
            filePath = pro.getProperty("image.view.real.path") + req.getRequestURI();
        }

        try(FileInputStream fi = new FileInputStream(filePath)){
            resp.setContentType("image/jpeg");
            IOUtils.copy(fi, resp.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
