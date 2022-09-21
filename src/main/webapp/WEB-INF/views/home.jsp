<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="includes/header.jsp"%>


<div class="container-fluid">

	    
	    <h1 class="h3 mb-4 text-gray-800">안녕하세요</h1>
	    <h1 class="h3 mb-4 text-gray-800">사용자이름 : <sec:authentication property="principal.Username" /></h1>
	    <h1 class="h3 mb-4 text-gray-800">사용자권한 : <sec:authentication property="principal.authorities" /></h1>
	    
	    
</div>





<%@include file="includes/footer.jsp"%>