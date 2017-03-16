package com.xmq.websocket.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import com.xmq.websocket.socket.SocketHandler;


/**
 * @desp Socket控制器
 *
 */
@Controller
public class SocketController{
	
	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	
	@Autowired
	private SocketHandler socketHandler;
	
	@RequestMapping(value="/login")
	public String login(HttpSession session){
		logger.info("用户登录了建立连接啦");
		
		session.setAttribute("user", "xmq");
		
		return "home";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String sendMessage(){
		
		socketHandler.sendMessageToUser("xmq", new TextMessage("这是一条测试的消息"));
		
		return "message";
	}

}
