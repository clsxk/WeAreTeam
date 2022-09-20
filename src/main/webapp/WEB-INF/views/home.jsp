<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		var createResult = '<c:out value="${createResult}"/>';
		checkcreateModal(createResult);
		function checkcreateModal(result) {
			if (result === '') {
				return;
			}
			if(result == 'true'){
				$(".modal-body").html("팀생성을 성공하였습니다 로그아웃이 필요합니다");
			}else{
				$(".modal-body").html("팀생성을 실패하였습니다");
			}
			$("#myModal").modal("show");
		}
	})
</script>


<div class="container-fluid">

	    
	    <h1 class="h3 mb-4 text-gray-800">안녕하세요</h1>
	    <h1 class="h3 mb-4 text-gray-800">사용자이름 : <sec:authentication property="principal.Username" /></h1>
	    <h1 class="h3 mb-4 text-gray-800">사용자권한 : <sec:authentication property="principal.authorities" /></h1>
</div>


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




<%@include file="includes/footer.jsp"%>