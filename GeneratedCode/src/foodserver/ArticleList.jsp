<!-- "Visual Paradigm: DO NOT MODIFY THIS FILE!"

This is an automatic generated file. It will be regenerated every time 
you generate persistence class.

Modifying its content may cause the program not work, or your work may lost.-->

<!-- Licensee: Hamburg University of Applied Sciences
License Type: Academic-->
<html>
<head><title>Article List</title>
</head>
<body>
<center>
<h1>Article List</h1>
<table border="1" width="80%">
	<tr>
		<td>_id(PK)</td>
		<td>_name</td>
		<td>_description</td>
		<td>_imageURI</td>
		<td>_ingredients</td>
		<td>_flags</td>
		<td>_unnamed_ArticleUtil_</td>
		<td>_unnamed_Ingredient_(FK)</td>
		<td>_unnamed_Flag_(FK)</td>
		<td></td>
	</tr>
<%
foodServer.Article[] articles = foodServer.Article.listArticleByQuery(null, null);
for(int i = 0; i < articles.length; i++) {
		out.print("<tr>");
		out.print("<td>");
		out.print(articles[i].get_id());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_name());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_description());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_imageURI());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_ingredients());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_flags());
		out.println("</td>");
		out.print("<td>");
		out.print(articles[i].get_unnamed_ArticleUtil_());
		out.println("</td>");
		
		foodServer.Ingredient _unnamed_Ingredient_ = articles[i].get_unnamed_Ingredient_();
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
		
		
		foodServer.Flag _unnamed_Flag_ = articles[i].get_unnamed_Flag_();
		if(_unnamed_Flag_ != null) {
			out.print("<td>");
			out.print("<a href=\"Flag.jsp?action=search&_id=");
			out.print(_unnamed_Flag_.get_id());
			out.print("\">");
			out.print(_unnamed_Flag_);
			out.println("</td>");
		}
		
		else
 {
out.println("<td></td>");
		}
		
		out.print("<td>");
		out.print("<a href=\"Article.jsp?action=search&_id=");
		out.print(articles[i].get_id());
		out.print("\">");
out.print("Edit");out.println("</a>");		out.println("</td>");
		out.println("</tr>");
}

%>
</table><br>
<a href="index.html">Index page</a>
 | 
<a href="Article.jsp">Add Article</a>
</center>
</body>
</html>
