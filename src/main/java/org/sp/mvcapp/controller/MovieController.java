package org.sp.mvcapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sp.mvcapp.model.movie.MovieManager;

//영화에 대한 조언 요청을 받는 컨트롤러
public class MovieController implements Controller{
	MovieManager manager; //로직 객체의 모델 영역
	
	//3단계) 알맞은 로직객체에 일 시키기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//파라미터 받기
		String movie=request.getParameter("movie");
		
		//컨트롤러에서는 가능은해도, 로직을 작성하지말자
		//이유? 모델(로직)을 분리시켜야 다른 프로젝트 등에서 재사용 가능하기 때문
		//여기에서 모델을 작성해버리면 mvc중 controller+model이 되어버림
		
		//3) 알맞은 로직 객체에 일 시키기
		manager=new MovieManager();
		String msg=manager.getAdvice(movie);
		
		PrintWriter out=response.getWriter();
		
		//결과 페이지와 컨트롤러가 분리되어 있으므로 , msg와 같은 결과가 담겨진 지역변수가 유지되려면
		//어딘가에 저장해놓지 않으면 안됨 -> 현재로써는 session에 저장
		//HttpSession session=request.getSession();
		//session.setAttribute("msg", msg);
		
		//!!만일 요청을 끊지않고 결과페이지인 result.jsp로 포워딩하는 방법만 있다면, 우리는 세션을 사용할 필요가 없음
		
		//4단계) 결과 페이지인 result.jsp로 가져갈 것이 있다면 결과 저장
		request.setAttribute("msg", msg);
		
		/*
		//5단계) 결과 페이지 보여주기
		//포워딩
		//서버의 뷰 중 어떤 뷰로 포워딩할 지를 결정하는 객체
		RequestDispatcher dis=request.getRequestDispatcher("/movie/result.jsp");
		dis.forward(request, response);
		*/
		
		
		//서블릿이 디자인 결과를 표현할 수 있지만, MVC로 분리시키지 않으면
		//디자인 코드는 디자이너 퍼블리셔와 협업의 대상이므로, java코드에 두어서는 안됨
		//디자인, 즉 뷰를 담당하는 기술로 표현해야함
		//response.sendRedirect("/movie/result.jsp"); //<script>location.href="/movie/result.jsp";</script>
		
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "movieView";
	}
	
	
}
