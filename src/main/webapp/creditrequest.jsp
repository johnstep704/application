<%@page import="johnstep.*" contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.CreditCalculate" id="CreditCalculate" />
<html>
<head>
<title>Result</title>
</head>
<body>
<%



String fAmount = request.getParameter("amount");
String sAmount = fAmount.replace(",", ".");


String sMonths = request.getParameter("months");

String fPercent = request.getParameter("percents");
String sPercent = fPercent.replace(",", ".");

double cAmount = Double.parseDouble(sAmount) ;
int cMonths = Integer.parseInt(sMonths);
double cPercent = Double.parseDouble(sPercent);

CreditCalculate cc = new CreditCalculate(cAmount, cMonths, cPercent);
%>


<p><a href="index.jsp">На главную</a></p>
<hr/>

 <h1>Результат расчета</h1>
 
<p>Сумма кредита = <%= request.getParameter("amount")%> <p/>
<p>Количество месяцев = <%= request.getParameter("months")%> <p/>
<p>Годовой процент = <%= request.getParameter("percents")%> <p/>

<p> <p/>
 

<p><b>Ежемесячный платеж = <%=  cc.getMpaymentDesc() %><b/></p>
<p><b>Переплата = <%=  cc.getOverpaidDesc() %><b/></p>

<hr/>
<p><a href=Credit.jsp>Повторить расчет</a></p>



</body>
</html>