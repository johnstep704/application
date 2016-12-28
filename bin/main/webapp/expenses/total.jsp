<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar"  contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="ttl" dataSource="jdbc/TestDB">
select * from t_months 
</sql:query>

<%

String sYear = request.getParameter("year");



Calendar d = new GregorianCalendar();
int month = 1;
int year = Integer.parseInt(sYear);
String dsc = request.getParameter("desc");

Expenses exp = new Expenses();
exp.setExpTypes();

%>

<html>
<head>
<title>Result</title>
</head>
<body>

<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="expenses.jsp">Расходы</a></p>
<p><a href="reports.jsp">Отчеты</a></p>
<hr/>

 <h1>Ежемесячные расходы за <%=year %> год</h1>
 
  <table border="1">
  <tr>
 	     <th width="100"> </th>
 <%
 for(ExpensesType et : exp.getExpensesTypes()){
	 %>
	         <th width="100" ><%=et.getDescription() %></th>
	 
<% }%>	
  <th width="100">Total per month </th> 
  </tr>
   
      <c:forEach var="tt" items="${ttl.rows}">
        <tr>
            <th>${tt.description}</th> 
            <%
            for(ExpensesType et : exp.getExpensesTypes()){ 
            %>
               <th><%=exp.getAmountByType(et.getId(), month, year) %></th>
               
            <%} %>
            <th bgcolor="#cde3b8"><%=exp.getTotal(month, year) %></th>
        </tr>
        <%month=month+1; %>

      </c:forEach>
        <tr>
          <th>Total per year</th>
              <%
            for(ExpensesType et : exp.getExpensesTypes()){ 
            %>
               <th bgcolor="#cde3b8"><%=exp.getYearlyAmountByType(et.getId(), year) %></th>
               
            <%} %>
            <th bgcolor="#cde3b8"> <%=exp.getTotalPerYear(year) %></th>
        </tr>

	   </table>
 

 
<hr/>

</body>
</html>