
<%@page import="domain.Board"%>
<%@page import="util.Pager"%>
<%@page import="repository.OracleBoardDAO"%>
<%@page import="java.util.List"%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%!Pager pager=new Pager();
	OracleBoardDAO boardDAO=new OracleBoardDAO();%>
<%
	//레코드 가져오기 
	//아래와 같이 jsp에서 DAO를 사용하게 될 경우, view인 jsp가 컨트롤러의 업무를 겸하고 있으므로
	//model2가 아닌 model1이라함
	//List<Board> boardList =boardDAO.selectAll();
	List<Board> boardList=(List)request.getAttribute("boardList");

	//리스트 페이징 처리에 필요한 산수공식
	pager.init(boardList, request);

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//버튼에 이벤트 연결 
	$("button").click(function(){
		$(location).attr("href", "/board/registform.jsp");	
	});	
});
</script>
</head>
<body>


	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
			int num=pager.getNum(); //페이지당 시작 번호 
			int curPos=pager.getCurPos(); //페이지당 시작  index
		%>
		<%for(int i=1;i<=pager.getPageSize();i++){%>
		<%if(num<1)break; %>
		<%Board board=boardList.get(curPos++); %>
		<tr>
			<td><%=num-- %></td>
			<td><a href="/board/content.do?board_idx=<%=board.getBoard_idx()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate().substring(0, 10) %></td>
			<td><%=board.getHit() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" align="center">
			<%for(int i=pager.getFirstPage();i<=pager.getLastPage();i++){ %>
				<%if(i>pager.getTotalPage())break; %>
				<a href="/board/list.jsp?currentPage=<%=i%>">[<%=i%>]</a>
			<%} %>	
			</td>
		</tr>
		
		<tr>
			<td colspan="5"">
				<button>글쓰기</button>
			</td>
		</tr>
	</table>
	<%@ include file="/inc/footer.jsp" %>
	
</body>
</html>







