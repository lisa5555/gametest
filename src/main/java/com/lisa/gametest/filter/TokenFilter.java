package com.lisa.gametest.filter;

import com.lisa.gametest.utils.MD5Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/*")
public class TokenFilter implements Filter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        String uri = req.getRequestURI();
        String method = req.getMethod();
        if(uri.contains("createVcode")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 修改请求头中数据后，会先发送提交类型是options的请求
        if(method.equals("OPTIONS")){
            return;
        }

        if(uri.contains("login")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //String name = req.getHeader("name");
            String token = req.getHeader("token");
            //System.out.println(name);
            System.out.println(token);
            if(token != null){
                // 从redis中取值
                String name = redisTemplate.opsForValue().get("token");
                String token2 = MD5Utils.md5(name + "haha");
                if (token != null && token.equals(token2)) {// 合法用户
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    String head = req.getHeader("x-requested-with");
                    // 判断是否ajax请求
                    if(head != null && head.equals("XMLHttpRequest")){
                        resp.getWriter().write("{\"code\":2}");
                        return;
                    }else {
                        // 跳转到登陆页面
                        resp.sendRedirect("http://127.0.0.1:8020/qiantaitest/baoming/login.html");
                        return;
                    }
                }
            }else{
                String head = req.getHeader("x-requested-with");
                // 判断是否ajax请求
                if(head != null && head.equals("XMLHttpRequest")){
                    resp.getWriter().write("{\"code\":2}");
                    return;
                }else {
                    // 跳转到登陆页面
                    resp.sendRedirect("http://127.0.0.1:8020/qiantaitest/baoming/login.html");
                    return;
                }
            }




        }

    }

    @Override
    public void destroy() {

    }
}
