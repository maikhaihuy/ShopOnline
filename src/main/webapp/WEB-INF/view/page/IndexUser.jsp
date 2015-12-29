<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
		
		<!-- Start body-->
		<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Danh sách admin</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="user/all">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Danh sách admin </li>
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
				  <th>Tên đăng nhập</th>				 
				</tr>
			  </thead>
			  <tbody>
					<tr>
					  <td>1</td>
					  <td>Admin 1</td>
					</tr>
			  </tbody>
			</table>
		</div>
		
		
		<!-- End body-->