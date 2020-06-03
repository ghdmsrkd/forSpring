package kr.inhatc.spring.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.dto.FileDTO;

public interface BoardService {

	List<BoardDto> boardList();

	void boardInsert(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest);

	BoardDto boardDetail(int boardIdx);

	void boardUpdate(BoardDto board);

	void boardDelete(int boardIdx);

	FileDTO selectFileInfo(int idx, int boardIdx);

}
