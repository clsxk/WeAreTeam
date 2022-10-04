package org.green.spring.match.service;

import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.MatchRecordDto;
import org.green.spring.match.domain.RecordDto;

public interface MatchService {

	public MatchDto register(MatchDto dto);
	
	public List<MatchDto> getList(String teamName);
	
	public MatchDto get(int matchNo);
	
	public boolean modify(MatchDto dto);
	
	public boolean remove(int matchNo);
	
	public RecordDto registerPoint(RecordDto dto);
	
	/* public boolean modifyPoint(RecordDto dto); */
	
	public List<RecordDto> getPoint(int matchNo);
	
	public boolean removePoint(int matchNo);
	
	public List<RecordDto> getListPoint(String teamName);
	
	public List<RecordDto> getRecordList(String teamName);
	
	public MatchRecordDto getMatch(String teamName);
}
