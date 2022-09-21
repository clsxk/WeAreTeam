package org.green.spring.member.service;

import java.util.List;

import org.green.spring.member.domain.MemberDto;

public interface MemberService {

	public MemberDto register(MemberDto dto);
	
	public MemberDto get(String userId);
	
	public List<MemberDto> getList();
	
	public boolean modify(MemberDto dto);
	
	public boolean remove(String userId);
	
	public boolean create(MemberDto dto);
	
	public MemberDto getTeam(String teamName);
	
	public List<MemberDto> getListTeam();
}
