<%@page import="io.baseClasses.IOArticle"%>
<%@page import="database.ArticleUtil"%>
<%@page import="foodServer.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>       


<t:genericpage>
    <jsp:attribute name="header">
      <h1><c:out value="${headerOne}"/></h1>
    </jsp:attribute>
    <jsp:body>
        <h:messages/>
        <h:form id="edit_article">

            Name:
            <h:inputText id="article.getID()" 
                value="#{article.getID()}" 
                required="true" 
                requiredMessage="You need to enter an EAN" />
            <h:message for="the_ean"/>
            <br/>

            <h:commandButton 
                value="Speichern" 
                action="#{personFormular.speichern}"/>
            <h:commandButton 
                value="Abbrechen" 
                action="#{personFormular.abbrechen}"/>

        </h:form>
            <p><c:out value="${article.getID()}"/></p>
            <p><c:out value="${article.name}"/></p>
            <p><c:out value="${article.description}"/></p>
            <p><c:out value="${article.imageURL}"/></p>
        <table>
    		<c:forEach var="flag" items="${article.flags}">
        		<tr>
                    <td>${flag.getName()}</td>
        		</tr>
    		</c:forEach>
		</table>
    </jsp:body>
</t:genericpage>