package org.green.spring.record.controller;

import java.util.List;

import org.green.spring.record.domain.RecordDto;
import org.green.spring.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller


public class RecordController {

	@Autowired
	private RecordService recordService;
	
	@GetMapping(value = "record/list")
	public String getList( Model model) {
		List<RecordDto> recordList = recordService.getList();
		model.addAttribute("recordList",recordList);
		return "record/list";
		
	}
	
}
