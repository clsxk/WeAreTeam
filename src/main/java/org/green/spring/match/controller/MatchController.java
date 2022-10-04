package org.green.spring.match.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.green.spring.match.domain.MatchDto;
import org.green.spring.match.domain.MatchRecordDto;
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
import org.springframework.web.bind.annotation.RequestBody;
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
	public String registerForm(Model model,Principal principal) {
		
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		List<RecordDto> pointList1 = matchService.getListPoint(teamName);
		List<Object> nameList = pointList1.stream().map(RecordDto::getUserName).collect(Collectors.toList());
		model.addAttribute("nameList",nameList);
		
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
	public String get(@RequestParam("matchNo") int matchNo, Model model,Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		
		
		List<RecordDto> pointList = matchService.getPoint(matchNo);
		model.addAttribute("pointList",pointList);
		return "match/read";
	}
	
	//수정화면
	@GetMapping(value = "/modify")
	public String modifyForm(@RequestParam("matchNo") int matchNo, Model model,Principal principal,RecordDto recordDto) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		
		
		MatchDto match = matchService.get(matchNo);
		model.addAttribute("match", match);
		
		List<RecordDto> pointList = matchService.getPoint(matchNo);
		model.addAttribute("pointList",pointList);
		
		List<RecordDto> pointList1 = matchService.getListPoint(teamName);
		List<Object> nameList = pointList1.stream().map(RecordDto::getUserName).collect(Collectors.toList());
		model.addAttribute("nameList",nameList);
		
		return "match/modifyForm";
	}
	
	//수정처리
	@PostMapping(value = "/modify")
	public String modify(List<RecordDto> recordDto, MatchDto matchVo, RedirectAttributes rttr) {

		boolean result = matchService.modify(matchVo);
		rttr.addFlashAttribute("modifyResult",result);
		
		
		/* recordDto = matchService.registerPoint(recordDto); */
		/*
		 * boolean result1 = matchService.modifyPoint(recordVo);
		 * rttr.addFlashAttribute("modifyResult1",result1);
		 */
				
		/*
		 * List<RecordDto> recordPoint =(List<RecordDto>)
		 * matchService.registerPoint((List<RecordDto>) recordVo);
		 * rttr.addFlashAttribute("recordPoint", recordPoint);
		 */
		
		
		
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
	public String getList1(Model model,RecordDto recordDto, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		List<MatchDto> matchList = matchService.getList(teamName);
		model.addAttribute("matchList",matchList);
		return "match/memberlist";
	}
	
	
	//전체 기록
	@GetMapping(value = "/recordlist")
	public String getList(Model model,RecordDto recordDto,Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = memberservice.get(userId);
		String teamName = readDto.getTeamName();
		List<RecordDto> recordList = matchService.getRecordList(teamName);
		model.addAttribute("recordList",recordList);
		
		MatchRecordDto matchRecord = matchService.getMatch(teamName);
		model.addAttribute("matchRecord",matchRecord);

		
		return "match/recordlist";
	}
	
	
}
