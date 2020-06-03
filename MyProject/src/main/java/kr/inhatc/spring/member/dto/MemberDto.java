package kr.inhatc.spring.member.dto;
import java.util.List;

import lombok.Data;

// DTO : DATA TRANSFER OBJECT
@Data
public class MemberDto {
	private String memberId;
	private String email;
	private String enabled;
	private String joinDate;
	private String name;
	private String pw;
	private String role;
	
}
