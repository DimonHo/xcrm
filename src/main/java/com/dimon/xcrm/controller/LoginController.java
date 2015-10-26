package com.dimon.xcrm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dimon.xcrm.dao.XUserMapper;
import com.dimon.xcrm.logic.LoginLogic;
import com.dimon.xcrm.pojo.XUser;
import com.dimon.xcrm.util.RequestUtils;
import com.dimon.xcrm.util.ResponseUtils;

@Controller
public class LoginController {
	private static Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Resource
	private XUserMapper userDao;
	@Autowired
	private LoginLogic loginLogic;
	
	/**
	 * 登陆成功
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/successLogin")
	public ModelAndView successLogin(HttpServletRequest request,ModelAndView model){
		
		String pageObj = loginLogic.successLogin(request);
	    model.addObject("user", pageObj);
		model.setViewName("main");
		return model;
	}
	
	/**
	 * 登陆表单校验
	 * @param request
	 * @param response
	 */
	@RequestMapping("/validateLogin")
	public void validateLogin(HttpServletRequest request, HttpServletResponse response){
		//获取form表单数据
		String loginObj = RequestUtils.getString(request, "loginObj");
		//JSON字符串序列化成JSON对象
		JSONObject loginJosn = JSONObject.parseObject(loginObj);
		String accountNo = loginJosn.getString("accountNo");
		String pwd = loginJosn.getString("pwd");
		//根据账号查询用户名是否存在
		XUser selectUser = userDao.selectByAcccountNo(accountNo);
		JSONObject result = new JSONObject();
		
		if (null == selectUser){
			result.put("accountMsg", "用户名不存在");
		}else if (!pwd.equals(selectUser.getPwd())){
			result.put("pwdMsg", "用户名密码错误");
		}else {
			result.put("user",selectUser);
		}
		String resultStr = result.toJSONString();
		
		ResponseUtils.send(response, resultStr);
	}
}
