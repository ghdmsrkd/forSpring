package kr.inhatc.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.member.dto.MemberDto;
import kr.inhatc.spring.member.mapper.MemberMapper;

@Service
public class MemberServiceimpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberDto> memberList() {
		return memberMapper.memberList();
	}

	@Override
	public void memberInsert(MemberDto member) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+member.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+member.getMemberId());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+member.getEmail());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+member.getRole());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+member.getName());
		memberMapper.memberInsert(member);
	}

	@Override
	public MemberDto memberDetail(String memberId) {
		
		MemberDto member = memberMapper.memberDetail(memberId);
		
		return member;
	}

}
