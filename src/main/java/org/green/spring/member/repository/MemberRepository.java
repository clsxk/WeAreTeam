package org.green.spring.member.repository;

import java.util.List;

import org.green.spring.member.domain.MemberDto;


public interface MemberRepository {
	
	// ���
	public int insert(MemberDto dto);
	
	// ��� �б�
	public List<MemberDto> selectList();
	
	// �ܰ� �б�
	public MemberDto select(String userId);
	
	// ����
	public int update(MemberDto dto);
	
	// ����
	public int delete(String userId);
	
	// ������
	public int create(MemberDto dto);
	
	// ��üũ
	public MemberDto selectTeam(String teamName);
	
	// �����
	
	public List<MemberDto> selectListTeam();
}

