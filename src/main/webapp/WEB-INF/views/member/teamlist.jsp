<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		var createResult = '${createResult}';
		checkRemoveModal(createResult);
		function checkRemoveModal(result) {
			ifcresult ===''){
				return;
			}
			if(result == 'true'){
				$(".modal-body").html("팀생성이 성공하였습니다. 로그아웃이 필요합니다");	
			} else {
				$(".modal-body").html("팀생성이 실패하였습니다");	
			}
			$("#myModal").modal("show");
		}
	})	
	
	$(document).ready(function() {
		
		var requestResult = '${requestResult}';
		checkRemoveModal(requestResult);
		function checkRemoveModal(result) {
			if(result ===''){
				return;
			}
			if(result == 'true'){
				$(".modal-body").html("팀신청 완료. 팀매니저 수락시 팀원에 등록됩니다.");
			} else {
				$(".modal-body").html("팀신청이 실패하였습니다");	
			}
			$("#myModal").modal("show");
		}
	})

		


		
</script>
	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">팀 검색</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                    
                        <div class="card-header py-3">
                        	<div class="row" style="justify-content: space-between;">
                            <h6 class="m-0 font-weight-bold text-primary">팀 목록</h6>
                            </div>
                        </div>
                    
                    
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>아이디</th>
                                            <th>팀이름</th>
                                            <th>팀매니저</th>
                                            <th>지역</th>
                                            <th>나이</th>    
    
                                        </tr>
                                    </thead>     
                                    <tbody>
                                     <c:forEach var="member" items="${teamList}">
                                     	<tr>
                                     		<td><a href="/member/readTeam?userId=${member.userId}">${member.userId}</a></td>
                                     		<td>${member.teamName}</td>
                                     		<td>${member.userName}</td>
                                      		<td>${member.userLocation}</td>
                                     		<td>${member.userAge}</td>                                 		
                                     	</tr>
                                     </c:forEach>
                                    </tbody>
                                </table>              
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



		</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

	<%@include file="../includes/footer.jsp" %>