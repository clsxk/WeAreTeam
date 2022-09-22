<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">팀관리</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                    
                        <div class="card-header py-3">
                        	<div class="row" style="justify-content: space-between;">
                            <h6 class="m-0 font-weight-bold text-primary">경기기록</h6>
                            </div>
                        </div>
                    
                    
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>이름</th>
                                            <th>경기수</th>
                                            <th>골</th>
                                            <th>어시스트</th>
                                            <th>경기당 골</th>    
                                            <th>경기당 어시스트</th>
                                            <th>경기참여율</th>
    
                                        </tr>
                                    </thead>     
                                    <tbody>
                                     <c:forEach var="record" items="${#}">
                                     	<tr>
                                     		<td>${#}</td>
                                     		<td>${#}</td>
                                      		<td>${#}</td>
                                     		<td>${#}</td>
                                     		<td>${#}</td>
                                     		<td>${#}</td>                                  		
                                     	</tr>
                                     </c:forEach>
                                    </tbody>
                                </table>              
                            </div>


		</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

	<%@include file="../includes/footer.jsp" %>