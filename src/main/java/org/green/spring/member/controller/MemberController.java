package org.green.spring.member.controller;

import java.util.List;

import org.green.spring.board.domain.BoardDto;
import org.green.spring.member.domain.MemberDto;
import org.green.spring.member.service.MemberService;
import org.green.spring.member.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping(value = "/member")

public class MemberController {

	
	@Autowired
	private MemberService service;
	
	
	@GetMapping(value="/register")
	public String registerForm() {
		return "member/registerForm";
	}
	
	//등록처리
	@PostMapping(value = "/register")
	public String register(MemberDto dto, RedirectAttributes rttr) {
		MemberDto registerDto = service.register(dto);
		if(registerDto == null) {
			rttr.addFlashAttribute("resultMessage", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register";
		}else {
			return "redirect:/customLogin";
		
		}
	}
	
	//목록
	@GetMapping(value = "/member/list")
	public String getList(Model model) {
		List<MemberDto> memberList = service.getList();
		model.addAttribute("memberList",memberList);
		return "member/list";
	}
	//상세보기
	@GetMapping(value = "/member/read")
	public String get(@RequestParam("userId") String userId, Model model) {
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member",memberDto);
		return "member/read";
	}
	/* 수정화면 */
	@GetMapping(value = "/member/modify") 
	public String modifyForm(@RequestParam("userId") String userId, Model model) {
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member", memberDto);
		return "member/modifyForm";
	} 
	/* 수정처리 */
	@PostMapping(value = "/member/modify")
	public String modify(MemberDto memberVo, RedirectAttributes rttr) {
		boolean result = service.modify(memberVo);
		rttr.addFlashAttribute("modifyResult", result);
		return "redirect:/member/read?userId=" + memberVo.getUserId();
	}
	
	/* 삭제처리 */
	@GetMapping(value = "/member/remove") 
	public String remove(@RequestParam("userId") String userId,RedirectAttributes rttr) {
		 boolean result =  service.remove(userId);
		 rttr.addFlashAttribute("removeResult",result);
		 return "redirect:/member/list";
	}
	
}
