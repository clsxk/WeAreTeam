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
	<h1 class="h3 mb-2 text-gray-800">경기일정 상세보기</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
		</div>
		<div class="card-body">
				<div class="form-group">
					<label>번호</label> 
					<input class="form-control" name="matchNo" value="${match.matchNo}" readonly />
				</div>
				<div class="form-group">
					<label>경기날짜</label>
					<input class="form-control" name="matchDate" value="${match.matchDate}" readonly/>
				</div>
				<div class="form-group">
					<label>경기장</label>
					<textarea class="form-control" name="matchStadium" rows="1" readonly>${match.matchStadium }</textarea>
				</div>
				<div class="form-group">
					<label>상대팀</label>
					<input class="form-control" name="matchTeam" value="${match.matchTeam}" readonly/>
				</div>
				<div class="form-group">
					<label>경기결과</label> 
					<input class="form-control" name="matchResult" value="${match.matchResult}" readonly/>
				</div>
				<div class="form-group">
					<label>팀득점</label> 
					<input class="form-control" name="matchGole" value="${match.matchGole}" readonly/>
				</div>
				<div class="form-group">
					<label>팀실점</label> 
					<input class="form-control" name="matchLostPoint" value="${match.matchLostPoint}" readonly/>
				</div>
<%-- 				<div class="form-group">
					<label>득점자</label> 
					<input class="form-control" name="userName" value="${record.userName}" readonly/>
				</div>
				<div class="form-group">
					<label>골</label> 
					<input class="form-control" name="recordGole" value="${record.recordGole}" readonly/>
				</div>
				<div class="form-group">
					<label>어시</label> 
					<input class="form-control" name="recordAssist" value="${record.recordAssist}" readonly/>
				</div> --%>
			<c:forEach var ="record" items="${pointList}"> 
			<div class="form-group" style="border: 1px; float: left; width: 33%;">
				<label>득점자</label> <input type="text" class="form-control" rows="3"
					name="recordGole" value="${record.userName}" readonly/>
			</div>
			<div class="form-group" style="border: 1px; float: left; width: 33%;">
				<label>골</label> <input type="number" class="form-control" rows="3"
					name="recordGole" value="${record.recordGole}" readonly/>
			</div>
			<div>
				<div class="form-group"
					style="border: 1px; float: left; width: 33%;">
					<label>어시</label> <input type="number" class="form-control"
						rows="3" name="recordAssist" value="${record.recordAssist}" readonly/>
				</div>
			</div>
			</c:forEach>


			<a href="/match/modify?matchNo=${match.matchNo}" class="btn btn-light">수정</a>
				<a href="/match/list" class="btn btn-info">목록</a>
				
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
