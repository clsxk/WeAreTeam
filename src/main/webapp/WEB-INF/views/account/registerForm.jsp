<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">수입&지출 등록하기</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">수입&지출 등록</h6>
                        </div>
                        <div class="card-body">
								<form role="form" action="/account/register" method="post">
									<div class="form-group">
										<label>구분</label>
										<textarea class="form-control" name="accDivision" rows="3" placeholder="구분을 입력 하세요"></textarea>
									</div>
									<div class="form-group">
										<label>내용</label>
										<input class="form-control" name="accDivision" placeholder="내용을 입력 하세요">
									</div>
									<div class="form-group">
										<label>금액</label>
										<textarea class="form-control" name="accMoney" rows="3" placeholder="금액을 입력 하세요"></textarea>
									</div>
<!-- 									<div class="form-group">
										<label>날짜</label>
										<textarea class="form-control" name="accDate" rows="3" placeholder=""></textarea>
									</div> -->
									<div class="form-group">
										<label>비고</label>
										<textarea class="form-control" name="accNote" rows="3" placeholder="비고를 입력 하세요"></textarea>
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