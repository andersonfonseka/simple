<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>
<html>

<jsp:include page="../layout/header.jsp" />

<body>
	<div class="container-fluid">
		 <div class="row">
			<div class="col-2">
				<jsp:include page="../layout/menu.jsp" />
			</div>
			<div class="col-10">
				<form name="projectForm" method="post"
					action="../simple-web/projectController.do?op=execute">
					<p>
					<h2>Project</h2>
					<div class="mb-3">
						<s:table name="projectForm" property="projects" rows="10" paginationUrl="../simple-web/projectController.do?op=pagination">
							<s:column property="name" title="NAME" action="../simple-web/projectController.do?op=details">
								<s:param property="id" id="id"></s:param>
							</s:column>
							<s:column property="description" title="SUMMARY"></s:column>
						</s:table>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
	<jsp:include page="../layout/footer.jsp" />
</html>
