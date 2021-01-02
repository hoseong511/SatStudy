<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width--device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css">
<script src="/js/jquery-3.5.1.min.js"></script>
<script src="/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>"></script>
<script type="text/javaScript" defer="defer">
$(document).ready(function() {
$("#idx").attr("readonly", true);
$("#writerNm").attr("readonly", true);
$("#indate").attr("readonly", true);
})

function cancel() {
location.href = "<c:url value='/mainList.do'/>";
}

function add() {
if ($("#title").val() == '') {
alert("제목을 입력하세요");
$("#title").focus();
return;
}
if ($("#contents").val() == '') {
alert("내용을 입력하세요");
$("#contents").focus();
return;
}

if (!confirm("등록하시겠습니까?")) {
return;
}

document.boardRegForm.action = "<c:url value='mgmt.do'/>?mode=add";
document.boardRegForm.submit();
}

function modify() {
if ($("#title").val() == '') {
alert("제목을 입력하세요");
$("#title").focus();
return;
}
if ($("#contents").val() == '') {
alert("내용을 입력하세요");
$("#contents").focus();
return;
}

if (!confirm("수정하시겠습니까?")) {
return;
}

document.boardRegForm.action = "<c:url value='mgmt.do'/>?mode=modify";
document.boardRegForm.submit();
}
</script>
</head>
<div class="container">
<h1>메인화면</h1>
<div class="panel panel-default">
<div class="panel-heading">
<label for="">생각중:</label>
</div>

<div class="panel-body">
<form id="boardRegForm" name="boardRegForm" class="form-horizontal"
method="post" enctype="multipart/form-data" action="/">
<div class="form-group">
<label class="control-label col-sm-2" for="idx">게시물아이디:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="idx" name="idx"
placeholder="자동발번" value="${boardVO.idx}">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">제목:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="title" name="title"
placeholder="제목을 입력하세요!!!" maxLength="100" value="${boardVO.title}">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">등록자/등록일:</label>
<div class="col-sm-10">
<input type="hidden" class="form-control" id="writer"
name="writer" placeholder="작성자를입력하세요" maxLength="15"
style="float: left; width: 40%" value="${boardVO.writer}">
<input type="text" class="form-control" id="writerNm"
name="writerNm" placeholder="작성자를입력하세요" maxLength="15"
style="float: left; width: 40%" value="${boardVO.writerNm}">
<c:set var="indate" value="${boardVO.indate}" />
<c:if test="fn:length(indate>9)">
<c:set var="indate"
value="${fn:substring(indate,0,fn:length(indate)-2)}" />
</c:if>
<input type="text" class="form-control" id="indate" name="indate"
placeholder="작성일을입력하세요" maxLength="10"
style="float: left; width: 40%" value="${indate}">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">내용:</label>
<div class="col-sm-10">
<textarea class="form-control" rows="5" id="contents"
name="contents" maxlength="1000">${boardVO.contents }</textarea>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="pwd">첨부파일:</label>
<div class="col-sm-10">
<input type="hidden" name="savePath" value="Globals.fileStorePath" />
<input type="hidden" name="posblAtchFileNumber" value="5" />
<input type="file" class="forw-control" id="egovComFileUploader" name="file" />
<div id="egovComFileList"></div>
</div>
</div>
</form>
</div>
<div class="panel-footer">
<c:if test="${!empty sessionScope.userId}">
<c:if test="${empty idx}">
<button type="button" class="btn btn-default" onclick="add();">등록</button>
</c:if>
<c:if test="${!  empty idx}">
<button type="button" class="btn btn-default" onclick="modify();">수정</button>
</c:if>
</c:if>
<button type="button" class="btn btn-default" onclick="cancel();">취소</button>
</div>
</div>
</div>
  <script type="text/javascript">
   var maxFileNum = document.boardRegForm.posblAtchFileNumber.value;
   if(maxFileNum==null || maxFileNum==""){
     maxFileNum = 3;
    }     
   var multi_selector = new MultiSelector( document.getElementById( 'egovComFileList' ), maxFileNum );
   multi_selector.addElement( document.getElementById( 'egovComFileUploader' ) );
  </script>  
</html>
