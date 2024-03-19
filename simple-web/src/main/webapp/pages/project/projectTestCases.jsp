<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Casos de Teste</h2>
	
	<h5>
		<b><s:content name="name" property="projectForm"></s:content></b>
	</h5>
	<s:content name="description" property="projectForm"></s:content>
	<hr />
	
	<div class="mb-3">
		<s:table name="projectForm" property="testCases" rows="50">
			<s:column property="funcionality" title="Funcionalidade" style="btn btn-link"
				action="../simple-web/ProjectController.do?op=startTestCasesDetails">
				<s:param property="id" id="id"></s:param>
			</s:column>
		</s:table>
	</div>
    
    <div class="mb-3">
		<s:button type="button" title="Cancel" style="btn btn-danger"
			name="projectForm"
			action="../simple-web/ProjectController.do?op=startFeature">
			<s:param property="id" id="id"></s:param>
		</s:button>
	</div>
</form>

