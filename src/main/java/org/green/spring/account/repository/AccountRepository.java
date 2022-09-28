package org.green.spring.account.repository;

import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.domain.InAccountDto;

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
	
	//����
	public InAccountDto selectIn(String teamName);
	
	//����
	public InAccountDto selectOut(String teamName);
	
	//�����
	public InAccountDto selectDrink(String teamName);
	
	//�����
	public InAccountDto selectStadium(String teamName);
	
	//��ǰ��
	public InAccountDto selectGoods(String teamName);

}
