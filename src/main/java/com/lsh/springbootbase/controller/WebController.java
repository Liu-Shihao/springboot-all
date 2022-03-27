package com.lsh.springbootbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/3/27 11:48 下午
 * @desc ：一个结构接收不同类型请求方式de参数
 *
 * 在 Java 中，一个接口只支持一种 content-type：
 * json 就用 @RequestBody，
 * form 表单就用 @RequestParam 或不写，
 * form-data 就用 MultipartFile。
 */
@RequestMapping("/web")
@RestController
public class WebController {

    @RequestMapping("/getParams")
    public Map<String,Object> m1(HttpServletRequest request){
        HashMap<String, Object> resp = new HashMap<>();
        String contentType = request.getContentType();
//        String name = (String)request.getAttribute("name");
//        String age = (String)request.getAttribute("age");
//        System.out.println("name:"+name);
//        System.out.println("age:"+age);
        if (contentType.contains("application/json")) {
            // json 解析...
            System.out.println("=======JSON=======");


//            Object attribute = request.getAttribute();
        } else if (contentType.contains("application/x-www-form-urlencoded")) {
            // form 表单解析 ...
            System.out.println("=======FORM=======");
        } else if (contentType.contains("multipart")) {
            // 文件流解析
            System.out.println("=======FORM-DATA=======");
        } else {
            throw new RuntimeException("不支持的content-type");
        }
        resp.put("contentType",contentType);
        resp.put("date",new Date());
        return resp;
    }
}
