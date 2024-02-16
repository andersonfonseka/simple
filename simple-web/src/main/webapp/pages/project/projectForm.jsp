<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<div class="col-10">
<form name="projectForm" method="post"
	action="../simple-web/projectController.do?op=execute" >
	<p>
	<h2>Project</h2>
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
		<s:select label="Management Approach" name="approach"
			property="projectForm" items="approachList" />
	</div>

	<div class="mb-3">
		<s:radio label="Management Framework" name="framework"
			property="projectForm" items="frameworkList" />
	</div>

	<hr />
	<div class="mb-3">
		<s:button title="Apply"></s:button>
		<s:button type="button" title="Cancel" style="btn btn-danger" action="goUrl('./projectController.do?op=load');"></s:button>
	</div>

</form>
</div>

