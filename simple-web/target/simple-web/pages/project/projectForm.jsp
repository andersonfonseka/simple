<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>
<html>

<jsp:include page="../layout/header.jsp" />

<body>
	<div class="album py-5 bg-body-tertiary">
		<div class="container">
		<s:alert></s:alert>
	
			<div class="bd-example-snippet bd-code-snippet">
				<div class="bd-example m-0 border-1">

					<form name="projectForm" method="post"
						action="../simple-web/projectController.do?op=execute" >
						<h2>Project</h2>


						<div class="mb-3">
							<s:input label="Name" name="name" property="projectForm"
								type="text" placeHolder="'Type your name here...'"/>
						</div>

						<div class="mb-3">
							<s:textarea rows="3" label="Description" name="description"
								property="projectForm"
								placeHolder="'Type the project description here...'" />
						</div>

						<div class="mb-3">
							<s:select label="Management Approach" name="approach"
								property="projectForm" items="approachList" />
						</div>

						<div class="mb-3">
							<s:radio label="Management Framework" name="framework"
								property="projectForm" items="frameworkList" />
						</div>

						<hr />
						<div class="mb-3">
							<s:button title="Apply"></s:button>
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
