<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="johnstep.Expenses" id="Exp" />


<%

Calendar d = new GregorianCalendar();
int month = d.get(Calendar.MONTH)+1;
int year = d.get(Calendar.YEAR);

Expenses exp = new Expenses();


%>

<sql:query var="rs" dataSource="jdbc/TestDB">
select * from v_fund  
</sql:query>

<html>
<head><title>История копилки</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p>
  <p><a href="reports.jsp">Отчеты</a></p>
  <hr/>
  
  <h1>История копилки</h1>
  
  <p>
  
  <table border="1">
    <tr>
     <th width="30">ID</th>
     <th width="100">Валюта</th>
     <th width="100">Количество</th>
     <th width="100">Стоимость</th>
     <th width="100">Описание</th>
     <th width="100">Дата</th>
    </tr>
  <c:forEach var="row" items="${rs.rows}">
    <tr>
       <th>${row.id}</th> 
       <th>${row.cur_desc}</th> 
       <th>${row.amount}</th> 
       <th>${row.sale_price}</th> 
       <th>${row.description}</th> 
       <th>${row.update_date}</th> 
            
    </tr>
  </c:forEach>
    
    
  </table>



  </body>
</html>