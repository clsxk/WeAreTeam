package org.green.spring.match.repository;

import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.MatchRecordDto;
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
//	public void insertPoint(RecordDto dto);
	public void insertPoint(RecordDto dto);
	
	// ����,��� �߰�
	public int updatePoint(RecordDto dto);
	
	// ����,��� �ܰ� �б�
	public List<RecordDto> selectPoint(int matchNo);
	
	// ����,��� ����
	public int deletePoint(int matchNo);
	
	// ���� �ο���ȸ
	public List<RecordDto> selectListPoint(String teamName);
	
	// ���� ��ü ��� ��ȸ
	public List<RecordDto> selectRecordList(String teamName);
	
	// ��  ��� ��ȸ
	public MatchRecordDto selectMatchRecord(String teamName);

}
