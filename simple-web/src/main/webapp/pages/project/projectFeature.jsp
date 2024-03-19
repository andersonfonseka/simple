<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="projectForm" method="post"
	action="../simple-web/ProjectController.do?op=execute">
	<p>
	<h2>Recursos</h2>
	<br />
	<h5>
		<b><s:content name="name" property="projectForm"></s:content></b>
	</h5>
	<s:content name="description" property="projectForm"></s:content>
	<hr />

	<div class="row">
		<div class="col-sm-4 mb-3 mb-sm-0">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Funcionalidades</h5>
					<p class="card-text">Exibe as funcionalidades principais do
						projeto.</p>
					<s:button type="button" title="Mais..." style="btn btn-primary" name="projectForm"
						action="../simple-web/ProjectController.do?op=startFunctionality">
							<s:param property="id" id="id"></s:param>
					</s:button>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Casos de Testes</h5>
					<p class="card-text">Exibe os casos de testes para cada funcionalidade do projeto.</p>
					<s:button type="button" title="Mais..." style="btn btn-primary" name="projectForm"
						action="../simple-web/ProjectController.do?op=startTestCases">
							<s:param property="id" id="id"></s:param>
					</s:button>
				</div>
			</div>
		</div>

		<div class="col-sm-4">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Diagrama de Fluxo de Testes</h5>
					<p class="card-text">Exibe um diagrama com os fluxo de testes para cada funcionalidade prevista no projeto.</p>
					<a href="#" class="btn btn-primary">Mais...</a>
				</div>
			</div>
		</div>
	</div>


	<br />
	<div class="mb-3">
		<s:button type="button" title="Cancel" style="btn btn-danger" name="projectForm"
			action="../simple-web/ProjectController.do?op=load">
		</s:button>
	</div>

</form>

