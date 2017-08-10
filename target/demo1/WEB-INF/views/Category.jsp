
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="form-horizontal">
				
				<form:form action="/admin/addNewCategory" commandName="categories" method="post" >

					<%-- <div class="form-group">
						<label class="col-md-4 control-label" for="pid">PID</label>
						<div class="col-md-6">
							<form:input path="pid" class="form-control" />
						</div>
					</div> --%>

					<div class="form-group">
						<label class="col-md-4 control-label" for="categoryName">Category Name</label>
						<div class="col-md-6">
							<form:input path="categoryName" class="form-control" />
						</div>
					</div>					
							
			<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button  id="submit" name="submit" class="btn btn-primary">Add Category</button>
						</div>
						</div>						
							
				</form:form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>