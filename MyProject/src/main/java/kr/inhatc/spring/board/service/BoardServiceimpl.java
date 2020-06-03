package kr.inhatc.spring.board.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.dto.FileDTO;
import kr.inhatc.spring.board.mapper.BoardMapper;
import kr.inhatc.spring.utils.FileUtils;

@Service
public class BoardServiceimpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<BoardDto> boardList() {
		// TODO Auto-generated method stub
		
		return boardMapper.boardList();
	}


	@Override
	public void boardInsert(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) {
		boardMapper.boardInsert(board);
		
		// 임시 확인
//		if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
//			Iterator<String> iter = multipartHttpServletRequest.getFileNames();
//			while(iter.hasNext()) {
//				String name = iter.next();
//				
//				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
//				for(MultipartFile multipartFile : list) {
//					System.out.println(">>>>>>>>>> file name : " + multipartFile.getOriginalFilename());
//					System.out.println(">>>>>>>>>> file size : " + multipartFile.getSize());
//					System.out.println(">>>>>>>>>> file type : " + multipartFile.getContentType());
//				}
//			}
//		}
		//1. 파일 저정
		List<FileDTO> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		System.out.println(">>>>>>>>디비 실행 대기 중");
		//2. 디비 저장
		if(CollectionUtils.isEmpty(list) == false) {
			System.out.println(">>>>>>>>디비 실행 중");
			boardMapper.boardFileInsert(list);
		}
		
		
		
		
	}


	@Override
	public BoardDto boardDetail(int boardIdx) {
		BoardDto board = boardMapper.boardDetail(boardIdx);
		
		// 파일 정보
		List<FileDTO> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHit(boardIdx);
		return board;
	}


	@Override
	public void boardUpdate(BoardDto board) {
		boardMapper.boardUpdate(board);
		
	}


	@Override
	public void boardDelete(int boardIdx) {
		boardMapper.boardDelete(boardIdx);
		
	}


	@Override
	public FileDTO selectFileInfo(int idx, int boardIdx) {
		FileDTO boardFile = boardMapper.selectFileInfo(idx, boardIdx);
		return boardFile;
	}


}
