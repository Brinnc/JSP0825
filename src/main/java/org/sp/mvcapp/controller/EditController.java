package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import repository.OracleBoardDAO;

//수정 요청을 처리하는 하위 컨트롤러
public class EditController implements Controller{
	OracleBoardDAO dao=new OracleBoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board=new Board();
		//update board set title=?, writer=?
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_idx(board_idx);
		
		// 3단계) 게시물 수정
		int result=dao.update(board);
		
		// 4단계) DML수행이므로 저장할 것이 없음(포워딩할 것이 없음) 
		
		//단!! 수정된 내용이 담겨진 DTO를 request에 저장
		request.setAttribute("board", board);
	}

	@Override
	public String getViewName() {
		
		return "board/editView";
	}

	@Override
	public boolean isForward() {
		
		//return false; //redirect 재접속
		return true; 
	}

}
