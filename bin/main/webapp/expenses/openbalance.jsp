<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar" import = "java.util.*" contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />

<%



Pars pars = new Pars();
String amtStr = request.getParameter("vOpen");
Double amt = pars.getResultStr(amtStr);

Expenses exp = new Expenses();
exp.setOpeningBalance(amt);

%>

<html>
<head>
<title>Result</title>
</head>
<body>

<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="expenses.jsp">Расходы</a></p>
<hr/>

 <h1>Остаток на начало записан</h1>
 
<p><b>Сумма = <%= exp.getOpeningBalance() %> </b> <p/>
<hr/>

</body>
</html>