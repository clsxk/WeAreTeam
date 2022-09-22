<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

 <script src="/resources/vendor/jquery/jquery.min.js"></script>
 
 
<script type="text/javascript">
function teamCheck(){
	let teamName = $('#teamName');
	/* let teamName = document.getElementByName("teamName");   */
	
	let idSpan = $('#idSpan');
	let idSpang = $('#idSpang');
	let createBtn = $('#createBtn');
	$.ajax({
				url:'/member/teamcheck?teamName=' + teamName.val(),
				type:'GET',
				dataType:'json',
				success:function(result){
				let isDuplicate = result.isDuplicate;
					if(isDuplicate==true){
						idSpang.empty();
						idSpan.html("팀이름이 중복되었습니다");
						createBtn.attr("disabled",true);							
					} else {
						idSpan.empty();
						idSpang.html("팀이름이 사용가능합니다");
						createBtn.attr("disabled",false)
					}
				},
				error:function(){
					console.log('에러발생');
				}
		})
	}


</script>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">팀 생성하기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">생성폼</h6>
		</div>
		<div class="card-body">
		<form role="form" action="/member/create" method="post">
			<div class="form-group">
				<label>아이디</label>
				<input class="form-control" name="userId" value="${member.userId}" readonly/>
			</div>
			<div class="form-group">
				<label>이름</label>
				<input class="form-control" name="userName" value="${member.userName}" readonly/>
			</div>
			<div class="form-group row">
			<div class="col-sm-4 mb-3 mb-sm-0">
				<label>팀이름</label>
				<input class="form-control" id="teamName" name="teamName" value="${member.teamName}" />
				</div>
				 <div class="col-sm-1">
				 <label>.</label>
                   <button type="button" class="btn btn-primary btn-user btn-block" onclick="teamCheck()">중복체크</button>
              </div>
			</div>
			<div class="form-group">
			<span id="idSpan" style="color:red;"></span>
			<span id="idSpang" style="color:green;"></span>
			</div>
<!-- 			<div class="form-group">
				<label>팀상태</label>
				<input class="form-control" name="teamJoin" value="agree" readonly/>
			</div>	
			<div class="form-group">
				<label>권한</label>
				<input class="form-control" name="role" value="ROLE_ADMIN" readonly/>
			</div> -->	
			<button  type="submit" class="btn btn-primary " id="createBtn" disabled>생성</button>
			<a href="/" class="btn btn-info">목록</a>
			</form>



		</div>	
	</div>
</div>



<%@include file="../includes/footer.jsp"%>