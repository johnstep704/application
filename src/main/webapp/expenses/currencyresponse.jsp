<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar" import = "java.util.*" contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

String dsc = request.getParameter("desc");

Pars pars = new Pars();
Expenses exp = new Expenses();

String dollarStr = request.getParameter("dollar");
String euroStr = request.getParameter("euro");

double dollar = Double.parseDouble(dollarStr) ;
double euro = Double.parseDouble(euroStr);

exp.setCurrency(1, dollar);
exp.setCurrency(2, euro);

%>


<html>
<head>
<title>Result</title>
</head>
<body>

<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="expenses.jsp">Расходы</a></p>
<hr/>

 <h1>Курс валют изменен</h1>
 
<p>Доллар = <%=dollar %> <p/>
<p><b>Евро = <%= euro%> </b> <p/>

<hr/>

</body>
</html>