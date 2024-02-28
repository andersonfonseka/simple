<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<html>

<jsp:include page="${top}" />

<body>
	<div class="container-fluid">
		 <div class="row">
			<div class="col-12">
				<p>
				<s:alert></s:alert>
				<jsp:include page="${body}" />
			</div>
		</div>
	</div>

</body>
	<jsp:include page="${bottom}" />
</html>
