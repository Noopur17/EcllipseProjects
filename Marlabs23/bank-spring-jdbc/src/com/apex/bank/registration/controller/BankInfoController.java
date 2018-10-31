package com.apex.bank.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apex.bank.registration.bo.BankService;
import com.apex.bank.registration.vo.BankVO;

@Controller
@SessionAttributes("userBean")
public class BankInfoController {
	
	@Autowired
	private BankService bankService = null;
	
	@RequestMapping("/displayregistration.do")
	public String displayPage(Model model){
		BankVO bvo= new BankVO();
		model.addAttribute("userBean",bvo);
		return "personalinfo";
	}
	
	
	@RequestMapping("/addPersonalInfo.do")
	public String addPersonalInfo(@ModelAttribute("userBean") BankVO bvo){
		//step1
		
		System.out.println("PersonalInfoController:addPersonalInfo -- Start");
		System.out.println("First Name:"+bvo.getFirstName());
		System.out.println("Middle Name:"+bvo.getMiddleName());
		
		//step2
		 
		//userService.registerUser(user);
		
		//step3
		System.out.println("PersonalInfoController:addPersonalInfo -- End");
		return "contactinfo";
	}
	
	@RequestMapping("/addContactInfo.do")
	public String addIBankInfo(@ModelAttribute("userBean") BankVO bvo){
		//step1
		System.out.println("PersonalInfoController:addContactInfo -- Start");
		System.out.println("First Name:"+bvo.getFirstName());
		System.out.println("Address:"+bvo.getAddress());
		//step2
		 
		
		//step3
		System.out.println("PersonalInfoController:addContactInfo -- End");
		return "bankinfo";
	}
	
	@RequestMapping("/addBankInfo.do")
	public String displayAllInfo(@ModelAttribute("userBean") BankVO bvo) throws Exception{
		bankService.addBankInfo(bvo);
		return "outputsuccess";
	}
}
