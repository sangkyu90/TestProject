<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
<title>게시글 작성</title>
<%@include file ="../include/header.jsp"%>>
<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			var title = $("title").val();
			var content = $("content").val();
			var userId = $("userId").val();
			
			if(title ==""){
				alert("제목을 입력하세요.");
				document.form1.title.focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력하세요.");
				document.form1.content.focus();
				return;
			}
			if(userId == ""){
				alert("이름을 입력하세요.");
				document.form1.userId.focus();
				return;
			}
			document.form1.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
<h2>게시글 작성 </h2>

<from name ="form1" method="post" action = "${path}/board/insert.do">
	<div>
		제목
		<input name ="title" id = "title" size="80" placeholder ="제목을 입력해주세요.">
	</div>
	<div>
		내용
		<textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요."></textarea>
	</div>
	<div>
		이름
		<input name ="userId" id = "userId" placeholder="이름을 입력해주세요.">
	</div>
	<div style="width: 650px; text-align: center;">
		<input type="hidden" name="bno" value="${vo.bno}">
		<button type="button" id="btnSave">확인</button>
		<button type="reset">취소</button>
	</div>
</body>
</html>