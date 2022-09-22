package org.green.spring.record.service;

import java.util.List;

import org.green.spring.member.service.MemberServiceImpl;
import org.green.spring.record.domain.RecordDto;
import org.green.spring.record.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RecordServiceImpl implements RecordService{

	@Autowired
	private RecordRepository repository;
	
	@Override
	public List<RecordDto> getList() {
		log.info("record getList...");
		return repository.selectList();
	}

	@Override
	public RecordDto get(String userId) {
		log.info("record get......");
		return repository.select(userId);
	}

}
