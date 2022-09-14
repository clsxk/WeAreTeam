package org.green.spring.member.controller;

import java.util.List;

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
	
	//���ó��
	@PostMapping(value = "/register")
	public String register(MemberDto dto, RedirectAttributes rttr) {
		MemberDto registerDto = service.register(dto);
		if(registerDto == null) {
			rttr.addFlashAttribute("resultMessage", "���̵� �ߺ��Ǿ� ��Ͽ� �����Ͽ����ϴ�");
			return "redirect:/register";
		}else {
			return "redirect:/customLogin";
		
		}
	}
	
	//���
	@GetMapping(value = "/member/list")
	public String getList(Model model) {
		List<MemberDto> memberList = service.getList();
		model.addAttribute("memberList",memberList);
		return "member/list";
	}
	//�󼼺���
	@GetMapping(value = "/member/read")
	public String get(@RequestParam("userId") String userId, Model model) {
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member",memberDto);
		return "member/read";
	}
	
}
