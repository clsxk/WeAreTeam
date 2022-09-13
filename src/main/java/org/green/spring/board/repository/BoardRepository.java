package org.green.spring.board.repository;

import java.util.List;

import org.green.spring.board.domain.BoardDto;

public interface BoardRepository {
	
	// ���
//	public BoardDto insert(BoardDto dto);
	
	public void insert(BoardDto dto);
	
	// ��� �б�
	public List<BoardDto> selectList();
	
	// �ܰ� �б�
	public BoardDto select(int no);
	
	// ����
	public int update(BoardDto dto);
	
	// ����
	public int delete(int no);
	
}

