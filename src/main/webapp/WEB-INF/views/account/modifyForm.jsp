<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		var modifyResult = '<c:out value="${modifyResult}"/>';
		checkModifyModal(modifyResult);
		function checkModifyModal(result) {
			if (result === '') {
				return;
			}
			if(result == 'true'){
				$(".modal-body").html("수정을 성공하였습니다");
			}else{
				$(".modal-body").html("수정을 실패하였습니다");
			}
			$("#myModal").modal("show");
		}
	})
</script>

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
		<form role="form" action="/account/modify" method="post">
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
				<select name="accDivision" class="form-control">
						<option value="수입">수입</option>
						<option value="지출">지출</option>
					</select>
				</div>
			<div class="form-group">
				<label>내용</label>
				 <select name="accContent" class="form-control">
						<option value="회비">회비</option>
						<option value="음료비">음료비</option>
						<option value="구장비">구장비</option>
						<option value="물품비">물품비</option>
						<option value="기타">기타</option>
					</select>
				</div>
			<div class="form-group">
				<label>금액</label>
				<input type="number" class="form-control" name="accMoney" value="${account.accMoney}" />
			</div>
			<div class="form-group">
				<label>날짜</label>
				<input type="date" class="form-control" name="accDate" value="${account.accDate}" />
			</div>
			<div class="form-group">
				<label>비고</label>
				<input class="form-control" name="accNote" value="${account.accNote}" />
			</div>
				
				<button type="submit" class="btn btn-light">수정</button>
				<a href="/account/remove?accNum=${account.accNum}" class="btn btn-danger">삭제</a>
				<a href="/account/list" class="btn btn-info">목록</a>
						</form>
				
				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">처리결과</h5>
								<button class="close" type="button" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body"></div>
							<div class="modal-footer">
								<button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="../includes/footer.jsp"%>
