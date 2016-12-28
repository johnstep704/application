<%@page import="johnstep.vehicle.*"  contentType="text/html; charset=UTF-8"%>

<% 

int vehicleId = Integer.parseInt(request.getParameter("veh_id"));	


VehicleDesc vd = null;
Vehicle veh = new Vehicle();

for(VehicleDesc v : veh.getVdList()){
	if(v.getId()==vehicleId){
		vd=v;
	}
}

String testHasData = "Данные не заполнены";

boolean hasData = (
		request.getParameter("serviceType")!= null 
		&& !("0".equals(request.getParameter("serviceType")))
		&& request.getParameter("DescData")!= null
		&& request.getParameter("mileAgeData")!= null
		&& request.getParameter("priceData")!= null
		&& request.getParameter("updateDate")!= null
		
		);
if(hasData){
	
	VehicleData vehicleData = new VehicleData();
	vehicleData.setDescription(request.getParameter("DescData"));
	vehicleData.setVehicleServiceTypeId(Integer.parseInt(request.getParameter("serviceType")));
	vehicleData.setVehicleId(vehicleId);
	vehicleData.setMileage(Integer.parseInt(request.getParameter("mileAgeData")));
	vehicleData.setPrice(Double.parseDouble(request.getParameter("priceData")));
	vehicleData.setUpdateDate(request.getParameter("updateDate"));
	
	veh.addVehicleData(vehicleData);
	
	
	testHasData = "Данные заполнены";
}


%>

<html>
<head>
<title>Транспортные средства</title>
</head>
<body>
<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="services.jsp"> Сервисы</a></p>
<hr/>
<p><a href="vehicles.jsp">Выбрать ТС</a></p>
<h2>Транспортные средство</h2>
<p>
<table border="1">
    <tr>
     <th width="100">ТС</th>
     <th width="100">Номер ТС</th>
     <th width="100">VIN</th>
     <th width="100">СТС</th>
    </tr>
    <tr>
     <th><%= vd.getDescription()  %></th>
     <th><%= vd.getLicensePlate()  %></th>
     <th><%= vd.getVinNr()  %></th>
     <th><%= vd.getStsNr()  %></th>
    </tr>
</table>

<p>

<h3>Добавить данные по сервису</h3>
<form action="vehicle_response.jsp" method="GET">
<table border="0">
    <tr>
     <th width="100">Тип</th>
     <th width="100">Описание</th>
     <th width="100">Пробег</th>
     <th width="100">Стоимость</th>
     <th width="100">Дата</th>
    </tr>
    <tr>
     <th align="left"> 
     	<select name="serviceType">
     	  <option value="0"></option>
     	  <option value="1">Страховка</option>
     	  <option value="2">Сервис</option>
     	  <option value="3">Запчасти</option>
     	</select>
     </th>
     <th><input type="text" name="DescData"   /></th>
     <th><input type="text" name="mileAgeData"   /></th>
     <th><input type="text" name="priceData"   /></th>
     <th><input type="date" name="updateDate" value = ""  /></th>

    </tr>

</table>

<input type = "hidden" name="veh_id"  value = <%=vd.getId() %> />

<p>

<input type="submit" value="Добавить" /> <input type="reset" value="Сбросить" />
<%= testHasData %>
</form>

<hr/>

<h2>Данные по сервису</h2>

<table border="1" border-collapse: collapse>
    <tr>
     <th width="30">id</th>
     <th width="100">Тип</th>
     <th width="100">Описание</th>
     <th width="100">Пробег</th>
     <th width="100">Стоимость</th>
     <th width="100">Дата</th>
    </tr>
    
    <%for(VehicleData vehicleData : veh.getDataByVehicleId(vehicleId)){ %>
    	
     <tr>
     	<th><%= vehicleData.getId()  %></th>
     	<th align="left"><%= veh.getVehicleServiceType(vehicleData.getVehicleServiceTypeId())  %></th>
     	<th align="left"><%= vehicleData.getDescription()  %></th>
     	<th align="left"><%= vehicleData.getMileage()  %></th>
     	<th align="left"><%= vehicleData.getPrice()  %></th>
     	<th><%= vehicleData.getUpdateDateRusString()  %></th>
    </tr>
    <%} %>
    
    
    
</table>

<hr/>
</body>
</html>