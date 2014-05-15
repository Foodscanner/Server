<!-- "Visual Paradigm: DO NOT MODIFY THIS FILE!"

This is an automatic generated file. It will be regenerated every time 
you generate persistence class.

Modifying its content may cause the program not work, or your work may lost.-->

<!-- Licensee: Hamburg University of Applied Sciences
License Type: Academic-->
<html>
<head><title>Ingredient List</title>
</head>
<body>
<center>
<h1>Ingredient List</h1>
<table border="1" width="80%">
	<tr>
		<td>_id(PK)</td>
		<td>_name</td>
		<td>_flags</td>
		<td></td>
	</tr>
<%
foodServer.Ingredient[] ingredients = foodServer.Ingredient.listIngredientByQuery(null, null);
for(int i = 0; i < ingredients.length; i++) {
		out.print("<tr>");
		out.print("<td>");
		out.print(ingredients[i].get_id());
		out.println("</td>");
		out.print("<td>");
		out.print(ingredients[i].get_name());
		out.println("</td>");
		out.print("<td>");
		out.print(ingredients[i].get_flags());
		out.println("</td>");
		out.print("<td>");
		out.print("<a href=\"Ingredient.jsp?action=search&_id=");
		out.print(ingredients[i].get_id());
		out.print("\">");
out.print("Edit");out.println("</a>");		out.println("</td>");
		out.println("</tr>");
}

%>
</table><br>
<a href="index.html">Index page</a>
 | 
<a href="Ingredient.jsp">Add Ingredient</a>
</center>
</body>
</html>
