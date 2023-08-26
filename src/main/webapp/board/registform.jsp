<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

//등록요청 (post 요청)
function regist(){
	$("form").attr({
		action:"/board/regist.do",
		method:"POST"
	});
	$("form").submit();
}

$(function(){
	$("#bt_list").click(function(){
		$(location).attr("href", "/board/list.do");
	});
	
	$("#bt_regist").click(function(){
		regist();
	});
	
});	
</script>

</head>
<body>

	<div class="container">
		<form>
			<input type="text" name="title" placeholder="제목입력"> 
			<input type="text" name="writer" placeholder="작성자">
			<textarea id="subject" name="content" placeholder="Write something.." style="height: 200px"></textarea>
			<input type="button" value="목록보기" id="bt_list">
			<input type="button" value="등록하기" id="bt_regist">
		</form>
	</div>
	<%@ include file="/inc/footer.jsp" %>
</body>
</html>





