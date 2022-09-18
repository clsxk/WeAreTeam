<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">경기일정 등록하기</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">경기일정 등록</h6>
                        </div>
                        <div class="card-body">
								<form role="form" action="/match/register" method="post">
<!-- 								<div class="form-group">
										<label>경기날짜</label>
										<input type="datetime-local" name="matchDate" />
									</div>   -->
									<div class="form-group">
										<label>경기장</label>
										<textarea class="form-control" name="matchStadium" rows="1" placeholder="경기장을 입력 하세요"></textarea>
									</div>
									<div class="form-group">
										<label>상대팀</label>
										<textarea class="form-control" name="matchTeam" rows="1" placeholder="상대팀을 입력 하세요"></textarea>
									</div>
									<div class="form-group">
										<label>경기결과</label>
										<select class="form-control" name="matchResult" rows="1">
    										<option value="경기전">경기전</option>
    										<option value="승">승</option>
    										<option value="무">무</option>
    										<option value="패">패</option>
										</select>
									</div>

									<button type="submit" class="btn btn-light">등록</button>
									<button type="reset" class="btn btn-light">리셋</button>
								</form>							
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

	<%@include file="../includes/footer.jsp" %>