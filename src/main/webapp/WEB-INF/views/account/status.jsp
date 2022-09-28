<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">수입&지출 현황</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
		</div>
		<div class="card-body">

			<div class="form-group">
				<label>팀이름</label>
				<input class="form-control" name="teamName" value="${inaccount.teamName}" readonly/>
			</div>
			<div class="form-group">
				<label>총 수입 합계</label>
				<input type="number" class="form-control" name="accMoney" value="${inaccount.accMoney}" readonly/>
			</div>
			<div class="form-group">
				<label>총 지출 합계</label>
				<input type="number" class="form-control" name="accMoney" value="${outaccount.accMoney}" readonly/>
			</div>
			<div class="form-group">
				<label>남은 금액</label>
				<input type="number" class="form-control" name="accMoney" value="${totalaccount.accMoney}" readonly/>
			</div>
			
			<div class="form-group">
				<label>지출 음료비 합계</label>
				<input type="number" class="form-control" name="accMoney" value="${drinkaccount.accMoney}" readonly/>
			</div>
			<div class="form-group">
				<label>지출 구장비 합계</label>
				<input type="number" class="form-control" name="accMoney" value="${stadiumaccount.accMoney}" readonly/>
			</div>
			<div class="form-group">
				<label>지출 물품비 합계</label>
				<input type="number" class="form-control" name="accMoney"   value="${goodsaccount.accMoney} " readonly/>
			</div>
				
				<a href="/account/list" class="btn btn-info">목록</a>
					

		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="../includes/footer.jsp"%>
