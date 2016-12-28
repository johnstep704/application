<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>


<%

Calendar d = new GregorianCalendar();
int vMonth = d.get(Calendar.MONTH)+1;
int vYear = d.get(Calendar.YEAR);


%>


<html>
<head><title>Добавить запись</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p>
  <hr/>
 

  
  <form action="openbalance.jsp" method="GET">
  <p>
  <p>Остаток на начало месяца: <input type="text" name="vOpen"  value = "0" /><p/>  
  
  <p><input type="submit" value="Записать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
    
  </body>
</html>