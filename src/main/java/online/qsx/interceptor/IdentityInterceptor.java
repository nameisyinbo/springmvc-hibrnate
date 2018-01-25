package online.qsx.interceptor;

import online.qsx.model.LoginModel;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentityInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginModel loginModel =(LoginModel)request.getSession().getAttribute("loginModel");
        if (loginModel !=null) {
            return true; // 继续往后
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return false;// 不往后走
        }
    }
}
