package org.green.spring.match.repository;

import java.util.List;

import org.green.spring.match.domain.MatchDto;

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

}
