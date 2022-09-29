package org.green.spring.match.repository;

import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.RecordDto;

public interface MatchRepository {
	
	// ���
	public void insert(MatchDto dto);
	
	// ��� �б�
	public List<MatchDto> selectList(String teamName);
	
	// �ܰ� �б�
	public MatchDto select(int matchNo);
	
	// ����
	public int update(MatchDto dto);
	
	// ����
	public int delete(int matchNo);
	
	// ����,��� ���
	public void insertPoint(RecordDto dto);
	
	// ����,��� �߰�
	public int updatePoint(RecordDto dto);
	
	// ����,��� �ܰ� �б�
	public RecordDto selectPoint(int matchNo);
	
	// ����,��� ����
	public int deletePoint(int matchNo);

}
