package org.green.spring.member.controller;

import java.beans.beancontext.BeanContextMembershipListener;
import java.security.Principal;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String getList(Model model, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = service.get(userId);
		String teamName = readDto.getTeamName();
		List<MemberDto> memberList = service.getList(teamName);
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
	
	/*아이디 체크 */
	@GetMapping(value = "/idcheck")
	public @ResponseBody HashMap<String, Boolean> idCheck(@RequestParam("userId")String userId){
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		MemberDto memberDto = service.get(userId);
		if(memberDto != null) {
			result.put("isDuplicate", true);
		} else {
			result.put("isDuplicate", false);
		}
		return result;
	}
	
	
	/*팀생성 화면*/
	@GetMapping(value = "/member/create") 
	public String createForm(Principal principal, Model model) {
		String userId = principal.getName();
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member", memberDto);
		return "/member/createForm";
	} 
	
	/*팀생성 처리 */
	@PostMapping(value = "/member/create")
	public String create(MemberDto memberVo, RedirectAttributes rttr) {
		boolean result = service.create(memberVo);
		rttr.addFlashAttribute("createResult", result);
		return "redirect:/member/teamlist"; 
	}
	
	/*팀이름 체크 */
	@GetMapping(value = "/member/teamcheck")
	public @ResponseBody HashMap<String, Boolean> teamcheck(@RequestParam("teamName") String teamName){
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		MemberDto memberDto = service.getTeam(teamName);
		if(memberDto != null) {
			result.put("isDuplicate", true);
		} else {
			result.put("isDuplicate", false);
		}
		return result;
	}
	
	//팀목록
	@GetMapping(value = "/member/teamlist")
	public String getListTeam(Model model) {
		List<MemberDto> teamList = service.getListTeam();
		model.addAttribute("teamList",teamList);
		return "member/teamlist";
	}
	
	//팀 상세보기
	@GetMapping(value = "/member/readTeam")
	public String getModify(@RequestParam("userId") String userId, Model model) {
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member",memberDto);
		return "member/readTeam";
	}
	
	/*팀생성 처리 */
	@PostMapping(value = "/member/modifyTeam")
	public String modifyTeam(MemberDto memberVo,RedirectAttributes rttr,Principal principal) {
		String userId = principal.getName();
		memberVo.setUserId(userId);
		boolean result = service.modifyTeam(memberVo);
		rttr.addFlashAttribute("modifyResult", result);
		return "redirect:/member/teamlist"; 
	}
	
	/*팀원 수락 처리 */
	@PostMapping(value = "/member/modifyAccess")
	public String modifyAccess(@RequestParam("userId") String userId,RedirectAttributes rttr) {
		MemberDto memberDto = service.get(userId);
		boolean result = service.modifyAccess(memberDto);
		rttr.addFlashAttribute("modifyAccess", result);
		return "redirect:/member/standbyList"; 
	}
	
	/*팀원 거절 처리 */
	@GetMapping(value = "/member/modifyDenied")
	public String modifyDenied(@RequestParam("userId") String userId,RedirectAttributes rttr) {
		MemberDto memberDto = service.get(userId);
		boolean result = service.modifyDenied(memberDto);
		rttr.addFlashAttribute("modifyDenied", result);
		return "redirect:/member/standbyList"; 
	}
	
	//대기자 목록
	@GetMapping(value = "/member/standbyList")
	public String getStandbyList(Model model, Principal principal) {
		String userId = principal.getName();
		MemberDto readDto = service.get(userId);
		String teamName = readDto.getTeamName();
		List<MemberDto> standbyList = service.getStandbyList(teamName);
		model.addAttribute("standbyList",standbyList);
		return "member/standbyList";
	}
	
	//대기자 상세보기
	@GetMapping(value = "/member/readStandby")
	public String getreadStandby(@RequestParam("userId") String userId, Model model) {
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member",memberDto);
		return "member/readStandby";
	}
	
	
	//내정보 보기
	@GetMapping(value = "/member/myread")
	public String get(Principal principal,String userId, Model model) {
		userId = principal.getName();
		MemberDto memberDto = service.get(userId);
		model.addAttribute("member",memberDto);
		return "member/myread";
	}
	
}
