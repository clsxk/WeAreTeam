package org.green.spring.member.service;

import java.security.Principal;
import java.util.List;

import org.green.spring.member.domain.MemberDto;

public interface MemberService {

	public MemberDto register(MemberDto dto);
	
	public MemberDto get(String userId);
	
	public List<MemberDto> getList(String teamName);
	
	public boolean modify(MemberDto dto);
	
	public boolean remove(String userId);
	
	public boolean create(MemberDto dto);
	
	public MemberDto getTeam(String teamName);
	
	public List<MemberDto> getListTeam();
	
	public boolean modifyTeam(MemberDto dto);
	
	public boolean modifyAccess(MemberDto dto);
	
	public boolean modifyDenied(MemberDto dto);
	
	public List<MemberDto> getStandbyList(String teamName);
}
