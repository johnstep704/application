<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<sql:query var="rs" dataSource="jdbc/TestDB">
select * from currency
</sql:query>

<html>
<head><title>Добавить сумму в копилку</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p>
  <hr/>
 

  
  <form action="fundresponse.jsp" method="GET">
  <p>
  Валюта:
  <p>
  
  <c:forEach var="row" items="${rs.rows}">
    <input type="radio" name="currency_id" value= "${row.id}" > ${row.description} <br>

  </c:forEach>
  </p>
  
  <p>Описание: <input type="text" name="desc"  /><p/>
  <p><b>Сумма: <input type="text" name="amount" value = "0" /> </b> <p/>
  <p><b>Стоимость валюты: <input type="text" name="sale_amount" value = "0" /> </b> <p/>
  
  <p><input type="submit" value="Записать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
    
  </body>
</html>