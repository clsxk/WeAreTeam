package org.green.spring.board.service;

import java.util.Date;
import java.util.List;

import org.green.spring.board.domain.BoardDto;
import org.green.spring.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;

	@Override
	public BoardDto register(BoardDto dto) {
		log.info("register......" + dto);
		repository.insert(dto);
		int newNo = dto.getNo();
		BoardDto insertDto = get(newNo);
		return insertDto;
	}

	@Override
	public List<BoardDto> getList() {
		log.info("get List......");
		return repository.selectList();
	}

	@Override
	public BoardDto get(int no) {
		log.info("get......" + no);
		return repository.select(no);
	}

	@Override
	public boolean modify(BoardDto dto) {
		BoardDto readDto = repository.select(dto.getNo());
		readDto.setUpdateDate(new Date()); 
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
//			dto.setUpdateDate(new Date());
			log.info("modify......" + dto);
			return repository.update(dto) == 1;
		}
	}

	@Override
	public boolean remove(int no) {
		BoardDto readDto = repository.select(no);
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + no);
			return repository.delete(no) == 1;
		}
	}

}
