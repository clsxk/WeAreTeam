package org.green.spring.match.service;

import java.util.List;

import org.green.spring.match.domain.MatchDto;

public interface MatchService {

	public MatchDto register(MatchDto dto);
	
	public List<MatchDto> getList(String teamName);
	
	public MatchDto get(int matchNo);
	
	public boolean modify(MatchDto dto);
	
	public boolean remove(int matchNo);
	
}
