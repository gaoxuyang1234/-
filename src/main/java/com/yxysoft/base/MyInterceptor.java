package com.yxysoft.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object dIdObj= request.getSession().getAttribute("DID");
		String url= request.getRequestURI();
		//System.out.println("捕获请求:"+request.getRequestURI() );
		Integer dId=null;
		if(dIdObj!=null){
			dId=Integer.parseInt(dIdObj+"");
		}
		if(dId==null&&!url.equals("/accept/tologin")&&!url.equals("/acc/login")&&!url.equals("/usFile/sign")&&!url.equals("/usFile/login")){
			if(url.contains("/usFile")){
				Object USObj=request.getSession().getAttribute("USID");
				if(USObj==null){
					response.sendRedirect(request.getContextPath()+"/usFile/sign");
					return false;
				}else{
					return true;
				}
			}else{
				System.out.println("----dId-->"+dId);
				response.sendRedirect(request.getContextPath()+"/accept/tologin");
				return false;
			}
			
		}else{
			return true;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		 	
	}

}
