<%@page import="johnstep.communication.*"  contentType="text/html; charset=UTF-8"%>


<%

Communication com = new Communication();
com.initConnect();


%>

<html>
<head>
<title>Коммуникации</title>
</head>
<body>
<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="services.jsp">Сервисы</a></p>
<hr>

<h1>Коммуникациии</h1>





<form action="com_response.jsp" method="GET">

Выберите имущество
<p>
  <table border="1">
    <tr>
     <th width="30"></th>
     <th width="150">Имущество</th>

    </tr>
    
    <% for (Property prop : com.getPropertyList() ){
    	%>
    	<tr>
    		<th><input type="radio" name="prop_id" value= <%=prop.getId() %> ></th>
    		<th align="left"><%= prop.getDescription() %> </th>
    	</tr>
    <%  }%>
   </table>
<p>
<input type="submit" value="Выбрать" /> <input type="reset" value="Сбросить" />  

</form>

<hr>
</body>
</html>