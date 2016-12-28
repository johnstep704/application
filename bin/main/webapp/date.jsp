<%@page import="johnstep.*" contentType="text/html; charset=UTF-8"%>
<html>
<head><title>Credit Calculator</title></head>
<body>

<p><a href="index.jsp">На главную</a></p>
<hr/>

 <h1>Разница между датами в днях</h1>

   <form action="daterequest.jsp" method="GET">
    <p>Первая дата: <input type="date" name="first_date" /><p/>
    <p>Вторая дата: <input type="date" name="second_date" /> <p/>
    <p>Файл: <input type="file" name="filename" /> <p/>
    <p><input type="submit" value="Рассчитать" /> <input type="reset" value="Сбросить" /><p/>
     
   </form>
<hr/>
</body>
</html>