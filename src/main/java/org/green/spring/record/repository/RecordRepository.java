package org.green.spring.record.repository;

import java.util.List;

import org.green.spring.record.domain.RecordDto;

public interface RecordRepository {
	
	public List<RecordDto> selectList();

	public RecordDto select(String userId);
}
