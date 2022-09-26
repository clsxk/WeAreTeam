package org.green.spring.account.service;

import java.util.List;

import org.green.spring.account.domain.AccountDto;

public interface AccountService {
	
	//µî·Ï
	public AccountDto register(AccountDto dto);
	
	
	public AccountDto get(int accNum);
	
	public List<AccountDto> getList();
	
	public boolean modify(AccountDto dto);
	
	public boolean remove(int accNum);

}
