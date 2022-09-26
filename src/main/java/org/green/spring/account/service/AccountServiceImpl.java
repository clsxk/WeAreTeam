package org.green.spring.account.service;

import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.repository.AccountRepository;
import org.green.spring.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	@Override
	public AccountDto register(AccountDto dto) {
		log.info("Acc register...." + dto);
		repository.insert(dto);
		int newNo = dto.getAccNum();
		AccountDto insertDto = get(newNo);
		return insertDto;
	}

	@Override
	public List<AccountDto> getList() {
		log.info("acc get List....");
		return repository.selectList();
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
			log.info("해당 게시물은 존재하지 않습니다");
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
			log.info("해당 게시물은 존재하지 않습니다.");
			return false;
		} else {
			log.info("acc remove..." + accNum);
			return repository.delete(accNum) == 1;
		}
	}

}
