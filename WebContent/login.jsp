<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:body>
         <p>${param.email}</p>
         <p>Zum Fortfahren bitte anmelden</p><form  name="Login"  action="/login"  method="post"  accept-charset="UTF-8">
<p><b>E-Mail :</b>
<input type="email" name="email" id="email" required="true" size="40" maxlength="100"></p><p><b>Passwort :</b>
<input type="password" size="40" required="true" name="password" id="password"></p><p><input type="submit" name="submit" value="Einloggen"></p>
<input type="hidden" name="from" id="from" value="${param.from}"></form>
    </jsp:body>
</t:genericpage>