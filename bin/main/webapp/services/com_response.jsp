<%@page import="johnstep.communication.*"  contentType="text/html; charset=UTF-8"%>

<% 

int propId = Integer.parseInt(request.getParameter("prop_id"));	


Communication com = new Communication();
com.initConnect();
Property prop = null;

for(Property p : com.getPropertyList()){
	if(p.getId()==propId){
		prop=p;
	}
}

String testHasData = "Данные не заполнены";

boolean hasData = (
		request.getParameter("serviceType")!= null 
		&& !("0".equals(request.getParameter("serviceType")))
		&& request.getParameter("DescData")!= null
		&& request.getParameter("master")!= null
		&& request.getParameter("priceData")!= null
		&& request.getParameter("updateDate")!= null
		
		);
if(hasData){
	
	CommunicationData commData = new CommunicationData();
	commData.setDescription(request.getParameter("DescData"));
	commData.setComServiceTypeId(Integer.parseInt(request.getParameter("serviceType")));
	commData.setPropertyId(propId);
	commData.setMasterName(request.getParameter("master"));
	commData.setPrice(Double.parseDouble(request.getParameter("priceData")));
	commData.setUpdateDate(request.getParameter("updateDate"));
	
	com.addCommData(commData);
	
	
	testHasData = "Данные заполнены";
}


%>

<html>
<head>
<title>Имущество</title>
</head>
<body>
<p><a href="/application/index.jsp">На главную</a></p>
<p><a href="services.jsp"> Сервисы</a></p>
<hr/>
<p><a href="communication.jsp">Выбрать имущество</a></p>
<h2><%= prop.getDescription()  %></h2>
<p>

<p>

<table border = "1">
<tr>
<th align="left">

<h3>Добавить данные по сервису</h3>
<form action="com_response.jsp" method="GET">
<table border="0">
    <tr>
     <th width="100">Тип</th>
     <th width="300">Описание</th>
     <th width="100">Мастер</th>
     <th width="100">Стоимость</th>
     <th width="100">Дата</th>
    </tr>
    <tr>
     <th align="left"> 
     	<select name="serviceType">
     	  <option value="0"></option>
     	  <%for(ComServiceType serv : com.getComServiceList()){ %>
     	  
     	  <option value=<%= serv.getId() %> > <%= serv.getDescription() %> </option>
     	  
     	  <%} %>
     	</select>
     </th>
     <th><input type="text" name="DescData" size="100" maxlength="1000"  /></th>
     <th><input type="text" name="master"   /></th>
     <th><input type="text" name="priceData"   /></th>
     <th><input type="date" name="updateDate" value = ""  /></th>

    </tr>

</table>

<input type = "hidden" name="prop_id"  value = <%=prop.getId() %> />

<p>

<input type="submit" value="Добавить" /> <input type="reset" value="Сбросить" />
<%= testHasData %>
</form>



</th>
</tr>
</table>


<hr/>

<h2>Данные по сервису</h2>

<table border="1" border-collapse: collapse>
    <tr>
     <th width="30">id</th>
     <th width="100">Тип</th>
     <th width="100">Описание</th>
     <th width="100">Мастер</th>
     <th width="100">Стоимость</th>
     <th width="100">Дата</th>
    </tr>
    
    <%for(CommunicationData cmd : com.getCommunicationList(propId)){ %>
    	
     <tr>
     	<th><%= cmd.getId()  %></th>
     	<th align="left"><%= com.getServiceType(cmd.getComServiceTypeId()) %></th>
     	<th align="left"><%= cmd.getDescription()  %></th>
     	<th align="left"><%= cmd.getMasterName()  %></th>
     	<th align="left"><%= cmd.getPrice()  %></th>
     	<th><%= cmd.getUpdateDateRusString()  %></th>
    </tr>
    <%} %>
    
    
    
</table>

<hr/>
</body>
</html>