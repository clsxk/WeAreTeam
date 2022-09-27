package org.green.spring.account.service;

import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.repository.AccountRepository;
import org.green.spring.board.service.BoardServiceImpl;
import org.green.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private MemberService memberservice;
	
	@Override
	public AccountDto register(AccountDto dto) {
		log.info("Acc register...." + dto);
		repository.insert(dto);
		int newNo = dto.getAccNum();
		AccountDto insertDto = get(newNo);
		return insertDto;
	}

	@Override
	public List<AccountDto> getList(String teamName) {
		log.info("acc get List....");
		return repository.selectList(teamName);
	}
	
	@Override
	public AccountDto get(int accNum) {
		log.info("acc get....." + accNum);
		return repository.select(accNum);
	}

	@Override
	public boolean modify(AccountDto dto) {
		AccountDto readDto = repository.select(dto.getAccNum());
		if(readDto == null) {
			log.info("�ش� �Խù��� �������� �ʽ��ϴ�");
			return false;
		} else {
			log.info("acc modify....." + dto);
			return repository.update(dto) == 1;
		}
	}

	@Override
	public boolean remove(int accNum) {
		AccountDto readDto = repository.select(accNum);
		if (readDto == null) {
			log.info("�ش� �Խù��� �������� �ʽ��ϴ�.");
			return false;
		} else {
			log.info("acc remove..." + accNum);
			return repository.delete(accNum) == 1;
		}
	}

	@Override
	public AccountDto getIn(String teamName) {
		log.info("acc getIN....." + teamName);
		return repository.selectIn(teamName);
	}

	@Override
	public AccountDto getOut(String teamName) {
		log.info("acc getOut....." + teamName);
		return repository.selectOut(teamName);
	}

}
