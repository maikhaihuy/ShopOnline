<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
		<div class="content">
        
			<div class="header">           
				<h1 class="page-title">Thông tin đơn hàng</h1>
			</div>
       
            <ul class="breadcrumb">
				<li><a href="user/all">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="order/all">Danh sách đơn hàng</a> <span class="divider">/</span></li>
				<li class="active">Đơn hàng</li>
			</ul>

			<div class="container-fluid">
				<div class="row-fluid">
						
				<div class="btn-toolbar">
				   <label> <strong>Mã đơn hàng:</strong>  1234</label>
				<label><strong>Ngày đặt:</strong> 12/3/2014</label>
				<label><strong>Tình trạng:</strong> Chưa xác nhận</label>
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
						<th class="text-center"><strong>Đơn giá</strong></th>
						<th class="text-center"><strong>Thành tiền</strong></th>
					</tr>
					<tbody>
						<tr>
							<td class="text-center">1</td>
							<td class="text-center">1213</td>
							<td class="text-center">Đỏ</td>
							<td class="text-center">S</td>
							<td class="text-center">2</td>
							<td class="text-center">100000</td>
							<td class="text-center">200000</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td class="text-center"><span style="font-weight:bold">Tổng tiền</span></td>
							<td class="text-center"><span style="font-weight:bold">1000000</span></td>
						</tr>												
					</tbody>
				</table>
			</div>


<!-- End body-->