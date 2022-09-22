<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">대기자 상세보기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
		</div>
		<div class="card-body">
		<form role="form" action="/member/modifyAccess" method="post">
			<div class="form-group">
				<label>신청 팀이름</label>
				<input class="form-control" name="teamName" value="${member.teamName}" readonly/>
			</div>	
			<div class="form-group">
				<label>아이디</label>
				<input class="form-control" name="userId" value="${member.userId}" readonly/>
			</div>
			<div class="form-group">
				<label>이름</label>
				<input class="form-control" name="userName" value="${member.userName}" readonly/>
			</div>
			<div class="form-group">
				<label>지역</label>
				<input class="form-control" name="userLocation" value="${member.userLocation}" readonly/>
			</div>
			<div class="form-group">
				<label>나이</label>
				<input class="form-control" name="userAge"  value="${member.userAge}" readonly/>
			</div>

			
			<button type="submit" class="btn btn-light">수락</button>
			<a href="/member/modifyDenied?userId=${member.userId}" class="btn btn-light">거절</a>
			<a href="/member/standbyList" class="btn btn-info">목록</a>
			</form>

		</div>	
	</div>
</div>

<%@include file="../includes/footer.jsp"%>