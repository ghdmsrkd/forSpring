package kr.inhatc.spring.board.dto;

import java.util.List;

import lombok.Data;

// DTO : DATA TRANSFER OBJECT

@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createorId;
	private String createDatetime;
	
	//파일 관리를 위한 리스트 추가
	private List<FileDTO> fileList;
	
}
