package kr.inhatc.spring.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inhatc.spring.member.dto.MemberDto;

@Mapper
public interface MemberMapper {
	// 메소드의 이름과 쿼리의 이름은 동일하게...
		List<MemberDto> memberList();

		void memberInsert(MemberDto member);

		MemberDto memberDetail(String memberId);


}
