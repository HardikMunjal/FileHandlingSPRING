
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ page session="false"%>
 <html>
 <head>
 <title>Home</title>
 </head>
 <body>
   <c:if test="${not empty message}">
   <label style="color: green">  <c:out value="${message}"></c:out></label>
   </c:if>
   <form:form action="savefile" method="post"
     enctype="multipart/form-data" modelAttribute="myfile">
 
     <p>Please Choose a File to Upload</p>
     <input type="file" name="file" id="file" />
     <form:errors path="file"></form:errors>
     <input type="submit" value="Save" />
 
 
   </form:form>
 </body>
 </html>