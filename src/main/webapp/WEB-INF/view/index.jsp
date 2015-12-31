<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <title>JDI Shoe Store Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/stylesheets/theme.css" /> ">
    <link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.css"/> ">
	
    <script src="<c:url value="/resources/lib/bootstrap/js/jquery-1.10.2.js"/> "></script>
    <script src="<c:url value="/resources/lib/bootstrap/js/jquery-ui.js"/> "> </script>
    <link rel="stylesheet" href="<c:url value="/resources/resources/lib/bootstrap/js/jquery-ui.css"/> ">
	

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">Just Do It</span> <span class="second">Shoes</span></a>
        </div>
    </div>
    


    

    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">Đăng nhập</p>
            <div class="block-body">
            	<form:form method="post" action="login.do" mmodelAttribute="command" >	
                	<label>Tên đăng nhập</label>
                    <form:input class="span12" path="userName"/>
                    <form:errors cssStyle="color:red" path="userName"></form:errors>
                    <label>Mật khẩu</label>
                    <form:password class="span12" path="userPassword"/>
                    <form:errors cssStyle="color:red" path="userPassword"></form:errors>
                    <input type="submit" class="btn btn-primary pull-right" value="Đăng nhập">
                    <label class="remember-me"><input type="checkbox"> Ghi nhớ</label>
                    <div class="clearfix"></div>
                </form:form>
            </div>
        </div>
        
        <p><a href="reset-password.html">Quên mật khẩu?</a></p>
    </div>
</div>


    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


