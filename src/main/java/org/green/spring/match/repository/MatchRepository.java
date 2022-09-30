package org.green.spring.match.repository;

import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.RecordDto;

public interface MatchRepository {
	
	// 등록
	public void insert(MatchDto dto);
	
	// 목록 읽기
	public List<MatchDto> selectList(String teamName);
	
	// 단건 읽기
	public MatchDto select(int matchNo);
	
	// 수정
	public int update(MatchDto dto);
	
	// 삭제
	public int delete(int matchNo);
	
	// 득점,어시 등록
	public void insertPoint(RecordDto dto);
	
	// 득점,어시 추가
	public int updatePoint(RecordDto dto);
	
	// 득점,어시 단건 읽기
	public RecordDto selectPoint(int matchNo);
	
	// 득점,어시 삭제
	public int deletePoint(int matchNo);
	
	// 득점 인원조회
	public List<RecordDto> selectListPoint(String teamName);
	

}
