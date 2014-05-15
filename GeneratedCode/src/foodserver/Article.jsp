<!-- "Visual Paradigm: DO NOT MODIFY THIS FILE!"

This is an automatic generated file. It will be regenerated every time 
you generate persistence class.

Modifying its content may cause the program not work, or your work may lost.-->

<!-- Licensee: Hamburg University of Applied Sciences
License Type: Academic-->
<html>
<jsp:useBean id="ArticleBean" scope="page" class="foodServer.ArticleProcessor" />
<jsp:setProperty name="ArticleBean" property="*" />
<% String result = ArticleBean.process(); %>

<script language="javascript">
<!--
function perform(command)  {
		form1.action.value = command;
		form1.submit();
		return true;
	}
function listAll()  {
		window.location.href = 'ArticleList.jsp';
		return true;
	}
// -->
</script>
<head><title>Article</title>
</head>
<body>
<h1>Article</h1>
<form method="POST" name="form1" action=Article.jsp>
	<table>
		<tr>
			<td>*_id : </td>
			<td><input type=text name="_id" value="<jsp:getProperty name="ArticleBean" property="_id"/>" /></td>
		</tr>
		<tr>
			<td>_name : </td>
			<td><input type=text name="_name" value="<jsp:getProperty name="ArticleBean" property="_name"/>" /></td>
		</tr>
		<tr>
			<td>_description : </td>
			<td><input type=text name="_description" value="<jsp:getProperty name="ArticleBean" property="_description"/>" /></td>
		</tr>
		<tr>
			<td>_imageURI : </td>
			<td><input type=text name="_imageURI" value="<jsp:getProperty name="ArticleBean" property="_imageURI"/>" /></td>
		</tr>
		<tr>
			<td>_ingredients : </td>
			<td><input type=text name="_ingredients" value="<jsp:getProperty name="ArticleBean" property="_ingredients"/>" /></td>
		</tr>
		<tr>
			<td>_flags : </td>
			<td><input type=text name="_flags" value="<jsp:getProperty name="ArticleBean" property="_flags"/>" /></td>
		</tr>
		<tr>
			<td>_unnamed_ArticleUtil_ : </td>
			<td><input type=text name="_unnamed_ArticleUtil_" value="<jsp:getProperty name="ArticleBean" property="_unnamed_ArticleUtil_"/>" /></td>
		</tr>
		<tr>
			<td>_unnamed_Ingredient__ingredient_id : </td>
			<td><input type=text name="_unnamed_Ingredient__ingredient_id" value="<jsp:getProperty name="ArticleBean" property="_unnamed_Ingredient__ingredient_id"/>" /></td>
		</tr>
		<tr>
			<td>_unnamed_Flag__flag_id : </td>
			<td><input type=text name="_unnamed_Flag__flag_id" value="<jsp:getProperty name="ArticleBean" property="_unnamed_Flag__flag_id"/>" /></td>
		</tr>
	</table>
	<INPUT type="hidden" name="action" value="">
	<hr>
	<INPUT type="button" value="List All" onclick="return listAll();">
	<INPUT type="button" value="Search" onclick="return perform('search');">
	<INPUT type="button" value="Insert" onclick="return perform('insert');">
	<INPUT type="button" value="Update" onclick="return perform('update');">
	<INPUT type="button" value="Delete" onclick="return perform('delete');">
	<INPUT type="reset">
</form>
<hr>
<h3><b>Result :</b><%=result%></h3>
</body>
</html>
