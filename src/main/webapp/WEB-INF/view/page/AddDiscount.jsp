<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Thêm khuyến mãi</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="<c:url value="/admin/order/list.do?id=0&page=1&numPerPage=10"/> ">Trang chủ</a> <span class="divider">/</span></li>
            <li><a href="<c:url value="/admin/discount/list.do"/>">Danh sách khuyến mãi </a><span class="divider">/</span></li>
			<li  class="active">Thêm khuyến mãi</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">	
			
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
				<form action="add.do" method = "get">
					<tr>
					  <td>1</td>
					  <td>
						<select class="dropdown" name='productId' >
							<c:forEach var="productItem" items="${listProduct}" >
							<option value="${productItem.productId }">${productItem.productName }</option>							
							</c:forEach>
																	
						</select>
					  </td>
					  <td>
					  	<c:set var="n" value="5"/>
						<select class="dropdown" name='productDiscountValue' >
							
							<c:forEach var="i" begin="0" end="10" >
								<c:set var="m" value="${n*i }"/>
								<option value="${m }" >
									<c:out value="${m }"/>%
								</option>
							</c:forEach>
																									
						</select>
					  </td>	
					  <td><select class="dropdown" name='productDiscountId' >
					  		<option value="0">--</option>
							<c:forEach var="productItem" items="${listProduct}" >
							<option value="${productItem.productId }">${productItem.productName }</option>							
							</c:forEach>											
						</select>
					</td>	
					  <td><input type="text" name = "startDate" id="datepickerStart"></td> 
					  <td><input type="text" name = "endDate" id="datepickerEnd"></td>	
					  <td>
					  	<button type="submit" class="btn btn-primary" id="submit" disabled="true"><i class="icon-plus"></i>Thêm mới</button>
					  </td>				  
					</tr>   
				</form>
			  </tbody>
			</table>
		</div>
		
		<script>
		
		   $(function() {
		    $('#submit').prop('disabled',true);
		  });	

		   var startDate = "";
           var endDate = "";
           $("#datepickerStart").datepicker( {
        	   dateFormat: 'dd/mm/yy ',
               onSelect: function(dateText, inst) { 
            	 
                  startDate = dateText;
                  if(endDate != "" && startDate != "" && endDate > startDate){               	
              		  $('#submit').prop('disabled',false);
	                } else{
	                	$('#submit').prop('disabled',true);
	                }
                	 
               }
           });
           $("#datepickerEnd").datepicker({
        	   dateFormat: 'dd/mm/yy',
               onSelect: function(dateText, inst) {            	  
                  endDate = dateText;
                  if(endDate != "" && startDate != "" && endDate > startDate){               	
              		  $('#submit').prop('disabled',false);
	                } else{
	                	$('#submit').prop('disabled',true);
	                }
               }
           });

         
		</script>
		
		<!-- End body-->