package com.softsdu.keepup.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.softsdu.keepup.domain.Role;
import com.softsdu.keepup.service.IssueService;
import com.softsdu.keepup.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/borrowed")
public class IssueController {
	@Autowired
	private MagazineService magazineService;

	@Autowired
	private IssueService issueService;
	
	@ModelAttribute(name = "accountRoles")
	public List<Role> memberTypes() {
		return Arrays.asList(Role.values());
	}

	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listIssuePage(Model model) {
		model.addAttribute("issues", issueService.getAllUnreturned());
		return "/borrowed/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newIssuePage(Model model) { 

		model.addAttribute("magazines", magazineService.getAll());
		return "/borrowed/form";
	}


	
}
