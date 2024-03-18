<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=update" >
	<p>
	<h2>Project</h2>
	
	<s:input name="id" property="projectForm" type="hidden"/>
	
	<div class="mb-3">
		<s:input label="Name" name="name" property="projectForm"
			type="text" placeHolder="'Type your name here...'"/>
	</div>

	<div class="mb-3">
		<s:textarea rows="3" label="Description" name="description"
			property="projectForm"
			placeHolder="'Type the project description here...'" />
	</div>
	
	<div class="mb-3">
		<s:textarea rows="100" label="Expanded Description" name="expandedDescription"
			property="projectForm"
			placeHolder=""/>
	</div>

	
	<hr />
	<div class="mb-3">
		<s:button title="Apply"></s:button>
		<s:button type="button" title="Cancel" style="btn btn-danger" action="goUrl('./ProjectController.do?op=load');"></s:button>
	</div>

</form>

