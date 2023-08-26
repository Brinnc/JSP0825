package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import repository.OracleBoardDAO;

//글쓰기 요청을 처리하는 하위 컨트롤러(3단계, 4단계(선택사항))
public class RegistController implements Controller{
	OracleBoardDAO dao=new OracleBoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계) 일 시키기
		Board board=new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		int result=dao.insert(board);
		
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "board/registView";
	}
	
	@Override
	public boolean isForward() {
		
		return false; //redirect
	}

}
