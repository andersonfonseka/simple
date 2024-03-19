<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=create" >
	<p>
	<h2>Projetos</h2>
	<div class="mb-3">
		<s:input label="Name" name="name" property="projectForm"
			type="text" placeHolder="'Type your name here...'"/>
	</div>

	<div class="mb-3">
		<s:textarea rows="3" label="Description" name="description"
			property="projectForm"
			placeHolder="'Type the project description here...'" />
	</div>
	
	<hr />
	<div class="mb-3">
		<s:button title="Salvar"></s:button>
		<s:button type="button" title="Cancelar" style="btn btn-danger" action="goUrl('./ProjectController.do?op=load');"></s:button>
	</div>

</form>

