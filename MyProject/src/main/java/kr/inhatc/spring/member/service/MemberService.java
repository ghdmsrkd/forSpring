package kr.inhatc.spring.member.service;

import java.util.List;

import kr.inhatc.spring.member.dto.MemberDto;


public interface MemberService {
	List<MemberDto> memberList();

	void memberInsert(MemberDto member);

	MemberDto memberDetail(String memberId);

}
