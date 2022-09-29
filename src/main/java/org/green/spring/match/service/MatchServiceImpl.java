package org.green.spring.match.service;

import java.util.List;


import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.RecordDto;
import org.green.spring.match.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private MatchRepository repository;
	
	@Override
	public MatchDto register(MatchDto dto) {
		String matchDate = dto.getMatchDate();
		String splitDate = matchDate.replace("T", " ");
		dto.setMatchDate(splitDate);
		log.info("Match register......" + dto);
		repository.insert(dto);
		int newNo = dto.getMatchNo();
		MatchDto insertDto = get(newNo);
		return insertDto;
	}

	@Override
	public List<MatchDto> getList(String teamName) {
		log.info("get Match List......");
		return repository.selectList(teamName);
	}

	@Override
	public MatchDto get(int matchNo) {
		log.info("get......" + matchNo);
		return repository.select(matchNo);
	}

	@Override
	public boolean modify(MatchDto dto) {
		String matchDate = dto.getMatchDate();
		String splitDate = matchDate.replace("T", " ");
		dto.setMatchDate(splitDate);
		MatchDto readDto = repository.select(dto.getMatchNo());
		if (readDto == null) {
			log.info("해당 매치는 존재하지않습니다");
			return false;
		} else {
			log.info("modify....." + dto);
			return repository.update(dto) == 1; 
		}
		
	}

	@Override
	public boolean remove(int matchNo) {
		MatchDto readDto = repository.select(matchNo);
		if(readDto == null) {
			log.info("해당 매치는 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + matchNo);
			return repository.delete(matchNo) == 1;
		}
		
	}

	@Override
	public RecordDto registerPoint(RecordDto dto) {
		log.info("Match registerPoint ......" + dto);
		repository.insertPoint(dto);		
		return dto ;
	}

	@Override
	public boolean modifyPoint(RecordDto dto) {
		RecordDto readDto = repository.selectPoint(dto.getMatchNo());
		if (readDto == null) {
			log.info("해당 매치는 존재하지않습니다");
			return false;
		} else {
			log.info("modify....." + dto);
			return repository.updatePoint(dto) == 1; 
		}
		
	}

	@Override
	public RecordDto getPoint(int matchNo) {
		log.info("get......" + matchNo);
		return repository.selectPoint(matchNo);
	}

	@Override
	public boolean removePoint(int matchNo) {
		RecordDto readDto = repository.selectPoint(matchNo);
		if(readDto == null) {
			log.info("해당 매치는 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + matchNo);
			return repository.deletePoint(matchNo) == 1;
		}
		
	}
	

}
