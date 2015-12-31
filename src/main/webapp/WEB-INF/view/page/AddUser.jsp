<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Thêm admin</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="<c:url value="/admin/order/list.do?id=0&page=1&numPerPage=10"/> ">Trang chủ</a><span class="divider">/</span></li>
            <li><a href="<c:url value="/admin/user/list.do"/> ">Danh sách admin </a><span class="divider">/</span></li>
			<li  class="active">Thêm admin</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">	
			
			<div class="btn-group">
			</div>
		</div>
		<div class="well">
			<table class="table" >
			  <thead>
				<tr>
				  <th style="width: 10px;">#</th>
				  <th>Tên đăng nhập</th>
				  <th>Email</th>
				  <th></th>
				</tr>
			  </thead>
			  <tbody>
				<form id="myform" action="create.do" method="get">
					<tr>
					  <td>1</td>
					  <td>
						<input type="text" name="username" value="">
					  </td>
					  <td>
						<input type="text" name="email" value="">
					  </td>
					  <td>
					  	<button type="submit" class="btn btn-primary" ><i class="icon-plus"></i> Cập nhật</button>
					  </td>
					 </tr>
				</form>
			  </tbody>
			</table>
		</div>
		
		
		<!-- End body-->