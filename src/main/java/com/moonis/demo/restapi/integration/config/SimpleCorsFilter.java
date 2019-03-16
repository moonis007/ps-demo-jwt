package com.moonis.demo.restapi.integration.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)arg1;
		String ogn=req.getHeader("origin");
		if (ogn != null) {
			if (req.getHeader("origin").equalsIgnoreCase("http://localhost:4200")
					|| req.getHeader("origin").equalsIgnoreCase("https://skils.io")) {
				res.addHeader("Access-Control-Allow-Origin", req.getHeader("origin"));
			}
		} else {
			res.addHeader("Access-Control-Allow-Origin", null);
		}	
		//res.addHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,PUT,DELTE");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Headers","*");
		//res.setHeader("Access-Control-Allow-Headers","Content-Type, Accept, X-Requested-With, remember-me, authorization, x-auth-token");
		
		if("OPTIONS".equalsIgnoreCase(req.getMethod())){
			res.setStatus(HttpServletResponse.SC_ACCEPTED);
		}
		else {			
			arg2.doFilter(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}