package com.dimon.xcrm.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.dimon.xcrm.dao.XuserMapper;
import com.dimon.xcrm.pojo.Xuser;
import com.dimon.xcrm.util.RequestUtils;

@Component
public class LoginLogic {
	
	/**
	 * logging mechanism.
	 */
	private static Logger logger = LoggerFactory.getLogger(LoginLogic.class);
	@Autowired
	private XuserMapper userDao;
	
	public static HttpSession webSession;
	
	public String successLogin(HttpServletRequest request){
		String accountNo = RequestUtils.getString(request, "accountNo");
		Xuser user = userDao.selectByAcctNo(accountNo);
		webSession = request.getSession();
		webSession.setAttribute("loginObj", user);
		String ipAddr = RequestUtils.getIpAddr(request);
		System.out.println(ipAddr);
		return null;
	}
	
	public static void main(String[] args) {
		logger.debug("输出{}日志"+"debug");
		logger.info("输出{}日志"+"info");
		logger.error("输出{}日志"+"error");
	}
}
