package net.codog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import net.codog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: 拦截器，用于用户权限验证</p>
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //在请求处理之前进行调用Controller方法调用之前
        log.info("调用controller之前的拦截");
        //拦截规则：1.验证是否有权限
    	return userService.isHasPermission(Integer.parseInt((String)request.getSession().getAttribute("user_id")), request.getRequestURI());
        //return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //请求处理之后进行调用，但是在视图被渲染之前，Controller方法调用之后
        if(response.getStatus()==404){  
            modelAndView.setViewName("404");  
        }  
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行,主要是用于进行资源清理工作
    	
    }

}
