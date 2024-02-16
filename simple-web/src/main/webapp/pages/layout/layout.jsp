<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<html>

<jsp:include page="${top}" />

<body>
	<div class="container-fluid">
		 <div class="row">
			<div class="col-2">
				<jsp:include page="${menu}" />
			</div>
			<div class="col-10">
				<s:alert></s:alert>
				<jsp:include page="${body}" />
			</div>
		</div>
	</div>

</body>
	<jsp:include page="${bottom}" />
</html>
