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
                            <h6 class="m-0 font-weight-bold text-primary">팀원목록</h6>
                            </div>
                        </div>
                    
                    
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>지역</th>
                                            <th>실력</th>    
                                            <th>등급</th>
    
                                        </tr>
                                    </thead>     
                                    <tbody>
                                     <c:forEach var="member" items="${memberList}">
                                     	<tr>
                                     		<td><a href="/member/read?userId=${member.userId}">${member.userId}</a></td>
                                     		<td>${member.userName}</td>
                                      		<td>${member.userLocation}</td>
                                     		<td>${member.userLevel}</td>
                                     		<td>${member.role}</td>

                                     		
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