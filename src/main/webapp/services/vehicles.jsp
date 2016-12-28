<%@page import="johnstep.vehicle.*"  contentType="text/html; charset=UTF-8"%>


<%

Vehicle veh = new Vehicle();


%>

<html>
<head>
<title>Транспортные средства</title>
</head>
<body>
<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="services.jsp">Сервисы</a></p>
<hr>

<h1>Транспортные средства</h1>





<form action="vehicle_response.jsp" method="GET">

Выберите ТС
<p>
  <table border="1">
    <tr>
     <th width="30"></th>
     <th width="100">ТС</th>
     <th width="100">Номер ТС</th>
     <th width="100">VIN</th>
     <th width="100">СТС</th>
    </tr>
    
    <% for (VehicleDesc vd : veh.getVdList() ){
    	%>
    	 <tr>
    	<th><input type="radio" name="veh_id" value= <%=vd.getId() %> ></th>
    	<th><%= vd.getDescription() %> </th>
    	<th><%= vd.getLicensePlate() %> </th>
    	<th><%= vd.getVinNr() %> </th>
    	<th><%= vd.getStsNr() %> </th>
    	</tr>
    <%  }%>
   </table>
<p>
<input type="submit" value="Выбрать" /> <input type="reset" value="Сбросить" />  

</form>

<hr>
</body>
</html>