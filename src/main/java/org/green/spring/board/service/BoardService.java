package org.green.spring.board.service;

import java.util.List;

import org.green.spring.board.domain.BoardDto;

public interface BoardService {

	public BoardDto register(BoardDto dto);

	public BoardDto get(int no);
	
	public List<BoardDto> getList();

	public boolean modify(BoardDto dto);

	public boolean remove(int no);

}
