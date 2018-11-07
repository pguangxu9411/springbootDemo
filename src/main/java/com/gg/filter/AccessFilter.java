package com.gg.filter;
//
//import com.ppp.login.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class AccessFilter implements Filter {
//    @Autowired
//    ServletContext servletContext;
//    @Autowired
//    LoginService service;
//    @Override
//    public void init(FilterConfig cfg)
//            throws ServletException {
//        servletContext =
//                cfg.getServletContext();
//    }
//    @Override
//    public void destroy() {
//
//    }
//    @Override
//    public void doFilter(ServletRequest req,
//                         ServletResponse res,
//                         FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest request=
//                (HttpServletRequest)req;
//        HttpServletResponse response=
//                (HttpServletResponse)res;
//        //获取请求的路径
//        String path =
//                request.getRequestURI();
////        String reg = ".*edit\\.html$";
//        String reg = ".*home$";
//        //如果是home就检查是否登录
//        if(path.matches(reg)){
//            checkLogin(request, response, chain);
//            return;
//        }
//        reg = ".*\\.mlgb";
//        //检查修改操作是否登录
//        if(path.matches(reg)){
//            checkdo(request, response, chain);
//            return;
//        }
//        chain.doFilter(request, response);
//    }
//    private void checkdo(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain chain) throws IOException, ServletException {
//        String name = "mlgbCookie";
//        String value = null;
//        value = getCookie(request, name, value);
//        if(! checkToken(value)){
//            //返回json字符串
//            String json = "{\"state\":1, "
//                    + "\"message\":\"必须登录!\"}";
//            response.setContentType(
//                    "application/json;charset=UTF-8");
//            response.getWriter().println(json);
//            return;
//        }
//        chain.doFilter(request, response);
//    }
//    private void checkLogin(
//            HttpServletRequest request,
//        HttpServletResponse response,
//        FilterChain chain)
//            throws IOException, ServletException {
//            //读取cookie 检查是否登录了
//        String name = "mlgbCookie";
//        String value = null;
//        value = getCookie(request, name, value);
//        if(! checkToken(value)){//没有cookie没有登录
//            //重定向到 登录页面
//            String path="login";
//            response.sendRedirect(path);
//            return;
//        }
//        //有cookie就通过
//        chain.doFilter(request, response);
//    }
//    private boolean checkToken(String value) {
//
//        if(value==null){
//            return false;
//        }
//        String[] data=value.split("@");
//        if(data.length!=2){
//            return false;
//        }
//        String userId=data[0];
//        String token = data[1];
//        boolean pass = service.checkToken(
//                userId, token);
//        return pass;
//    }
//    //获取Cookie值
//    private String getCookie(HttpServletRequest request, String name, String value) {
//        Cookie[] cookies=request.getCookies();
//        for (Cookie cookie : cookies) {
//            if(cookie.getName().equals(name)){
//                value=cookie.getValue();
//            }
//        }
//        return value;
//    }
//}
