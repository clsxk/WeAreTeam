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



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">사용자 상세보기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label>아이디</label>
				<input class="form-control" name="userId" value="${member.userId}" readonly/>
			</div>
			<div class="form-group">
				<label>패스워드</label>
				<input type="password" class="form-control" name="userPw" value="${member.userPw}" readonly/>
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
				<label>실력</label>
				<input class="form-control" name="userLevel"  value="${member.userLevel}" readonly/>
			</div>
			<div class="form-group">
				<label>등급</label>
				<input class="form-control" name="role" value="${member.role}" readonly/>
			</div>
			
			
			<a href="/member/list" class="btn btn-info">목록</a>
			<a href="/member/modify?userId=${member.userId}" class="btn btn-light">수정</a>

			<!-- Modal 추가 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">처리결과</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body"></div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>


		</div>	
	</div>
</div>

<%@include file="../includes/footer.jsp"%>