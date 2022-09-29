package org.green.spring.match.controller;

import java.security.Principal;
import java.util.List;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.RecordDto;
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
	public String register(MatchDto matchDto,RedirectAttributes rttr, Principal principal,RecordDto recordDto) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		matchDto.setTeamName(teamName);
		MatchDto registerDto = matchService.register(matchDto);
		int matchNo = matchDto.getMatchNo();
		recordDto.setMatchNo(matchNo);		
		RecordDto registerDto1 = matchService.registerPoint(recordDto);
		rttr.addFlashAttribute("registerNo", registerDto1.getMatchNo());
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
	public String get(@RequestParam("matchNo") int matchNo, Model model) {
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		RecordDto record = matchService.getPoint(matchNo);
		model.addAttribute("record", record);
		return "match/read";
	}
	
	//수정화면
	@GetMapping(value = "/modify")
	public String modifyForm(@RequestParam("matchNo") int matchNo, Model model) {
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		
		RecordDto record = matchService.getPoint(matchNo);
		model.addAttribute("record", record);
		
		return "match/modifyForm";
	}
	
	//수정처리
	@PostMapping(value = "/modify")
	public String modify(MatchDto matchVo, RedirectAttributes rttr,RecordDto recordVo) {
		boolean result = matchService.modify(matchVo);
		boolean result1 = matchService.modifyPoint(recordVo);
		rttr.addFlashAttribute("modifyResult1",result1);
		rttr.addFlashAttribute("modifyResult",result);
		return "redirect:/match/read?matchNo=" + matchVo.getMatchNo();
	}
	
	//삭제처리
	@GetMapping(value ="/remove")
	public String remove(@RequestParam("matchNo")int matchNo, RedirectAttributes rttr) {
		boolean result = matchService.remove(matchNo);
		rttr.addFlashAttribute("removeResult",result);
		
		boolean result1 = matchService.removePoint(matchNo);
		rttr.addFlashAttribute("removeResult1",result1);
		
		return "redirect:/match/list";
	}
	
	//목록(팀원)
	@GetMapping(value = "/memberlist")
	public String getList1(Model model,MatchDto matchDto, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		matchDto.setTeamName(teamName);
		List<MatchDto> matchList = matchService.getList(teamName);
		model.addAttribute("matchList",matchList);
		return "match/memberlist";
	}
	
	
	/*
	 * //개인 골,어시 등록처리
	 * 
	 * @PostMapping(value = "/modify") public String registerPoint(RecordDto
	 * recordDto,RedirectAttributes rttr, Principal principal) { RecordDto
	 * registerDto = matchService.registerPoint(recordDto);
	 * rttr.addFlashAttribute("registerPoint", registerDto.getUserId()); return
	 * "redirect:/match/list"; }
	 */
}
