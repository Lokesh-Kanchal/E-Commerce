<%@ include file="header.jsp" %>
<div class="text-center" style="color:black;"><h4><b>LIST OF PRODUCTS</b></h4>
</div>
<div class="container">
<script>
	$(document).ready(function() {
		var searchCondition = '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" : [ [ 3, 5, 7, -1 ], [ 3, 5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>

<table class="table table-striped">

<thead>
<tr><th>Product Name</th>
<th>Price</th>
<th>Description</th>
<th>Category</th>
<th>Quantity</th>
<th>Action</th></tr>
</thead>

<tbody>
<c:forEach items="${product}" var="p" >
<tr> 
<td>${p.pname}</td>
<td>${p.price}</td>
<td>${p.description }</td>
<td>${p.category.categoryName}</td>
<td>${p.qty}</td>

<td>

<c:url var="url" value="/all/product/viewproduct/${p.pid }"></c:url>					
<a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a>

<security:authorize access="hasRole('ROLE_ADMIN')">

<c:url var="delete" value="/admin/product/deleteproduct/${p.pid }"></c:url>
<a href="${delete }"><span class="glyphicon glyphicon-trash"></span></a>


<c:url var="edit" value="/editform/${p.pid }"></c:url>
<a href="${edit }"><span class="glyphicon glyphicon-pencil"></span></a>

</security:authorize>

</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>




<%@ include file="footer.jsp" %>