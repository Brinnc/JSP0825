package org.sp.mvcapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.OracleBoardDAO;

//게시물 리스트 요청을 처리하는 하위 컨트롤러
//3단계) 로직 객체에 일 시키기
//4단계) 결과 페이지에 보여줄 것이 있을 시 데이터 저장

public class ListController implements Controller{
	OracleBoardDAO boardDAO=new OracleBoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3단계) 일 시키기
		List boardList=boardDAO.selectAll();
		
		//4단계) 결과 데이터 저장
		request.setAttribute("boardList", boardList);
		
	}

	@Override
	public String getViewName() {
		
		return "board/listView";
	}
	
	@Override
	public boolean isForward() {
		
		return true; //forward
	}

}
