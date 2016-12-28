<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="johnstep.Expenses" id="Exp" />


<%

String sMonth = request.getParameter("month");
String sYear = request.getParameter("year");

Calendar d = new GregorianCalendar();
int month = Integer.parseInt(sMonth) ;
int year = Integer.parseInt(sYear) ;

Expenses exp = new Expenses();
exp.setTotalAmount(month, year);
exp.setExpTypes();

double tAmount = exp.getTotalAmount();
tAmount = (double) Math.round(tAmount * 100) / 100;
%>


<html>
<head><title>Расходы за <%=month %> месяц, <%=year %> год </title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <p><a href="expenses.jsp">Расходы</a></p></th>
  <hr/>
          
    <p><a href="reports.jsp">Отчеты</a></p></th>
  <h1>Расходы за <%=month %> месяц, <%=year %> год</h1>
  
  <p> <b>Итого потрачено за месяц = <%= tAmount%></b></p>
  
  
 <table border = "1">
   <tr>
    <%
 for(ExpensesType et : exp.getExpensesTypes()){
	 %>
	         <th width="100"><%=et.getDescription() %></th>
	 
<% }%>	
   </tr>
   
   <tr>
    <%
 for(ExpensesType et : exp.getExpensesTypes()){
	 
	 int typeID = et.getId();
	 
	 %>
	         <th width="100"><%= exp.getAmountByType(typeID, month, year ) %></th>
	 
<% }%>	     
   </tr>
   
  </table>
  
  <p>
  
  <table border="1">
    <tr>
     <th width="30">ID</th>
     <th width="100">Описание</th>
     <th width="100">Тип расходов</th>
     <th width="100">Дата</th>
     <th width="100">Сумма</th>
    </tr>
    <% for(ExpensesData ed : exp.getExpensesData(year, month)){%>
    	<tr>
    	  <th> <%=ed.getId() %> </th>
    	  <th> <%=ed.getDescription() %> </th>
    	  <th> <%=exp.getExpensesTypeById(ed.getOperationType()).getDescription() %> </th>
    	  <th> <%=ed.getUpdateDateString() %> </th>
    	  <th> <%=ed.getAmount() %> </th>
    	</tr>
   <% }%> 
    
    
  </table>



  </body>
</html>