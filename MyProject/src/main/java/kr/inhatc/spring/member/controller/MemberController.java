package kr.inhatc.spring.member.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.member.dto.MemberDto;
import kr.inhatc.spring.member.service.MemberService;

@Controller
public class MemberController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("member/memberList")
	public String MemberList(Model model) {
		List<MemberDto> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/memberList";
		
	}
	
	@RequestMapping("/member/memberDetail")
	public String memberDetail(@RequestParam String memberId, Model model) {
		   MemberDto member = memberService.memberDetail(memberId);
		   System.out.println(member);
		   model.addAttribute("member", member);
		   return "member/memberDetail";
	}
	
	 @RequestMapping("/member/memberWrite")
	   public String memberWrite(Model model) {
		   
		   return "member/memberWrite";
	 }
	 
	 @RequestMapping("/member/memberInsert")
	   public String memberInsert(MemberDto member) {
		   
		   memberService.memberInsert(member);
		   
		   return "redirect:/member/memberList";
	   }
	 
	 
	
	
	
	
	
	
	
	
}
