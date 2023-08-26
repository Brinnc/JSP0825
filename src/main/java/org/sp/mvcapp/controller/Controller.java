package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//우리의 프레임웍에서 사용되는 모든 컨트롤러의 최상위 객체
//또한 이 인터페이스를 통해, 모든 자식이 반드시 구현해야할 메서드를 강제할 수 있음
//즉, 기준을 세울 수 있음
public interface Controller {
	//요청을 처리하는 메서드
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
	//상위 컨트롤러가 검색할 뷰 이름
	public String getViewName();
	
	//포워딩 할 지 여부
	public boolean isForward();
}
