package com.hzgc;

import com.hzgc.project.system.user.domain.PzUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@Service(value = "SessionTimeoutInterceptor")
public class SessionTimeoutInterceptor implements HandlerInterceptor {


		//在请求处理之前进行调用（Controller方法调用之前
		@Override
		public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
			HttpSession seesion = httpServletRequest.getSession();
			PzUserInfo user = (PzUserInfo)seesion.getAttribute("user");
			if(user == null){
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
				return false;
			}
			return true;  //如果false，停止流程，api被拦截
		}


		//请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
		@Override
		public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
		}

		//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
		@Override
		public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		}

}
