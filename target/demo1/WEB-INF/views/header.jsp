<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ecommerce website</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ECOMMERCE</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>
	<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	
<style type="text/css">
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

.bg-1 {
	background-color: #1abc9c; /* Green */
	color: #ffffff;
}

.bg-2 {
	background-color: #474e5d;
	color: #ffffff;
}

<!--
.jumbotron {
	background-color: #f4511e;
	color: #fff;
}

-->
.bg-5 {
	background-color: black;
}

.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 90%;
	height: 90%;
	opacity: 0.7;
}

.person:hover {
	border-color: #f1f1f1;
}

.margin {
	margin-bottom: 0px;
}

.bs-example {
	margin: 20px;
}
</style>
</head>
<body>
	<div class="bs-example">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<!-- <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
					</button> -->
					<a class="navbar-brand" href="#">HUT</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value="/home"/>">HOME</a></li>
					
					<c:url value="/aboutUs" var="url"/>
					<li><a href="${url}">ABOUT US</a></li>
					
					<c:url value="/contactUs" var="url"/>
					<li><a href="${url}">Contact Us</a></li>
					
					
					
					
					
					<li>
                     <c:url value="/admin/product/productform" var="url"/>                    
                     <c:if test="${pageContext.request.userPrincipal.name!=null }">
			<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="${url}">ADD PRODUCT</a>
					</security:authorize>
					</c:if>
					</li>
					
					<li><a href="<c:url value="/getallproduct" />">BROWSE ALL
							RPODUCT
					</a></li>
					
					
					<li>
					<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<security:authorize access="hasRole('ROLE_ADMIN')">
					 <c:url value="/admin/getcategory" var="url"/>
					<a href="${url}">ADD Category</a>
					</security:authorize>
					</c:if>
					</li>
					
					
			 <li class="dropdown">
			 <a class="dropdown-toggle" data-toggle="dropdown" >
			 SELECT BY CATEGORY<b class="caret"></b></a>
			 <ul class="dropdown-menu">
			 <li>
			 <c:forEach items="${cat}" var="c">
			 <c:url value="/all/product/searchbycategory?searchCondition=${c.categoryName}" var="url">
			 </c:url>
			 <a href="${url}">${c.categoryName}</a>			 
			 </c:forEach>
			 <c:url value="/all/product/searchbycategory?searchCondition=All" var="urll">
			 </c:url>
			 
			  <%-- <c:url value="/all/product/searchbycategory?searchCondition=New Arrival" var="url5">
			 </c:url>
			  <c:url value="/all/product/searchbycategory?searchCondition=Discount Sale" var="url6">
			 </c:url> --%>
			 
			 
			 <a href="${urll}">All</a>
			<%--  <a href="${url5}">New Arrival</a>
			 <a href="${url6}">Discount Sale</a> --%>
			 </li>
			 </ul>	 
			 </li>
			 
			 <li><security:authorize access="hasRole('ROLE_USER')">
         <li><a href="<c:url value="/cart/getcart"></c:url>">Cart</a></li>
         </security:authorize></li>
			 
					
					 <%-- <li>
						<form class="navbar-form navbar-left">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search">
								<span class="input-group-btn">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</span>
								</div></form>
					</li>  --%>

				</ul>
				
				<ul class="nav navbar-nav navbar-right">		
				<li>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<a href="">Welcome ${pageContext.request.userPrincipal.name }</a>
			</c:if>
			</li>
			
			<c:if test="${pageContext.request.userPrincipal.name==null }">
			<c:url value="/all/registrationform" var="url5"></c:url>
			<li><a href="${url5 }"><span class="glyphicon glyphicon-user"></span>Sign up</a></li>
			<c:url value="/login" var="url6"></c:url>
		    <li><a href="${url6 }"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>	
		    </c:if>
		    <c:url value="/j_spring_security_logout" var="logoutUrl"></c:url>
		    <c:if test="${pageContext.request.userPrincipal.name!=null }">
		    <li><a href="${logoutUrl }">logout</a></li>
		    </c:if>
				</ul>
				
				<%-- <ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/all/registrationform"/>"><span class="glyphicon glyphicon-user"></span>
							SIGN UP</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							LOGIN</a></li>
				</ul> --%>
			</div>
		</nav>
		</div>