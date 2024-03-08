<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<html>

<jsp:include page="${top}" />

<body>
	<s:alert></s:alert>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<p>
				<jsp:include page="${body}" />
			</div>
		</div>
	</div>

</body>
<jsp:include page="${bottom}" />
</html>
