package org.green.spring.board.controller;

import java.security.Principal;
import java.util.List;

import org.green.spring.board.domain.BoardDto;
import org.green.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	/* ���ȭ�� */
	@GetMapping(value = "/register")
	public String registerForm() {
		return "board/registerForm";
	}

	/* ���ó�� */
	@PostMapping(value = "/register")
	public String register(BoardDto boardDto, RedirectAttributes rttr, Principal principal) {
		String userId = principal.getName();
		boardDto.setWriter(userId);
		BoardDto registerDto = boardService.register(boardDto);
		rttr.addFlashAttribute("registerNo", registerDto.getNo());
		 return "redirect:/board/list";
	}

	/* ��� */
	@GetMapping(value = "/list")
	public String getList(Model model) {
		List<BoardDto> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}

	/* �� */
	@GetMapping(value = "/read")
	public String get(@RequestParam("no") int no, Model model) {
		BoardDto board = boardService.get(no);
		model.addAttribute("board", board);
		return "board/read";
	}

	/* ����ȭ�� */
	@GetMapping(value = "/modify") 
	public String modifyForm(@RequestParam("no") int no, Model model) {
		BoardDto board = boardService.get(no);
		model.addAttribute("board", board);
		return "board/modifyForm";
	} 
	
	/* ����ó�� */
	@PostMapping(value = "/modify") 
	public String modify(BoardDto boardVo, RedirectAttributes rttr) {
		 boolean result = boardService.modify(boardVo);
		 rttr.addFlashAttribute("modifyResult", result);
		 return "redirect:/board/read?no="+boardVo.getNo();
	} 
	
	/* ����ó�� */
	@GetMapping(value = "/remove") 
	public String remove(@RequestParam("no") int no,RedirectAttributes rttr) {
		 boolean result =  boardService.remove(no);
		 rttr.addFlashAttribute("removeResult",result);
		 return "redirect:/board/list";
	}
	
	/* ��� */
	@GetMapping(value = "/memberlist")
	public String getList1(Model model) {
		List<BoardDto> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);
		return "board/memberlist";
	}

}

