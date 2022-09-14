package org.green.spring.member.service;

import java.util.Date;
import java.util.List;

import org.green.spring.member.domain.MemberDto;
import org.green.spring.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;

	@Override
	public MemberDto register(MemberDto dto) {
		String userId = dto.getUserId();
		MemberDto getDto = get(userId);
		if (getDto != null) {
			log.info("���̵� �ߺ��˴ϴ�");
			log.info("����ڸ� �߰��Ҽ� �����ϴ�");
			return null;
		} 
		//��й�ȣ ��ȣȭ
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(dto.getUserPw());
		dto.setUserPw(password);
		
		//����� �߰��ϱ�
		log.info("register...." + dto);
		int result = repository.insert(dto);
		if (result == 1) {
			MemberDto insertDto = get(userId);
			return insertDto;
		} else {
			return null;
		}
	}

	@Override
	public List<MemberDto> getList() {
		log.info("get List......");
		return repository.selectList();
	}

	@Override
	public MemberDto get(String userId) {
		log.info("get......" + userId);
		return repository.select(userId);
	}



	@Override
	public boolean remove(String userId) {
		MemberDto readDto = repository.select(userId);
		if (readDto == null) {
			log.info("�ش� ȸ���� ���������ʽ��ϴ�.");
			return false;
		} else {
			log.info("remove...." + userId);
			return repository.delete(userId) == 1;
		}
	}

}
