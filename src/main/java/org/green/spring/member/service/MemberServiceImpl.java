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
			log.info("아이디가 중복됩니다");
			log.info("사용자를 추가할수 없습니다");
			return null;
		} 
		//비밀번호 암호화
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(dto.getUserPw());
		dto.setUserPw(password);
		
		//사용자 추가하기
		log.info("register...." + dto);
		int result = repository.insert(dto);
		if (result == 1) {
			MemberDto insertDto = repository.select(userId);
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
	public boolean modify(MemberDto dto) {
		MemberDto readDto = repository.select(dto.getUserId());
		readDto.setUpdateDate(new Date());
			log.info("modify......" + dto);
			return repository.update(dto) == 1;
		}
	

	@Override
	public boolean remove(String userId) {
		MemberDto readDto = repository.select(userId);
		if (readDto == null) {
			log.info("해당 회원은 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + userId);
			return repository.delete(userId) == 1;
		}
	}

}
