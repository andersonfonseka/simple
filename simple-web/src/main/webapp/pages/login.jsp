<%@ taglib uri="http://simple.org/simple-taglib" prefix="s"%>

<form name="loginForm" method="post"
	action="../simple-web/LoginController.do?op=login" >
	<p>
	<h2>Accesso</h2>
	<div class="mb-3">
		<s:input label="Usuário" name="username" property="loginForm"
			type="text" placeHolder="'Type your username here...'"/>
	</div>

	<div class="mb-3">
		<s:input label="Senha" name="password" property="loginForm"
			type="password" placeHolder="'Type your password here...'"/>
	</div>


	<hr />
	<div class="mb-3">
		<s:button title="Conectar"></s:button>
	</div>

</form>

