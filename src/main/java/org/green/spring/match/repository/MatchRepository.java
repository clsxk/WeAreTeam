package org.green.spring.match.repository;

import java.util.List;

import org.green.spring.match.domain.MatchDto;

public interface MatchRepository {
	
	// ���
	public void insert(MatchDto dto);
	
	// ��� �б�
	public List<MatchDto> selectList();
	
	// �ܰ� �б�
	public MatchDto select(int matchNo);
	
	// ����
	public int update(MatchDto dto);
	
	// ����
	public int delete(int matchNo);

}
