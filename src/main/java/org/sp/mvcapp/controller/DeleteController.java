package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.nt.NTAdapter;
import repository.OracleBoardDAO;

//삭제 요청을 처리하는 하위 컨트롤러
public class DeleteController implements Controller{
	OracleBoardDAO dao=new OracleBoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계) 삭제 처리
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		int result=dao.delete(board_idx); //DML
		
		//4단계) 생략, 저장할 것이 없음
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "board/deleteView";
	}

	@Override
	public boolean isForward() {
		
		return false; // redirect
	}

}
