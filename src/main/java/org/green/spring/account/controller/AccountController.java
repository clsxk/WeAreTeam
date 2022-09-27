package org.green.spring.account.controller;

import java.security.Principal;
import java.util.List;

import javax.sql.rowset.serial.SerialArray;

import org.green.spring.account.domain.AccountDto;
import org.green.spring.account.service.AccountService;
import org.green.spring.board.domain.BoardDto;
import org.green.spring.member.domain.MemberDto;
import org.green.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/account")

public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private MemberService memberservice;
	
	/* 등록화면 */
	@GetMapping(value = "/register")
	public String registerForm() {
		return "account/registerForm";
	}
	
	
	/* 등록처리 */
	@PostMapping(value = "/register")
	public String register(AccountDto accountDto, RedirectAttributes rttr, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		accountDto.setTeamName(teamName);  
		AccountDto registerDto = accountService.register(accountDto);
		rttr.addFlashAttribute("registerNo", registerDto.getAccNum());
		 return "redirect:/account/list";
	}
	
	/* 목록 */
	@GetMapping(value = "/list")
	public String getList(Model model,Principal principal,AccountDto accountDto) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		accountDto.setTeamName(teamName);
		List<AccountDto> accountList = accountService.getList(teamName);
		model.addAttribute("accountList", accountList);
		return "account/list";
	}
	
	/* 상세 */
	@GetMapping(value = "/read")
	public String get(@RequestParam("accNum") int accNum, Model model) {
		AccountDto account = accountService.get(accNum);
		model.addAttribute("account", account);
		return "account/read";
	}
	
	/* 수정처리 */
	@PostMapping(value = "/modify") 
	public String modify(AccountDto accountVo, RedirectAttributes rttr) {
		 boolean result = accountService.modify(accountVo);
		 rttr.addFlashAttribute("modifyResult", result);
		 return "redirect:/account/read?no="+accountVo.getAccNum();
	} 
}
