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
			loginFailMessage = "������ ã�� �� �����ϴ�."; 
		} else if (exception instanceof BadCredentialsException) {
			loginFailMessage = "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�."; 
			request.setAttribute("loginFailMessage", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else {
			loginFailMessage = "�ý��� ������ �α��ο� �����߽��ϴ�."; 
		}
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/customLoginFail?loginFailMessage="+loginFailMessage).forward(request,response);
	}

}