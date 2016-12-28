<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar" import = "java.util.*" contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />

<%

Calendar d = new GregorianCalendar();

String sMonth = request.getParameter("month");
String sYear = request.getParameter("year");


int cMonths = Integer.parseInt(sMonth);
int cYear = Integer.parseInt(sYear) ;
int cOperType = Integer.parseInt(request.getParameter("oper_type"));
String dsc = request.getParameter("desc");

Pars pars = new Pars();
String amtStr = request.getParameter("amount");
Double amt = pars.getResultStr(amtStr);

Expenses exp = new Expenses();

ExpensesData ed = new ExpensesData();
ed.setDescription(dsc);
ed.setMonthId(cMonths);
ed.setYearId(cYear);
ed.setOperationType(cOperType);
ed.setAmount(amt);

exp.addExpensesData(ed);


%>



<html>
<head>
<title>Result</title>
</head>
<body>

<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="expenses.jsp">Расходы</a></p>
<hr/>

 <h1>Добавлена запись</h1>
 
<p>Тип расходов = <%= request.getParameter("oper_type")%> <p/>
<p><b>Сумма = <%= amt%> </b> <p/>

<hr/>
<p><a href="expensesinput.jsp">Добавить еще расходы</a></p>

</body>
</html>