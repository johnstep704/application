<%@page import="johnstep.*" import = "java.util.Calendar" import = "java.util.GregorianCalendar" import = "java.util.*" contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />

<%

Calendar d = new GregorianCalendar();

int cMonths = d.get(Calendar.MONTH)+1;
int cYear = d.get(Calendar.YEAR);

String dsc = request.getParameter("desc");

Pars pars = new Pars();
Expenses exp = new Expenses();

String amtStr = request.getParameter("amount");
String saleAmountStr = request.getParameter("sale_amount");

double amt = Double.parseDouble(amtStr) ;
double saleAmount = Double.parseDouble(saleAmountStr);

double totalAmount = amt * saleAmount;


String curIdStr = request.getParameter("currency_id");
int curr_id = Integer.parseInt(curIdStr);

String curDesc = exp.getCurrencyType(curr_id);


FundData fd = new FundData();
fd.setCurrencyId(curr_id);
fd.setDescription(dsc);
fd.setAmount(amt);
fd.setSalePrice(saleAmount);

exp.addFund(fd);

ExpensesData ed = new ExpensesData();
ed.setDescription(dsc);
ed.setMonthId(cMonths);
ed.setYearId(cYear);
ed.setOperationType(12);
ed.setAmount(totalAmount);

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

 <h1>Копилка пополнена</h1>
 
<p>валюта = <%=curDesc %> <p/>
<p><b>Сумма = <%= amt%> </b> <p/>

<hr/>
<p><a href="expensesinput.jsp">Добавить еще расходы</a></p>

</body>
</html>