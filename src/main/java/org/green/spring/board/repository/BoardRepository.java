package org.green.spring.board.repository;

import java.util.List;

import org.green.spring.board.domain.BoardDto;

public interface BoardRepository {
	
	// 등록
//	public BoardDto insert(BoardDto dto);
	
	public void insert(BoardDto dto);
	
	// 목록 읽기
	public List<BoardDto> selectList();
	
	// 단건 읽기
	public BoardDto select(int no);
	
	// 수정
	public int update(BoardDto dto);
	
	// 삭제
	public int delete(int no);
	
}

