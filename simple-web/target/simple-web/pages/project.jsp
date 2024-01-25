<%@ taglib uri="WEB-INF/taglib/simple.tld" prefix="simpleInput" %>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="projectForm" method="post" action="simple-web/projectController.do?op=teste">
	<s:simpleInput label="Name" type="text" placeholder="Type your name here..."/>
	<input type="submit" value="enviar"/>
</form>
</body>
</html>