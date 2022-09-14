package org.green.spring.member.service;

import java.util.List;

import org.green.spring.member.domain.MemberDto;

public interface MemberService {

	public MemberDto register(MemberDto dto);
	
	public MemberDto get(String userId);
	
	public List<MemberDto> getList();
	
	public boolean remove(String userId);
}
