package org.green.spring.account.controller;

import java.security.Principal;
import java.util.List;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.service.AccountService;
import org.green.spring.board.domain.BoardDto;
import org.green.spring.member.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/account")

public class AccountController {

	@Autowired
	private AccountService accountService;
	
	/* 등록화면 */
	@GetMapping(value = "/register")
	public String registerForm() {
		return "account/registerForm";
	}
	
	
	/* 등록처리 */
	@PostMapping(value = "/register")
	public String register(AccountDto accountDto, RedirectAttributes rttr, Principal principal,MemberDto memberDto ) {
		String userId = principal.getName();
		AccountDto registerDto = accountService.register(accountDto);
		rttr.addFlashAttribute("registerNo", registerDto.getAccNum());
		 return "redirect:/account/list";
	}
	
	/* 목록 */
	@GetMapping(value = "/list")
	public String getList(Model model) {
		List<AccountDto> accountList = accountService.getList();
		model.addAttribute("accountList", accountList);
		return "account/list";
	}
}
