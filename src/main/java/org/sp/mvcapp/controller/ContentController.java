package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import repository.OracleBoardDAO;

//상세보기 요청을 처리하는 하위 컨트롤러
public class ContentController implements Controller{
	OracleBoardDAO dao=new OracleBoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3단계) 1건 가져오기
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		Board board=dao.select(board_idx); //1건
		
		//4단계) 결과가 있다면 무조건 저장해야함
		request.setAttribute("board", board);
	}

	@Override
	public String getViewName() {
		
		return "board/contentView";
	}

	@Override
	public boolean isForward() {
		// 저장 후 가져갈 것(DTO)이 있으므로
		return true;
	}

}
