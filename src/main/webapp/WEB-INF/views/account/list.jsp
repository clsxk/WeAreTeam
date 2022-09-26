<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		var registerNo = '<c:out value="${registerNo}"/>';
		checkRegisterModal(registerNo);
		function checkRegisterModal(no) {
			if(no===''){
				return;
			}
			$(".modal-body").html("게시물 "+parseInt(no)+" 번이 등록되었습니다");
			$("#myModal").modal("show");
			
		}
		
		var removeResult = '${removeResult}';
		checkRemoveModal(removeResult);
		function checkRemoveModal(result) {
			if(result ===''){
				return;
			}
			if(result == 'true'){
				$(".modal-body").html("삭제를 성공하였습니다");	
			} else {
				$(".modal-body").html("삭제를 실패하였습니다");	
			}
			$("#myModal").modal("show");
		}
		
		
	})
</script>


	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">수입&지출</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                    
                        <div class="card-header py-3">
                        	<div class="row" style="justify-content: space-between;">
                            <h6 class="m-0 font-weight-bold text-primary"></h6>
                            <a href="/board/register" class="btn btn-info">수입&지출 등록하기</a>
                            </div>
                        </div>
                    
                    
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>팀이름</th>
                                            <th>구분</th>
                                            <th>내용</th>
                                            <th>금액</th>        
                                            <th>날짜</th>
                                            <th>비고</th>
                                        </tr>
                                    </thead>     
                                    <tbody>
                                     <c:forEach var="account" items="${accountList }">
                                     	<tr>
                                     		<%-- <td><a href="/account/read?accNum=${account.accNum }">${account.accNum}</a></td> --%>
                                     		<td>${account.accNum }</td>
                                     		<td>${account.teamName }</td>
                                     		<td>${account.accDivision }</td>
                                     		<td>${account.accContent }</td>
                                     		<td>${account.accMoney }</td>
                                     		<td><fmt:formatDate value="${account.accDate}" pattern="yyyy/MM/dd" /></td>
                                     		<td>${account.accNote }</td>
                                     	</tr>
                                     </c:forEach>
                                    </tbody>
                                </table>
                                
                       <!-- Logout Modal-->
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

                </div>
                <!-- /.container-fluid -->

      
            <!-- End of Main Content -->

	<%@include file="../includes/footer.jsp" %>