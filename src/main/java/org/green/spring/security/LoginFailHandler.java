package org.green.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String loginFailMessage;
		if (exception instanceof InternalAuthenticationServiceException) {
			loginFailMessage = "계정을 찾을 수 없습니다."; 
		} else if (exception instanceof BadCredentialsException) {
			loginFailMessage = "아이디 또는 비밀번호가 일치하지 않습니다."; 
			request.setAttribute("loginFailMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
		} else {
			loginFailMessage = "시스템 오류로 로그인에 실패했습니다."; 
		}
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/customLoginFail?loginFailMessage="+loginFailMessage).forward(request,response);
	}

}