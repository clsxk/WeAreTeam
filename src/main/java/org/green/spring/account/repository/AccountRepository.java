package org.green.spring.account.repository;

import java.util.List;

import org.green.spring.account.domain.AccountDto;

public interface AccountRepository {
	
	//등록
	public void insert(AccountDto dto);
	
	//목록 일기
	public List<AccountDto> selectList();
	
	//단건 읽기
	public AccountDto select(int accNum);
	
	//수정
	public int update(AccountDto dto);
	
	//삭제
	public int delete(int accNum);
}
