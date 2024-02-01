<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>
<html>

<jsp:include page="layout/header.jsp" />

<body>
	<div class="album py-5 bg-body-tertiary">
		<div class="container">
			<div class="bd-example-snippet bd-code-snippet">
				<div class="bd-example m-0 border-1">

					<form name="projectForm" method="post"
						action="../simple-web/projectController.do?op=execute">
						<h2>Project</h2>
						
						<div class="mb-3">
							<s:table name="projectForm" property="projects" rows="10" paginationUrl="../simple-web/projectController.do?op=pagination">
								<s:column property="id" title="ID"></s:column>
								<s:column property="name" title="NAME"></s:column>
								<s:column property="description" title="SUMMARY"></s:column>
							</s:table>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	</main>

</body>
</html>
