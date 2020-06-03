package kr.inhatc.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.dto.FileDTO;

@Mapper
public interface BoardMapper {
	
	// 메소드의 이름과 쿼리의 이름은 동일하게...
	List<BoardDto> boardList();

	void boardInsert(BoardDto board);

	BoardDto boardDetail(int boardIdx);

	void boardUpdate(BoardDto board);

	void updateHit(int boardIdx);

	void boardDelete(int boardIdx);

	void boardFileInsert(List<FileDTO> list);

	List<FileDTO> selectBoardFileList(int boardIdx);

	FileDTO selectFileInfo(int idx, int boardIdx);

}
