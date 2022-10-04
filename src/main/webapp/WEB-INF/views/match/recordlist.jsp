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
                         <div class="card-body">
                         
                         
              <div class="form-group" style="border: 1px; float: left; width: 20%;">
				<label>팀 총 경기수</label> <input type="text" class="form-control" rows="3"
					name="matchNo" value="${matchRecord.matchNo}" readonly/>
				</div>
			<div class="form-group" style="border: 1px; float: left; width: 20%;">
				<label>팀 전체 득점</label> <input type="number" class="form-control" rows="3"
					name="matchGole" value="${matchRecord.matchGole}" readonly>
				</div>
				<div class="form-group"
					style="border: 1px; float: left; width: 20%;">
					<label>팀 전체 실점</label> <input type="number" class="form-control"
						rows="3" name="matchLostPoint" value="${matchRecord.matchLostPoint}" readonly/>
				</div>
				<div class="form-group"
					style="border: 1px; float: left; width: 20%;">
					<label>팀 전체 경기 당 실점</label> <input type="number" class="form-control"
						rows="3"  value="<fmt:formatNumber value="${matchRecord.matchGole/matchRecord.matchNo}" pattern="#.##"/>" readonly/>
				</div>
				<div class="form-group"
					style="border: 1px; float: left; width: 20%;">
					<label>팀 전체 경기 당 실점</label> <input type="number" class="form-control"
						rows="3"  value="<fmt:formatNumber value="${matchRecord.matchLostPoint/matchRecord.matchNo}" pattern="#.##"/>" readonly/>
				</div>
                            
           
                        </div>
					
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>팀이름</th>
                                         	<th>참여 경기수</th>
                                        	<th>이름</th>
                                            <th>전체 골</th>
                                            <th>전체 어시스트</th>
                                            <th>경기당 골</th>
                                            <th>경기당 어시스트</th>
    
                                        </tr>
                                    </thead>     
                                    <tbody>
                                     <c:forEach var="record" items="${recordList}">
                                     	<tr>
                                     		<td>${record.teamName}</td>
                                     		<td>${record.matchNo}</td>
                                     		<td>${record.userName}</td>
                                     		<td>${record.recordGole}</td>
                                     		<td>${record.recordAssist}</td>
                                     		<td>${record.recordGole/record.matchNo}</td>
                                     		<td>${record.recordAssist/record.matchNo}</td>                               		
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