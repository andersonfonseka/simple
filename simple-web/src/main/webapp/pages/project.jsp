<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Simple Demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>

<body>

<header data-bs-theme="dark">
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="#" class="navbar-brand d-flex align-items-center">
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="me-2" viewBox="0 0 24 24"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
        <strong>Simple</strong>
      </a>
    </div>
  </div>
</header>
  
	<div class="album py-5 bg-body-tertiary">
		<div class="container">
			<div class="bd-example-snippet bd-code-snippet">
				<div class="bd-example m-0 border-0">

					<form name="projectForm" method="post"
						action="../simple-web/projectController.do?op=teste">
						<div class="mb-3">
							<s:input label="Name" name="name" property="projectForm"
								type="text" placeHolder="'Type your name here...'" />
						</div>
						<div class="mb-3">
							<s:input label="Password" name="password" property="projectForm"
								type="password" placeHolder="'Type your password here...'" />
						</div>
						<div class="mb-3">
							<s:select label="Gender" name="genderId" property="projectForm"
								placeHolder="'Choose your gender here...'" items="genderList" />
						</div>

						<button type="submit" class="btn btn-primary">Enviar</button>
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
