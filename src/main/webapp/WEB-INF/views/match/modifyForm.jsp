<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

	<%@include file="../includes/header.jsp" %>

<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
$(document).ready(function() {
	  $('#matchResult').change(function() {
	    var result = $('#matchResult option:selected').val();
	    if (result == '경기전') {
	    	$('.point').hide();
	    } else {
	    	$('.point').show();
	    }
	  }); 
	}); 


function add_div(){    
	var div = document.createElement('div');    
	div.innerHTML = document.getElementById('room_type').innerHTML;    
	document.getElementById('field').appendChild(div);
	}

function remove_div(obj){document.getElementById('field').removeChild(obj.parentNode);

	}


</script>

	
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">경기일정 수정하기</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">수정폼</h6>
                        </div>
                        <div class="card-body">
							<form role="form" action="/match/modify" method="post">
								<div class="form-group">
									<label>번호</label>
									<input class="form-control" name="matchNo" value="${match.matchNo}" readonly />
								</div>
								<div class="form-group">
										<label>경기날짜</label>
										<input type="datetime-local" class="form-control" rows="1" name="matchDate" value="${match.matchDate}" ></input>
								</div> 
								<div class="form-group">
									<label>경기장</label>
									<input class="form-control" name="matchStadium" value="${match.matchStadium}"/>
								</div>						
								<div class="form-group">
									<label>상대팀</label>
									<textarea class="form-control" name="matchTeam" rows="1">${match.matchTeam}</textarea>
								</div>
									<div class="form-group" "selectBox">
										<label>경기결과</label>
										<select class="form-control" id="matchResult" name="matchResult" rows="1">
    										<option value="경기전">경기전</option>
    										<option value="승">승</option>
    										<option value="무">무</option>
    										<option value="패">패</option>
										</select>
									</div>

								<div class="point" style="display:none">
									<div class="form-group">
										<label>팀득점</label>
										<input type="number" class="form-control" rows="3" name="matchGole" value="${match.matchGole}"   />
									</div>
									<div class="form-group">
										<label>팀실점</label>
										<input type="number" class="form-control"  rows="3" name="matchLostPoint" value="${match.matchLostPoint}" />
									</div>

					<div id="room_type">

						<div class="form-group"
							style="border: 1px; float: left; width: 30%;">
							<label for="image">득점자</label> <select id="recordPoint"
								class="form-control">
								<c:forEach items="${nameList}" var="name">
									<option><c:out value="${name}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group"
							style="border: 1px; float: left; width: 30%;">
							<label>골</label> <input type="number" class="form-control"
								rows="3" name="recordGole" value="${record.recordGole}" />
						</div>
						<div>
							<div class="form-group"
								style="border: 1px; float: left; width: 30%;">
								<label>어시</label> <input type="number" class="form-control"
									rows="3" name="recordAssist" value="${record.recordAssist}" />
							</div>
						</div>
						<div class="form-group"
							style="border: 1px; float: left; width: 10;">
							<input type="button" class="btn btn-light" value="추가"
								onclick="add_div()"><br />
						</div>
						<input type="button" style="border: 1px; float: left; width: 10;"
							" class="btn btn-light" value="삭제" onclick="remove_div(this)">
					</div>

					<div id="field"></div>

				</div>
						
			
						<div class="form-group" style="border: 1px ; float: left;">
						<button type="submit" class="btn btn-light">수정</button>
						<a href="/match/remove?matchNo=${match.matchNo}" class="btn btn-danger">삭제</a>
						<a href="/match/list" class="btn btn-info">목록</a>
						</div>
							</form>
						
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

	<%@include file="../includes/footer.jsp" %>