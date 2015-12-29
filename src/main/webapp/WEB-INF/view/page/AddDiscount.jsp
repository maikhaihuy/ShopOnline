<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Thêm khuyến mãi</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="user/all">Trang chủ</a> <span class="divider">/</span></li>
            <li><a href="discount.all">Danh sách khuyến mãi </a><span class="divider">/</span></li>
			<li  class="active">Thêm khuyến mãi</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">	
			<button form="myform" type="submit" class="btn btn-primary" ><i class="icon-plus"></i> Thêm mới</button>
			<div class="btn-group">
			</div>
		</div>
		<div class="well">
			<table class="table" >
			  <thead>
				<tr>
				  <th style="width: 10px;">#</th>
				  <th>Tên sản phẩm</th>
				  <th>Khuyến mãi (%) </th> 
				  <th>Sản phẩm khuyến mãi</th>	
				  <th>Bắt đầu</th> 
				  <th>Kết thúc</th>					 
				</tr>
			  </thead>
			  <tbody>
				<form id="myform" action="order" method="get">
					<tr>
					  <td>1</td>
					  <td>
						<select class="dropdown" name='productId' >
							<option value="1">Sản phẩm 1</option>
							<option value="2">Sản phẩm 2</option>											
						</select>
					  </td>
					  <td>
						<select class="dropdown" name='productDiscountValue' >
							<option value="1">10%</option>
							<option value="2">20%</option>											
						</select>
					  </td>	
					  <td><select class="dropdown" name='productDiscountId' >
							<option value="1">Sản phẩm 1</option>
							<option value="2">Sản phẩm 2</option>											
						</select>
					</td>	
					  <td><input type="text" name = "startDate" id="datepickerStart"></td> 
					  <td><input type="text" name = "endDate" id="datepickerEnd"></td>					  
					</tr>   
				</form>
			  </tbody>
			</table>
		</div>
		
		<script>
		  $(function() {
			$( "#datepickerStart" ).datepicker();
		  });
		   $(function() {
			$( "#datepickerEnd" ).datepicker();
		  });
	  </script>
		
		<!-- End body-->