package org.green.spring.account.repository;

import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.domain.InAccountDto;

public interface AccountRepository {
	
	//등록
	public void insert(AccountDto dto);
	
	//목록 일기
	public List<AccountDto> selectList(String teamName);
	
	//단건 읽기
	public AccountDto select(int accNum);
	
	//수정
	public int update(AccountDto dto);
	
	//삭제
	public int delete(int accNum);
	
	//수입
	public InAccountDto selectIn(String teamName);
	
	//지출
	public InAccountDto selectOut(String teamName);
	
	//음료비
	public InAccountDto selectDrink(String teamName);
	
	//구장비
	public InAccountDto selectStadium(String teamName);
	
	//물품비
	public InAccountDto selectGoods(String teamName);

}
