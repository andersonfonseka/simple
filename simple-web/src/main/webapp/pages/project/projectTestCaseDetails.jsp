<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Casos de Teste</h2>
	
	<h5>
		<b><s:content name="funcionality" property="testScenario"></s:content></b>
	</h5>
	
	 <div class="mb-3">
		<s:button type="button" title="Diagrama" style="btn btn-primary"
			name="testScenario"
			action="../simple-web/ProjectController.do?op=startTestCasesDiagram">
			<s:param property="id" id="id"></s:param>
		</s:button>
	</div>
	
	<div class="overflow-y-scroll">
		<s:content name="testingScenario" property="testScenario"></s:content>
	</div>
	
	<div class="mb-3">
		<s:button type="button" title="Cancel" style="btn btn-danger"
			name="testScenario"
			action="../simple-web/ProjectController.do?op=startTestCases">
			<s:param property="projectId" id="id"></s:param>
		</s:button>
	</div>
</form>

