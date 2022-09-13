package org.green.spring.security;

import org.green.spring.member.domain.CustomUser;
import org.green.spring.member.domain.MemberDto;
import org.green.spring.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		log.info("Load User By UserName : " + userName);
		MemberDto dto = repository.select(userName);
	
		if(dto == null) {
			throw new InternalAuthenticationServiceException("");
		} else {
			return new CustomUser(dto);
		}
			
	}

}
