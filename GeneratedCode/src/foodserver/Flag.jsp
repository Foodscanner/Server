<!-- "Visual Paradigm: DO NOT MODIFY THIS FILE!"

This is an automatic generated file. It will be regenerated every time 
you generate persistence class.

Modifying its content may cause the program not work, or your work may lost.-->

<!-- Licensee: Hamburg University of Applied Sciences
License Type: Academic-->
<html>
<jsp:useBean id="FlagBean" scope="page" class="foodServer.FlagProcessor" />
<jsp:setProperty name="FlagBean" property="*" />
<% String result = FlagBean.process(); %>

<script language="javascript">
<!--
function perform(command)  {
		form1.action.value = command;
		form1.submit();
		return true;
	}
function listAll()  {
		window.location.href = 'FlagList.jsp';
		return true;
	}
// -->
</script>
<head><title>Flag</title>
</head>
<body>
<h1>Flag</h1>
<form method="POST" name="form1" action=Flag.jsp>
	<table>
		<tr>
			<td>*_id : </td>
			<td><input type=text name="_id" value="<jsp:getProperty name="FlagBean" property="_id"/>" /></td>
		</tr>
		<tr>
			<td>_name : </td>
			<td><input type=text name="_name" value="<jsp:getProperty name="FlagBean" property="_name"/>" /></td>
		</tr>
		<tr>
			<td>_description : </td>
			<td><input type=text name="_description" value="<jsp:getProperty name="FlagBean" property="_description"/>" /></td>
		</tr>
		<tr>
			<td>_limitToProduct : </td>
			<td><input type=text name="_limitToProduct" value="<jsp:getProperty name="FlagBean" property="_limitToProduct"/>" /></td>
		</tr>
		<tr>
			<td>_unnamed_Article__article_id : </td>
			<td><input type=text name="_unnamed_Article__article_id" value="<jsp:getProperty name="FlagBean" property="_unnamed_Article__article_id"/>" /></td>
		</tr>
		<tr>
			<td>_unnamed_Ingredient__ingredient_id : </td>
			<td><input type=text name="_unnamed_Ingredient__ingredient_id" value="<jsp:getProperty name="FlagBean" property="_unnamed_Ingredient__ingredient_id"/>" /></td>
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
