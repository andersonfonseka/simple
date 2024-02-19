<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<html>

<jsp:include page="${top}" />

<body>
	<div class="container-fluid">
		 <div class="row">
			<div class="col-3">
				<jsp:include page="${menu}" />
			</div>
			<div class="col-9">
				<p>
				<s:alert></s:alert>
				<jsp:include page="${body}" />
			</div>
		</div>
	</div>

</body>
	<jsp:include page="${bottom}" />
</html>
