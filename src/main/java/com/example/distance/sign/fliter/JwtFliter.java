package com.example.distance.sign.fliter;


import com.example.distance.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "JwtFilter", urlPatterns = {"/*"})
public class JwtFliter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger =  LoggerFactory.getLogger(getClass());
    }


    private Logger logger ;

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

//        System.out.println(request.getRequestURI());
        logger.info("REQUEST URI = "+request.getRequestURI());
        if (request.getRequestURI().startsWith("/sign/")
                || request.getRequestURI().startsWith("/static/")
                || request.getRequestURI().startsWith("/swagger")
                || request.getRequestURI().startsWith("/webjars")
                || request.getRequestURI().startsWith("/v2/")
                ) {
            // 登录或者获取静态资源， 直接放行

        } else {
            String jwt = null;
            try {
                jwt = request.getParameter("jwt");
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (jwt == null || JwtUtils.getUserId(jwt) == null) {
                // jwt 不存在或者不正确, 则跳转
                response.sendRedirect("/signin/");
            }
        }
        chain.doFilter(request, response);

    }


}

