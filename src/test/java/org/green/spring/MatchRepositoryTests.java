package org.green.spring;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.repository.MatchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class MatchRepositoryTests {
	
	@Autowired
	private MatchRepository repository;

	
//	@Test 
//	public void 등록() {
//		MatchDto dto = new MatchDto("user1","1234","둘리","AA","AA","ROLE_USER");
//		int result = repository.insert(dto);
//		log.info("CREATE 결과 : " + result);
//	}
	
//	@Test
//	public void 목록조회() {
//		for(MatchDto dto : repository.selectList(teamName)) {
//			log.info(dto.toString());
//		}
//	}
	
	@Test
	public void 단건조회() {
		MatchDto readDto = repository.select(1);
		log.info("아이디 user1를 가진 사용자를 조회합니다");
		log.info(readDto);
	}
	
//	@Test 
//	public void 수정() {
//		MatchDto updateDto = repository.select("qpo159");
//		updateDto.setUserName("고길동");
//		int result = repository.update(updateDto);
//		log.info("UPDATE 결과 : " + result);
//	}
////	
//	@Test 
//	public void 삭제() {
//		int result = repository.delete("user1");
//		log.info("DELETE 결과 : " + result);
//	}
	
//	@Test 
//	public void 전체삭제() {
//		int result;
//		for (MemberDto dto : repository.selectList()) {
//			result = repository.delete(dto.getUserId());
//			log.info(dto.getUserId() + " 를 삭제합니다. 결과 : " + result);
//		}
//		
//	}
}
