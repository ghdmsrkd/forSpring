package kr.inhatc.spring.board.dto;

import lombok.Data;

@Data
public class FileDTO {
	private int idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
}
