<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="johnstep.Expenses" id="Exp" />


<%

Calendar d = new GregorianCalendar();
int month = d.get(Calendar.MONTH)+1;
int year = d.get(Calendar.YEAR);

Expenses exp = new Expenses();
exp.setTotalAmount(month, year);
exp.setExpTypes();

double tAmount = exp.getTotalAmount();
tAmount = (double) Math.round(tAmount * 100) / 100;
double restAmount = exp.getRestAmount() ;

%>


<html>
<head><title>Расходы за текущий месяц</title></head>
  <body>
  <p><a href="/application/index.jsp">На главную</a></p>
  <hr/>
  
    <table border = "1">
       <tr>
          <th width = "190"><a href="expensesinput.jsp">Добавить расходы</a></p></th>
          <th width = "190"><a href="openbalanceinput.jsp">Изменить остаток</a></p></th>
          <th width = "190"><a href="fundinput.jsp">Пополнить копилку</a></p></th>
          <th width = "190"><a href="currencyinput.jsp">Изменить курс валют</a></p></th>
          <th width = "190"><a href="reports.jsp">Отчеты</a></p></th>
       </tr>
    </table>
  
  <h1>Расходы за текущий месяц</h1>
  
  
  <table border = "1">
       <tr>
          <th width = "190">Потрачено за месяц</th>
          <th width = "190">Сколько всего денег </th>
          <th width = "190">Доступный остаток </th>
          <th width = "210">С начала учета (<%= exp.getOpeningBalanceDate() %>)</th>
          <th width = "210">Доллары  (курс <%=exp.getCurrency(1) %>)</th>
          <th width = "210">Евро (курс  <%=exp.getCurrency(2) %>)</th>
       </tr>
       <tr>
          <th width = "190"><%= tAmount%></th>
          <th width = "190"><%=restAmount %></th>
          <th width = "190"><%=exp.getRestAmountInRoubles() %></th>
          <th width = "210"> <%= exp.getOpeningBalance() %></th>
          <th width = "210"> <%=exp.getFundAmount(1) %> (<%= exp.getFundAmountRoubles(1) %> руб.)</th>
          <th width = "210"> <%= exp.getFundAmount(2) %> (<%=exp.getFundAmountRoubles(2) %> руб.)</th>
          
       </tr>
    </table>
  
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