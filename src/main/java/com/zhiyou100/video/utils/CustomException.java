package com.zhiyou100.video.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("obj", obj);
		mav.addObject("exception", exception);
		mav.setViewName("role/error");
		return mav;
	}

}
