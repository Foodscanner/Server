<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
session = request.getSession(false);
if (!session.isNew()) {
  // Session is valid
}
else {
	response.sendRedirect("../login.jsp?from=edit/product.jsp");
}
%>
<t:genericpage>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:body>
        <h2>Hi I'm the heart of the message</h2>
    </jsp:body>
</t:genericpage>