<%@page import="johnstep.*"  contentType="text/html; charset=UTF-8"%>
<jsp:useBean class="johnstep.DateCalculate" id="DateCalculate" />
<html>
<head>
<title>Result</title>
</head>
<body>
<%

DateCalculate dc = new DateCalculate();

String s1 = request.getParameter("first_date");
String s2 = request.getParameter("second_date");
String s3 = request.getParameter("filename");

dc.setDate1(s1);
dc.setDate2(s2);

double daysDIff = dc.daysDiff(dc.getDate1(), dc.getDate2());

%>


<p><a href="index.jsp">На главную</a></p>
<hr/>

 <h1>Результат расчета</h1>
 
<p>Первая дата = <%= s1%> <p/>
<p>Вторая дата = <%= s2%> <p/>
<p>Файл = <%= s3%> <p/>

<p>Разница в днях = <%= daysDIff%> <p/>


<hr/>
<p><a href=date.jsp>Повторить расчет</a></p>



</body>
</html>