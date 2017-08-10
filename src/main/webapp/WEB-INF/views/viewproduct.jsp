<%@include file="header.jsp" %>
<c:if test="${not empty error }">
<div class="error">${error }
</div>
</c:if>
<h3>PRODUCT DESCRIPTION</h3>
<table>
<tr><td>PRODUCT NAME</td><td> ${pd.pname}</td></tr>
<tr><td>PRODUCT PRICE</td><td> ${pd.price}</td></tr>
<tr><td>Quantity</td><td>${pd.qty }</td></tr>
</table>


<c:if  test="${pd.qty==0 }">
Out Of Stock
</c:if>

<c:if test="${pd.qty!=0 }">

<c:url value="/cart/addtocart/${pd.pid }" var="url"></c:url>

<form action="${url }">
Enter Units
<input type="test" name="units"><br>

<button type="submit" style="background:none;border:none;padding:0" class="btn btn-default btn-lg">
<br>
<c:if test="${pageContext.request.userPrincipal.name!=null}">
Add To Cart
<span class="glyphicon glyphicon-shopping-cart"></span></button></form>
</c:if>
</form>
</c:if>

<c:url value="/getallproduct" var="urll"></c:url>
<a href="${urll }">Back To Product</a><br>

<%@include file="footer.jsp" %>