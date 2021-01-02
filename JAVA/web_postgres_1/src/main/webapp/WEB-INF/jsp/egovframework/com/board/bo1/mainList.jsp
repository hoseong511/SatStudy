<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

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
	
				$(document).ready(function(){
					<c:if test="${!empty msg}">
						alert("${msg}");
					</c:if>
				})
				
				function add() {
					location.href = "<c:url value='/mgmt.do'/>";
				}
				
				function view(idx) {
					location.href = "<c:url value='/view.do'/>?idx="+idx;
				}
				
				function setPwd(user_id) {
					if (user_id == "admin") {
						$("#password").val("1234")
					} else if (user_id == "guest") {
						$("#password").val("1234")
					} else {
						$("#password").val("1234")
					}
				}
				
				function check(){
					if ($("#user_id").val() == "") {
						alert("아이디를입력하세요");
						return false;
					}
					if ($("#password").val() == "") {
						alert("비밀번호를입력하세요");
						return false;
					}
					return true;
				}
				
				function out(){
					location.href = "<c:url value='/logout.do'/>" ;
				}
				
				function page(pageNo){
					location.href="<c:url value='/mainList.do'/>?pageIndex="+pageNo;
				}
				
			</script>
		</head>
		<div class="container">
			<h1>메인화면</h1>
			<div class="panel panel-default">
				<div class="panel-heading">
					<c:if test="${sessionScope.userId == null || sessionScope.userId == ''}">
						<form class="form-inline" method="POST" action="/login.do">
							<div class="form-group">
								<label for="user_id">아이디:</label>
								<select class="form-control" id="user_id" name="user_id" onchange="setPwd(this.value);">
									<option value="">선택하세요</option>
									<option value="admin">관리자</option>
									<option value="guest">사용자</option>
								</select>
							</div>
							<div class="form-group">
								<label for="password">Password:</label>
								<input type="password" class="form-control" id="password" name="password">
							</div>
							<button type="submit" class="btn btn-default" onclick="return check();">로그인</button>
						</form>
					</c:if>

					<c:if test="${sessionScope.userId != null && sessionScope.userId != ''}">
						${sessionScope.userName}님 환영합니다
						<button type="button" class="btn btn-default" onclick="out();">로그아웃</button>
					</c:if>
				</div>
				<div class="panel-body">
					<form class="form-inline" method="POST" action="/mainList.do">
						<div class="form-group">
							<label for="searchName">제목:</label> 
							<input type="text" class="form-control" id="searchKeyword" name="searchKeyword">
						</div>
						<button type="submit" class="btn btn-default">검색</button>
					</form>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>제목</th>
									<th>조회수</th>
									<th>댓글수</th>
									<th>글쓴이</th>
									<th>날짜</th>
									<th>첨부파일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="result" items="${resultList}" varStatus="status">
									<tr>
										<td>
											<a href="javascript:view('${result.idx}');"><c:out value="${result.idx }" /></a>
										</td>
										<td>
											<a href="javascript:view('${result.idx}');"><c:out value="${result.title }" /></a>
										</td>
										<td><c:out value="${result.count }" /></td>
										<td><c:out value="${result.replyCount }" /></td>
										<td><c:out value="${result.writerNm }" /></td>
										<td><fmt:formatDate value="${result.indate }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
										<td>
											<c:if test="${!empty result.filename}">
												<span class="glyphicon glyphicon-floppy-disk"></span>
											</c:if>
										</td>
									</tr>	
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="paging">
						<ui class="pagination"> 
							<span class="badge">${paginationInfo.totalRecordCount}</span>
							<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="page" /> 
							<%-- <form:hidden path="pageIndex" /> --%> 
						</ui>
					</div>
				</div>	
				<div class="panel-footer">
					<c:if test="${!empty sessionScope.userId}">
						<button type="button" class="btn btn-default" onclick="add();">등록</button>
					</c:if>
				</div>
			</div>
		</div>
	</html>
