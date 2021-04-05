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
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action ="${path}/board/delete.do";
				document.form1.submit();
			}
		});
		
		$("#btnUpdate").click(function(){
			var title =$("#title").val();
			var content = $("#content").val();
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
			document.form1.action="${path}/board/update.do"
			
			document.form1.submit();
			
		});
	};
</script>
</head>
<body>
<%@include file ="../include/menu.jsp"%>
<h2>게시글 보기</h2>
<form name ="form1" method="post">
	<div>
		작성일자 : <fmt:formatDate value="${vo.regdate}" pattern ="yyyy-MM-dd HH:mm:ss"/>
	</div>
	<div>
		조회수 :${vo.viewcnt}
	</div>
	<div>
		제목
		<input name ="title" id = "title" size="80" value ="${vo.title}" placeholder ="제목을 입력해주세요.">
	</div>
	<div>
		내용
		<textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요.">${vo.content}</textarea>
	</div>
	<div>
		이름
		<input name ="userId" id = "userId" value="${vo.userId}" placeholder="이름을 입력해주세요.">
	</div>
	<div style="width: 650px; text-align: center;">
		<input type="hidden" name="bno" value="${vo.bno}">
		<button type="button" id="btnUpdate">수정</button>
		<button type="button" id="btnDelete">삭제</button>
	</div>
</form>
</body>
</html>