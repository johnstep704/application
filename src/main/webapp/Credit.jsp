<%@page import="johnstep.*" contentType="text/html; charset=UTF-8"%>
<html>
<head><title>Credit Calculator</title></head>
<body>

<p><a href="index.jsp">На главную</a></p>
<hr/>

 <h1>Кредитный калькулятор</h1>

   <form action="creditrequest.jsp" method="GET">
    <p> Сумма кредита: <input type="text" name="amount" value = "700000" /><p/>
    <p>Количество месяцев: <input type="text" name="months" value = "36" /> <p/>
    <p>Проценты: <input type="text" name="percents" value = "19.9" />  <p/>
    <p><input type="submit" value="Рассчитать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
<hr/>
</body>
</html>