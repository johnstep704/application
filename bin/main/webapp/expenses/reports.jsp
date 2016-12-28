<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%

Calendar d = new GregorianCalendar();
int month = d.get(Calendar.MONTH)+1;
int year = d.get(Calendar.YEAR);

%>

<html>
<head><title>Отчеты</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <hr/>
    <p><a href="expenses.jsp">Расходы</a></p>
  <hr/>
  
      <p>
      <form action="total.jsp" method="GET">
         <p>1. Ежемесячные расходы за год:  <input type="text" name="year"  value = <%=year %> />
         <input type="submit" value="Получить" />  <p/>
         
      </form>
      <p> </p>
      <p> </p>
      
      <form action="monthly.jsp" method="GET">
         <p>2. Расходы за :  <input type="text" name="month"  value = <%=month %>  /> месяц
         <input type="text" name="year"  value = <%=year %>  /> год
         <input type="submit" value="Получить" />  <p/>
         
      </form>
      
       <p> </p>
       <form action="fundhistory.jsp" method="GET">
         <p>3. История копилки :
         <input type="submit" value="Получить" />  <p/>
         
      </form>

  </body>
</html>