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
//	public void ���() {
//		MatchDto dto = new MatchDto("user1","1234","�Ѹ�","AA","AA","ROLE_USER");
//		int result = repository.insert(dto);
//		log.info("CREATE ��� : " + result);
//	}
	
//	@Test
//	public void �����ȸ() {
//		for(MatchDto dto : repository.selectList(teamName)) {
//			log.info(dto.toString());
//		}
//	}
	
	@Test
	public void �ܰ���ȸ() {
		MatchDto readDto = repository.select(1);
		log.info("���̵� user1�� ���� ����ڸ� ��ȸ�մϴ�");
		log.info(readDto);
	}
	
//	@Test 
//	public void ����() {
//		MatchDto updateDto = repository.select("qpo159");
//		updateDto.setUserName("��浿");
//		int result = repository.update(updateDto);
//		log.info("UPDATE ��� : " + result);
//	}
////	
//	@Test 
//	public void ����() {
//		int result = repository.delete("user1");
//		log.info("DELETE ��� : " + result);
//	}
	
//	@Test 
//	public void ��ü����() {
//		int result;
//		for (MemberDto dto : repository.selectList()) {
//			result = repository.delete(dto.getUserId());
//			log.info(dto.getUserId() + " �� �����մϴ�. ��� : " + result);
//		}
//		
//	}
}
