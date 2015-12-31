<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	

<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Danh sách khuyến mãi</h1>
        </div>
        
                <ul class="breadcrumb">
            <a href="<c:url value='/admin/order/list.do?id=0&page=1&numPerPage=10'/> ">Trang chủ</a>
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
				<c:forEach var="discountItem" items="${listAdDiscount}" varStatus="status">
					<form action="update.do" method = "get">
					<tr>
					  <td>${status.index}</td>
					  <td>${discountItem.product.productName}</td>						
					  <td>
					  <c:set var="n" value="5"/>
						<select class="dropdown" name='productDiscountValue' >
							<c:forEach var="i" begin="0" end="10" >
								<c:set var="m" value="${n*i }"/>
								<option value="${m }" 
									<c:if test="${discountItem.discountInfo.discountPercentValue == m}">
			                             	selected = 'selected' 
			                        </c:if> >
									<c:out value="${m }"/>%
								</option>
							</c:forEach>
													
						</select>
					  </td>	
					  <td>${discountItem.discountProduct.productName}</td>	
					  <td><input type="text" name = "startDate" id="datepickerStart" 
					     value='<fmt:formatDate value="${discountItem.discount.discountStartDate }"  pattern="dd/MM/yyyy  hh:MM:ss"/>' />
					  </td> 
					  <td><input type="text" name = "endDate" id="datepickerEnd" 
					   value='<fmt:formatDate value="${discountItem.discount.discountEndDate }"  pattern="dd/MM/yyyy  hh:MM:ss"/>' />
					 </td>
					  <input type='hidden' name='discountId' value='${discountItem.discount.discountId }' />
					  <input type='hidden' name='discountInfoId' value='${discountItem.discountInfo.discountInfoId }' />
					  <td><button type="submit"  >Cập nhật</button>	</td>					  
					</tr> 
					
					<script>
				  $(function() {
					$( "#datepickerStart" ).datepicker();
				  });
				   $(function() {
					$( "#datepickerEnd" ).datepicker();
				  });
			  </script>
	    
				</form>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		
		
		
		<!-- End body-->