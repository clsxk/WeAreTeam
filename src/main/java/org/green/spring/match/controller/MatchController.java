package org.green.spring.match.controller;

import java.security.Principal;
import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.service.MatchService;
import org.green.spring.member.domain.MemberDto;
import org.green.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/match")
public class MatchController {

	@Autowired
	private MatchService matchService;
	@Autowired
	private MemberService memberservice;
	
	//등록화면
	@GetMapping(value = "/register")
	public String registerForm() {
		return "match/registerForm";
	}
	
	//등록처리
	@PostMapping(value = "/register")
	public String register(MatchDto matchDto,RedirectAttributes rttr, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		matchDto.setTeamName(teamName);
		MatchDto registerDto = matchService.register(matchDto);
		rttr.addFlashAttribute("registerNo", registerDto.getMatchNo());
		return "redirect:/match/list";
	}
	//목록
	@GetMapping(value = "/list")
	public String getList(Model model,MatchDto matchDto, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		matchDto.setTeamName(teamName);
		List<MatchDto> matchList = matchService.getList(teamName);
		model.addAttribute("matchList",matchList);
		return "match/list";
	}
	
	//상세
	@GetMapping(value = "/read")
	public String get(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("matchNo") int matchNo, Model model) {
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		return "match/read";
	}
	
	//수정화면
	@GetMapping(value = "/modify")
	public String modifyForm(@RequestParam("matchNo") int matchNo, Model model) {
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		return "match/modifyForm";
	}
	
	@PostMapping(value = "/modify")
	public String modify(MatchDto matchVo, RedirectAttributes rttr) {
		boolean result = matchService.modify(matchVo);
		rttr.addFlashAttribute("modifyResult",result);
		return "redirect:/match/read?matchNo=" + matchVo.getMatchNo();
	}
	
	@GetMapping(value ="/remove")
	public String remove(@RequestParam("matchNo")int matchNo, RedirectAttributes rttr) {
		boolean result = matchService.remove(matchNo);
		rttr.addFlashAttribute("removeResult",result);
		return "redirect:/match/list";
	}
	
	
}
