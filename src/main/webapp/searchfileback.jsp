<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>The Cloud we share access</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Rochester" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
     < <style>
 body  {
  background-image: url("img/cloud8.jpg");
  background-color: #cccccc;
  background-size:cover;
} 
</style> 
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<!-- Navigation
    ==========================================-->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
    </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <h1 style="color:#fcf8e3;">The Cloud we Share Access Control on Symmetrically Encrypted Data in Untrusted Clouds</h1></br>
      <ul class="nav navbar-nav">
         <li class="active" align="left"> <a href="index.html">Home</a> </li> 
         <li><a href="upload.jsp">Upload Files</a></li>                                              
          <li><a href="viewfile.jsp"> ViewFiles</a></li>
           <li><a href="searchfile.jsp">Search Files</a></li>
           <li><a href="viewreq.jsp"> Request</a></li>
            <li><a href="viewstatus.jsp"> Status</a></li>
            <li><a href="index.html">Logout</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
</nav>
<!-- Header -->
<header id="header">
  <!-- <div class="intro"> -->
    <div class="overlay">
      <div class="container">
        <div class="row">
          <div class="intro-text">
<% String msg=request.getParameter("msg");
if(msg==null)
{
}
else{
%>
<font style="verdana" color="red"><center><%=msg %></center></font>
<%}
%>
<%
String t1=request.getParameter("t1");
String id=session.getAttribute("id9").toString();
System.out.println("=="+id);
System.out.println("=="+t1);

 /* String email=(String)session.getAttribute("pemail").toString();
System.out.println(email);   */

 int cnt=0;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://database-1.czeaqwkwy2sw.ap-south-1.rds.amazonaws.com/untrustcloud", "admin","vijay123");
    String query = "SELECT * FROM upload WHERE fname=? and uid != ?";			
		PreparedStatement ps = con.prepareStatement("SELECT * FROM upload WHERE fname=? and uid != ?"); 
    ps.setString(1,t1);
    ps.setString(2,id);
		ResultSet rs = ps.executeQuery();
		
%>

	<br>
<br>              


	<center>
	<h2 style="color:red"> View Searched File</h2>
	<table border="1"   style="background-color: #f2dede;">
            	<tr align="center">
            	    <th>Owner Id</th>
            	    <th>File Id</th>
            		<th>File Name</th>
            		<th>Action</th>
            		
            		
	
	</tr>
	<%while(rs.next())
	{
	%>
	<tr > 	
    <td ><%=rs.getString(7)%></td>
    <td ><%=rs.getString(1)%></td>
	<td ><%=rs.getString(2)%></td>
    
    <td ><a href="reqback.jsp?fid=<%=rs.getString(1)%>&oid=<%=rs.getString(7)%> ">Request</a></td>

	 
	</tr>      
	<%} %>
	
	
	<%
		} catch (Exception e) {
			out.println(e);
		}
	%>
</table>
	
	</center>

	
	</div>
	


</body>
</html>