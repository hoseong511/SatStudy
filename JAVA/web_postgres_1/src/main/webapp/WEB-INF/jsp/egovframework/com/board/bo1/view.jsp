<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
pageContext.setAttribute("crcn", "\r\n");
pageContext.setAttribute("br", "<br/");
%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width--device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css">
<script src="/js/jquery-3.5.1.min.js"></script>
<script src="/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javaScript" defer="defer">
function list() {
location.href = "<c:url value='/mainList.do'/>";
}

function addComment() {

if ($("#writer").val() == '') {
alert("작성자를 입력하세요.");
$("#writer").focus();
return;
}
if ($("#reply").val() == '') {
alert("댓글을 입력하세요.");
$("#reply").focus();
return;
}

if (!confirm("댓글을 작성하시겠습니까?")) {
return;
}

document.form2.action = "<c:url value='reply.do'/>";
document.form2.submit();
}

function modify() {
location.href = "<c:url value='/mgmt.do'/>?idx=${boardVO.idx}";
}

function del() {

var cnt =${fn:length(resultList)};

if(cnt>0){
alert("댓글이 있는 게시물은 삭제할 수 없습니다.")
return;
}

if (!confirm("삭제하시겠습니까?")) {
return;
}
document.form1.action = "<c:url value='mgmt.do'/>?mode=del&idx=${boardVO.idx}";
document.form1.submit();
}
</script>
</head>
<div class="container">
<h1>메인화면</h1>
<div class="panel panel-default">
<div class="panel-heading">
<label for="">${sessionScope.userName}님 환영합니다</label>
</div>

<div class="panel-body">
<form id="form1" name="form1" class="form-horizontal" method="post" enctype="multipart/form-data"
action="/">
<div class="form-group">
<label class="control-label col-sm-2" for="idx">게시물아이디:</label>
<div class="col-sm-10 control-label" style="text-align: left;">
<c:out value="${boardVO.idx}" />
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">제목:</label>
<div class="col-sm-10 control-label" style="text-align: left;">
<c:out value="${boardVO.title}" />
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">등록자/등록일:</label>
<div class="col-sm-10 control-label" style="text-align: left;">
<c:out value="${boardVO.writerNm}" />
/
<c:out
value="${fn:substring(boardVO.indate,0, fn:length(boardVO.indate)-2)}" />
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">내용:</label>
<div class="col-sm-10 control-label" style="text-align: left;">
<c:out value="${fn:replace(boardVO.contents, crcn, br)}"
escapeXml="false" />
</div>
</div>
</form>
</div>
<div class="panel-footer">
<c:if
test="${!empty sessionScope.userId && sessionScope.userId == boardVO.writer}">
<button type="button" class="btn btn-default" onclick="modify();">수정</button>
<button type="button" class="btn btn-default" onclick="del();">삭제</button>
</c:if>
<button type="button" class="btn btn-default" onclick="list();">목록</button>
</div>
</div>

<c:if test="${!empty boardVO.filename }">
<div class="well well-sm">
<c:import url="/cmm/fms/selectFileInfs.do">
<c:param name="param_atchFileId" value="${boardVO.filename}" />
</c:import>
</div>
</c:if>


<c:forEach var="result" items="${resultList}" varStatus="status">
<div class="well well-sm">
<c:out value="${result.writer}" />
/
<fmt:formatDate value="${result.indate}"
pattern="yyyy-MM-dd hh:mm:ss" />
<br />
<c:out value="${fn:replace(result.reply, crcn, br)}"
escapeXml="false" />
</div>
</c:forEach>
<div class="well well-lg">
<form id="form2" name="form2" class="form-horizontal" method="post"
action="">
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">작성자/작성일:</label>
<div class="col-sm-10 control-label" style="text-align: left;">
<input type="hidden" name="idx" value="${boardVO.idx}" /> <input
type="text" class="form-control" id="writer" name="writer"
placeholder="작성자를입력하세요" maxLength="15"
style="float: left; width: 40%"><input type="text"
class="form-control" id="indate" name="indate"
placeholder="작성일을입력하세요" maxLength="10"
style="float: left; width: 40%">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">내용:</label>
<div class="col-sm-10">
<textarea class="form-control" rows="3" id="reply" name="reply"
maxlength="300"></textarea>
</div>
</div>
<button type="button" class="btn btn-default" onclick="addComment();">작성</button>
</form>
</div>
</div>
</html>
