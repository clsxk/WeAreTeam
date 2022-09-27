<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">수입&지출 상세보기</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label>번호</label>
				<input class="form-control" name="accNum" value="${account.accNum}" readonly/>
			</div>
			<div class="form-group">
				<label>팀이름</label>
				<input class="form-control" name="teamName" value="${account.teamName}" readonly/>
			</div>
			<div class="form-group">
				<label>구분</label> 
				<input  class="form-control" name="accDivision" value="${account.accDivision}" readonly/>
				</div>
			<div class="form-group">
				<label>내용</label>
				<input class="form-control" name="accContent" value="${account.accContent}" readonly/>
				</div>
			<div class="form-group">
				<label>금액</label>
				<input type="number" class="form-control" name="accMoney" value="${account.accMoney}" readonly/>
			</div>
			<div class="form-group">
				<label>날짜</label>
				<input  class="form-control" name="accDate" value="<fmt:formatDate pattern='yyyy/MM/dd' value='${account.accDate}'/>"readonly/>
			</div>
			<div class="form-group">
				<label>비고</label>
				<input class="form-control" name="accNote" value="${account.accNote}" readonly />
			</div>
				
				<a href="/account/modify?accNum=${account.accNum}" class="btn btn-light">수정</a>
				<a href="/account/list" class="btn btn-info">목록</a>
					

		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="../includes/footer.jsp"%>
