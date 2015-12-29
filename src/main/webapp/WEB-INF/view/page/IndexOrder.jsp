<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!-- Start body-->
	<div class="content">

    <div class="header">
        <h1 class="page-title">Danh sách đơn hàng</h1>
    </div>

    <ul class="breadcrumb">
        <li>
			<a href="user/all">Trang chủ</a>
			<span class="divider">/</span>
		</li>
        <li class="active">Danh sách đơn hàng</li>
    </ul>
	
    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">              
                <div class="btn-group">
                    <form action="order" method = "get">
                        <label class="menuControl">Số đơn đặt hàng/trang</label>
                        <select class="dropdown" name='numPerPage' onchange='submit()' data-settings='{"wrapperClass":"metro1"}'>
                            <option @(10 == numPerPage ? "selected = 'selected' " : string.Empty) value="10">10</option>
                            <option @(15 == numPerPage ? "selected = 'selected' " : string.Empty) value="15">15</option>
                            <option @(20 == numPerPage ? "selected = 'selected' " : string.Empty) value="20" >20</option>
                        </select>
                        <input type='hidden' name='page' value='1' />
        
                    </form>
                </div>
            </div>
            <div class="well">
               
                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Mã đơn hàng</th>
                                <th>Ngày đặt</th>
                                <th>Khách hàng</th>
                                <th>Tổng tiền</th>
                                <th>Tình trạng</th>
                            </tr>
                        </thead>

                        <tbody>
							<tr>
								<td>1</td>
								<td><a href="order/1">233</a></td>
								<td>12/4/2012</td>
								<td><a href="index.html">Nguyễn Văn A</a></td> 
								<td>100000</td>	
								<td>
									<form action="order" method="get">
										<select class="dropdown" name='status' onchange='submit()' data-settings='{"wrapperClass":"metro1"}'>
											<option @(p.IDOrderStatus == 1 ? "selected = 'selected' " : string.Empty) value="1">Chưa xác nhận</option>
											<option @(p.IDOrderStatus == 2 ? "selected = 'selected' " : string.Empty) value="2">Đã xác nhận</option>
											<option @(p.IDOrderStatus == 3 ? "selected = 'selected' " : string.Empty) value="3">Đang trên đường giao hàng</option>
											<option @(p.IDOrderStatus == 4 ? "selected = 'selected' " : string.Empty) value="4">Đã giao hàng</option>
											<option @(p.IDOrderStatus == 6 ? "selected = 'selected' " : string.Empty) value="6">Hủy bởi admin</option>
										</select>
										<input type='hidden' name='numPerPage' value='@numPerPage' />
										<input type='hidden' name='page' value='@page' />										
										<input type='hidden' name='idOrder' value='@p.ID' />
									</form>
								</td>
                            </tr>                           
                        </tbody>

                    </table>
                
            </div>
            <div class="pagination">
                <ul>
                    @if (page > 1)
                    {
                        <li>
                            <a title="Trang Trước" href="order/page/x-1/productPerPage/10">
                                <
                            </a>
                        </li>
                    }

                    @for (int p = startPage; p <= endPage; p++)
                    {
                        if (p == page)
                        {
                            <li>
                                <a class="active-page">p</a>
                            </li>
                        }
                        else
                        {
                            <li>
								<a title="Trang x" href="order/page/x/productPerPage/10">                               
                                    p
                                </a>
                            </li>
                        }


                    }

                    @if (page <= (numPage - 1))
                    {
                        <li>
                            <a title="Trang Trước" href="order/page/x+1/productPerPage/10">
                                >
                            </a>
                        </li>
                    }
                </ul>
            </div>
            

            <!-- End body-->
