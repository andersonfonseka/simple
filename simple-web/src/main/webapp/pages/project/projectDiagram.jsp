<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Diagrama de Fluxo de Informação</h2>
	
	<h5>
		<b><s:content name="funcionality" property="testScenario"></s:content></b>
	</h5>
	
	<pre class="mermaid">
		<s:content name="testingScenarioDiagram" property="testScenario"></s:content>
    </pre>
    
    <hr />
	<div class="mb-3">
		<s:button type="button" title="Cancel" style="btn btn-danger" action="goUrl('./ProjectController.do?op=load');"></s:button>
	</div>
    
</form>

