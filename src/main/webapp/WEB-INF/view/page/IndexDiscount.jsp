<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Danh sách khuyến mãi</h1>
        </div>
        
                <ul class="breadcrumb">
            <a href="<c:url value="/admin/order/list.do?id=0&page=1&numPerPage=10"/> ">Trang chủ</a>
            <span class="divider">/</span>
			<li  class="active">Danh sách khuyến mãi</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">	
			<form action="viewAdd.do">
				<button type="submit" class="btn btn-primary" ><i class="icon-plus"></i> Thêm mới</button>			
			</form>
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
				  <th></th>				 
				</tr>
			  </thead>
			  <tbody>
				<form id="myform" action="update.do" method="get">
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
					  <input type='hidden' name='discontId' value='1' />
					  <input type='hidden' name='discontInfoId' value='1' />
					  <td><button type="submit"  >Cập nhật</button>	</td>					  
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