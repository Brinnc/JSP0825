package org.sp.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sp.mvcapp.model.blood.BloodManager;

//MVC에서 모델과 뷰를 분리시키기 위해 컨트롤러의 관여가 필요함
//MVC 개발방법론을 javaEE 기술로 구현하였을 때의 개발 방법을 가리켜 model2라고 하며
//Model-Java(순수자바코드)
//View-jsp
//Controller-서블릿

public class BloodController extends HttpServlet implements Controller{
	BloodManager manager;
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood=request.getParameter("blood");
		
		//로직(재사용 가능성)
		manager=new BloodManager();
		String msg=manager.getAdvice(blood);
		
		//msg 변수가 곧(응답 시) 소멸되므로, 어딘가에 저장해놓지 않으면 
		//아래 코드에 의한 재접속 시 msg를 사용할 수 없게됨 -> session 이용
		
		//서버에 의해 생성된 세션 가져오기 -> request
		//HttpSession session=request.getSession();
		
		
		//4단계) jsp인 뷰로 가져갈 것이 있다면 데이터 저장
		//세션은 map의 자식이므로, key-value쌍으로 데이터를 관리
		request.setAttribute("msg", msg);
		
		//결과 보여주기
		//response.sendRedirect("/blood/result.jsp");
	}
	
	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "bloodView";
	}
}
