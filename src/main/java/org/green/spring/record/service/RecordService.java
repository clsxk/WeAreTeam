package org.green.spring.record.service;

import java.util.List;

import org.green.spring.record.domain.RecordDto;

public interface RecordService {
	
	public List<RecordDto> getList();
	
	public RecordDto get(String userId);

}
