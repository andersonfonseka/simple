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

						<div class="row">

							<div class="col">

								<div class="mb-3">
									<s:input label="Name" name="name" property="projectForm"
										type="text" placeHolder="'Type your name here...'" />
								</div>

							</div>

							<div class="col">

								<div class="mb-3">
									<s:input label="Password" name="password"
										property="projectForm" type="password"
										placeHolder="'Type your password here...'" />
								</div>

							</div>

						</div>
						
						<div class="mb-3">
									<s:textarea rows="3" label="Description" name="description" property="projectForm"
										placeHolder="'Type the project description here...'" />
								</div>
						

						<div class="mb-3">
							<s:select label="Gender" name="genderId" property="projectForm"
								placeHolder="'Choose your gender here...'" items="genderList" />
						</div>

						<div class="mb-3">
							<s:check label="Management Approach" name="type"
								property="projectForm" placeHolder="'Choose your type here...'"
								items="typeList" />
						</div>
						<hr />
						<div class="mb-3">
							<button type="submit" class="btn btn-primary">Enviar</button>
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
