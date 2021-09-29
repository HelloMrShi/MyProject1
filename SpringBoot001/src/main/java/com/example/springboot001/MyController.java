package com.example.springboot001;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
public class MyController {

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String str) {
        return "Hello 史先生";
    }

    @ResponseBody
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(String str) {
        return "Hello " + str;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3(String str) {
        return "index";
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String hello4(String str) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        String url = "jdbc:mysql://192.168.3.60:3307/wwwt_wt";
        String user = "wztkt";
        String password = "bus365_0502";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT userid, username, aliasid, aliasname FROM useralias WHERE username = 'WXoVgPAwmF5fPyyJ32I2CRosfC1na4'");
        //如果有数据，rs.next()返回true
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        return "index";
    }

}
