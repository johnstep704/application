<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
Expenses exp = new Expenses();
%>
<sql:query var="rs" dataSource="jdbc/TestDB">
select * from currency
</sql:query>

<html>
<head><title>Изменить курс валют</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p>
  <hr/>
 

  
  <form action="currencyresponse.jsp" method="GET">
  
  <p><b>Стоимость доллара: <input type="text" name="dollar" value = <%=exp.getCurrency(1) %> /> </b> <p/>
  <p><b>Стоимость евро: <input type="text" name="euro" value = <%=exp.getCurrency(2) %> /> </b> <p/>
  
  <p><input type="submit" value="Записать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
    
  </body>
</html>