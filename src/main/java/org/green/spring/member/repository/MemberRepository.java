package org.green.spring.member.repository;

import java.util.List;

import org.green.spring.member.domain.MemberDto;


public interface MemberRepository {
	
	// 등록
	public int insert(MemberDto dto);
	
	// 목록 읽기
	public List<MemberDto> selectList(String teamName);
	
	// 단건 읽기
	public MemberDto select(String userId);
	
	// 수정
	public int update(MemberDto dto);
	
	// 삭제
	public int delete(String userId);
	
	// 팀생성
	public int create(MemberDto dto);
	
	// 팀체크
	public MemberDto selectTeam(String teamName);
	
	// 팀목록
	public List<MemberDto> selectListTeam();
	
	// 팀신청
	public int updateTeam(MemberDto dto);

	// 팀원 수락
	public int accessTeam(MemberDto dto);
	
	// 팀원 거절
	public int deniedTeam(MemberDto dto);
	
	// 대기자 목록
	public List<MemberDto> standbyList(String teamName);

}

