<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	<!-- Datepicked -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

   
    <!-- Demo page code -->
    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

            .brand .first {
                color: #ccc;
                font-style: italic;
            }

            .brand .second {
                color: #fff;
                font-weight: bold;
            }
    </style>
   
</head>

<body class="">

    <div class="navbar">
        <div class="navbar-inner">
            <ul class="nav pull-right">
				<!-- Login/ log out-->
                <li id="fat-menu" class="dropdown">
                    <a href="account" role="button" onclick="ShowHideLogOut(this)">
                        <i class="icon-user"></i> @User.Identity.GetUserName()
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul id="account" class="dropdown-menu">
                        <li><a tabindex="-1" href="#">My Account</a></li>
                        <li class="divider"></li>
                        <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                        <li class="divider visible-phone"></li>
                        <li><a href="<c:url value="/admin/user/logout.do" /> ">Đăng xuất</a></li>
                    </ul>
                </li>
				<!-- End Login/ log out-->
            </ul>
            <a class="brand"><span class="first">Just Do It</span> <span class="second">Shoe Store</span></a>
        </div>
    </div>



    <div class="sidebar-nav">
        <a link="account-menu" class="nav-header " onclick="ShowHide(this)"><i class="icon-user"></i>Thành Viên<span class="label label-info"></span></a>
		<!-- User -->
        <ul id="account-menu" class="nav nav-list collapse">            
            <li><a href="<c:url value="/admin/user/list.do?page=1&numPerPage=10" />"> Danh sách admin</a></li>
            <li><a href="<c:url value="/admin/user/add.do" />"> Thêm admin</a></li>
        </ul>
		
		<!-- Discount -->
        <a link="category-menu" class="nav-header " onclick="ShowHide(this)"><i class="icon-gift"></i>Khuyến mãi<i class="icon-chevron-up"></i></a>
        <ul id="category-menu" class="nav nav-list collapse">
            <li><a href="<c:url value="/admin/discount/list.do?page=1&numPerPage=10" />"> Danh sách khuyến mãi</a></li>
            <li><a href="<c:url value="/admin/discount/add.do" />"> Thêm khuyến mãi</a></li>
        </ul>
		<!--
        <a link="product-menu" class="nav-header " onclick="ShowHide(this)"><i class="icon-gift"></i>Sản phẩm<i class="icon-chevron-up"></i></a>
        <ul id="product-menu" class="nav nav-list collapse">
            <li>@Html.ActionLink("Danh sách sản phẩm", "Index", "Product")</li>
            <li>@Html.ActionLink("Thêm sản phẩm", "Add", "Product")</li>
        </ul>
		
		-->

		<!-- Order -->
        <a link="order-menu" class="nav-header " onclick="ShowHide(this)"><i class="icon-list-alt"></i>Đơn hàng<i class="icon-chevron-up"></i></a>
        <ul id="order-menu" class="nav nav-list collapse">
            <li><a href="<c:url value="/admin/order/list.do?id=0&page=1&numPerPage=10" />"> Danh sách đơn hàng </a></li>          
            <li>
                <a href="<c:url value="/admin/order/list.do?id=1&page=1&numPerPage=10" />">
                    Đơn hàng chưa xác nhận
                </a>
            </li>
            <li>
                 <a href="<c:url value="/admin/order/list.do?id=2&page=1&numPerPage=10" />">
                    Đơn hàng đã xác nhận
                </a>
            </li>
            <li>
                 <a href="<c:url value="/admin/order/list.do?id=4&page=1&numPerPage=10" />">
                    Đơn hàng đã giao
                </a>
            </li>
            
        </ul>

		<!--
        <a link="sales-menu" class="nav-header " onclick="ShowHide(this)"><i class="icon-list-alt"></i>Thống kê<i class="icon-chevron-up"></i></a>
        <ul id="sales-menu" class="nav nav-list collapse">
            <li>@Html.ActionLink("Doanh số bán hàng", "StatisticsGeneral", "Statistics")</li>
            <li>@Html.ActionLink("Top 10 sản phẩm", "StatisticsGeneral", "Statistics")</li>
            <li>@Html.ActionLink("Top 10 loại sản phẩm", "StatisticsGeneral", "Statistics")</li>
        </ul>
		
		-->

        
    </div>

