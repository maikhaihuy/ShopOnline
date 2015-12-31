<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	

<!-- Start body-->
		<div class="content">
        
			<div class="header">           
				<h1 class="page-title">Thông tin đơn hàng</h1>
			</div>
       
            <ul class="breadcrumb">
				<li><a href="<c:url value="/admin/user/list.do?page=1&numPerPage=10"/> ">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="<c:url value="/admin/order/list.do?id=0&page=1&numPerPage=10"/> ">Danh sách đơn hàng</a> <span class="divider">/</span></li>
				<li class="active">Đơn hàng</li>
			</ul>

			<div class="container-fluid">
				<div class="row-fluid">
						
				<div class="btn-toolbar">
				   <label> <strong>Mã đơn hàng:</strong> ${adOrder.order.orderCode }</label>
				<label><strong>Ngày đặt:</strong> <fmt:formatDate value="${adOrder.order.orderDate }"  pattern="dd/MM/yyyy  hh:MM:ss"/></label>
				<label><strong>Tình trạng:</strong> ${adOrder.orderStatusName }</label>
				<div class="btn-group"></div>
			</div>

			<div class="well">
				<table class="table" >
					<tr>
						<th><strong>#</strong></th>
						<th class="text-center"><strong>Tên sản phẩm</strong></th>
						<th class="text-center"><strong>Màu Sắc</strong></th>
						<th class="text-center"><strong>Size</strong></th>
						<th class="text-center"><strong>Số Lượng</strong></th>
						<th class="text-center"><strong>Đơn giá (VNĐ/1 sản phẩm)</strong></th>
						<th class="text-center"><strong>Thuế (VNĐ)</strong></th>
						<th class="text-center"><strong>Thành tiền(VNĐ)</strong></th>
					</tr>
					<tbody>
						<c:set var="total" value="0"/>
						<c:forEach var="detailOrderItem" items="${listAdDetailOrder}" varStatus="status">
						<tr>
							<td>${status.index}</td>
							<td class="text-center">${detailOrderItem.productName }</td>
							<td class="text-center">${detailOrderItem.colorName }</td>
							<td class="text-center">${detailOrderItem.sizeName }</td>
							<td class="text-center">${detailOrderItem.detailOrderQuantity }</td>
							<td class="text-center"><fmt:formatNumber type="number" value="${detailOrderItem.detailOrderPrice }" groupingUsed="true"/></td>
							<td class="text-center"><fmt:formatNumber type="number" value="${detailOrderItem.tax }" groupingUsed="true"/></td>
							<td class="text-center"><fmt:formatNumber type="number" value="${detailOrderItem.sum }" groupingUsed="true"/></td>
							<c:set var="total" value="${total+detailOrderItem.sum }"/>
						</tr>
						</c:forEach>   
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td class="text-center"><span style="font-weight:bold">Tổng tiền (VNĐ)</span></td>
							<td class="text-center"><span style="font-weight:bold"><fmt:formatNumber type="number" value="${total}" groupingUsed="true"/></span></td>
						</tr>	
																	
					</tbody>
				</table>
			</div>


<!-- End body-->