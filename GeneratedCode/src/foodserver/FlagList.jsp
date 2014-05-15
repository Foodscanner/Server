<!-- "Visual Paradigm: DO NOT MODIFY THIS FILE!"

This is an automatic generated file. It will be regenerated every time 
you generate persistence class.

Modifying its content may cause the program not work, or your work may lost.-->

<!-- Licensee: Hamburg University of Applied Sciences
License Type: Academic-->
<html>
<head><title>Flag List</title>
</head>
<body>
<center>
<h1>Flag List</h1>
<table border="1" width="80%">
	<tr>
		<td>_id(PK)</td>
		<td>_name</td>
		<td>_description</td>
		<td>_limitToProduct</td>
		<td>_unnamed_Article_(FK)</td>
		<td>_unnamed_Ingredient_(FK)</td>
		<td></td>
	</tr>
<%
foodServer.Flag[] flags = foodServer.Flag.listFlagByQuery(null, null);
for(int i = 0; i < flags.length; i++) {
		out.print("<tr>");
		out.print("<td>");
		out.print(flags[i].get_id());
		out.println("</td>");
		out.print("<td>");
		out.print(flags[i].get_name());
		out.println("</td>");
		out.print("<td>");
		out.print(flags[i].get_description());
		out.println("</td>");
		out.print("<td>");
		out.print(flags[i].get_limitToProduct());
		out.println("</td>");
		
		foodServer.Article _unnamed_Article_ = flags[i].get_unnamed_Article_();
		if(_unnamed_Article_ != null) {
			out.print("<td>");
			out.print("<a href=\"Article.jsp?action=search&_id=");
			out.print(_unnamed_Article_.get_id());
			out.print("\">");
			out.print(_unnamed_Article_);
			out.println("</td>");
		}
		
		else
 {
out.println("<td></td>");
		}
		
		
		foodServer.Ingredient _unnamed_Ingredient_ = flags[i].get_unnamed_Ingredient_();
		if(_unnamed_Ingredient_ != null) {
			out.print("<td>");
			out.print("<a href=\"Ingredient.jsp?action=search&_id=");
			out.print(_unnamed_Ingredient_.get_id());
			out.print("\">");
			out.print(_unnamed_Ingredient_);
			out.println("</td>");
		}
		
		else
 {
out.println("<td></td>");
		}
		
		out.print("<td>");
		out.print("<a href=\"Flag.jsp?action=search&_id=");
		out.print(flags[i].get_id());
		out.print("\">");
out.print("Edit");out.println("</a>");		out.println("</td>");
		out.println("</tr>");
}

%>
</table><br>
<a href="index.html">Index page</a>
 | 
<a href="Flag.jsp">Add Flag</a>
</center>
</body>
</html>
