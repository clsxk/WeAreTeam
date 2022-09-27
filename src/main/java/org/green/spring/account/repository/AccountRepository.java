package org.green.spring.account.repository;

import java.util.List;

import org.green.spring.account.domain.AccountDto;

public interface AccountRepository {
	
	//���
	public void insert(AccountDto dto);
	
	//��� �ϱ�
	public List<AccountDto> selectList(String teamName);
	
	//�ܰ� �б�
	public AccountDto select(int accNum);
	
	//����
	public int update(AccountDto dto);
	
	//����
	public int delete(int accNum);
}
