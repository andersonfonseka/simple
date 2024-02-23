<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Project</h2>
	<s:button type="button" title="New" style="btn btn-primary"
		action="goUrl('./ProjectController.do?op=startCreate');"></s:button>
	<div class="mb-3">
		<s:table name="projectForm" property="projects" rows="10"
			paginationUrl="../simple-web/ProjectController.do?op=pagination">
			<s:column property="name" title="NAME" style="btn btn-link"
				action="../simple-web/ProjectController.do?op=startUpdate">
				<s:param property="id" id="id"></s:param>
			</s:column>
			<s:column property="description" title="DESCRIPTION"></s:column>
			<s:column property="approach" title="APPROACH"></s:column>
			<s:column property="framework" title="FRAMEWORK"></s:column>
			<s:column property="remove" title="ACTION" style="btn btn-danger"
				action="../simple-web/ProjectController.do?op=startUpdate">
				<s:param property="id" id="id"></s:param>
			</s:column>
		</s:table>
	</div>
</form>

