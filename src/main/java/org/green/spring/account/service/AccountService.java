package org.green.spring.account.service;

import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.domain.InAccountDto;
import org.green.spring.member.service.MemberService;

import lombok.AllArgsConstructor;

public interface AccountService {
	
	//µî·Ï
	public AccountDto register(AccountDto dto);
		
	public AccountDto get(int accNum);
	
	public List<AccountDto> getList(String teamName);
	
	public boolean modify(AccountDto dto);
	
	public boolean remove(int accNum);
	
	public InAccountDto getIn(String teamName);
	
	public InAccountDto getOut(String teamName);
	
	public InAccountDto getDrink(String teamName);
	
	public InAccountDto getStadium(String teamName);
	
	public InAccountDto getGoods(String teamName);
	

}
