<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Projetos</h2>
	<s:button type="button" title="Novo Projeto" style="btn btn-primary btn-sm"
		action="../simple-web/ProjectController.do?op=startCreate"></s:button>
	<div class="mb-3">
		<s:table name="projectForm" property="projects" rows="10"
			paginationUrl="../simple-web/ProjectController.do?op=pagination">
			<s:column property="name" title="Nome" style="btn btn-link"
				action="../simple-web/ProjectController.do?op=startFeature">
				<s:param property="id" id="id"></s:param>
			</s:column>
			<s:column property="description" title="Descricao"></s:column>
			<s:column property="remove" title="Ações" style="btn btn-danger"
				action="../simple-web/ProjectController.do?op=startFeature">
				<s:param property="id" id="id"></s:param>
			</s:column>
		</s:table>
	</div>
</form>

