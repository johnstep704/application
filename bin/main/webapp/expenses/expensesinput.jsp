<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

Calendar d = new GregorianCalendar();
int vMonth = d.get(Calendar.MONTH)+1;
int vYear = d.get(Calendar.YEAR);


%>


<sql:query var="rs" dataSource="jdbc/TestDB">
select * from t_operation_type
</sql:query>

<html>
<head><title>Добавить запись</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p>
  <hr/>
 

  
  <form action="response.jsp" method="GET">
  <p>
  <p>Месяц: <input type="text" name="month"  value = <%=vMonth %> /><p/>
  <p>Год: <input type="text" name="year"  value = <%=vYear %> /><p/>
  
  Тип расходов:
  <p>
  
  <c:forEach var="row" items="${rs.rows}">
    <input type="radio" name="oper_type" value= "${row.id}" > ${row.description} <br>

  </c:forEach>
  </p>
  
  <p>Описание: <input type="text" name="desc"  /><p/>
  <p><b>Сумма: <input type="text" name="amount" value = "0" /> </b> <p/>
  
  <p><input type="submit" value="Записать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
    
  </body>
</html>