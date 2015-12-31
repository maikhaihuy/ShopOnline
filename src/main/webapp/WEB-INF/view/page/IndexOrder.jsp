<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	

<!-- Start body-->
	<div class="content">

    <div class="header">
        <h1 class="page-title">Danh sách đơn hàng</h1>
    </div>

    <ul class="breadcrumb">
        <li>
			<a href="<c:url value="/admin/user/list.do?page=1&numPerPage=10"/> ">Trang chủ</a>
			<span class="divider">/</span>
		</li>
        <li class="active">Danh sách đơn hàng</li>
    </ul>
	
    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">              
                <div class="btn-group">
                    <form action="list.do" method = "get">
                        <label class="menuControl">Số đơn đặt hàng/trang</label>
                        <select class="dropdown" name='numPerPage' onchange='submit()' data-settings='{"wrapperClass":"metro1"}'>
                            <option value="10" 
	                            <c:if test="${numPerPage == 10 }">
	                             	selected = 'selected' 
	                            </c:if> >
	                              10 
                            </option>
                            <option value="15" 
	                            <c:if test="${numPerPage == 15 }">
	                             	selected = 'selected' 
	                            </c:if> >
	                              15 
                            </option>
                            <option value="20" 
	                            <c:if test="${numPerPage == 20 }">
	                             	selected = 'selected' 
	                            </c:if> >
	                              20 
                            </option>
                        </select>
                        <input type='hidden' name='page' value='${page }'/>
        				<input type='hidden' name='id' value='${orderStatusId }' />
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
                                <th>Thành tiền (VNĐ)</th>
                                <th>Phí vận chuyển (VNĐ)</th>
                                <th>Tổng tiền (VNĐ)</th>
                                <th>Tình trạng</th>
                            </tr>
                        </thead>

                        <tbody>
							
								<c:forEach var="orderItem" items="${listAdOrder}" varStatus="status">
								<tr>
								<td>${status.index}</td>
								<td><a href="detail.do?id=${orderItem.order.orderId }">${orderItem.order.orderCode }</a></td>
								<td><fmt:formatDate value="${orderItem.order.orderDate }"  pattern="dd/MM/yyyy  hh:MM:ss"/></td>
								<c:set var="n" value="${orderItem.order.orderTotal }"/>
								<c:set var="m" value="${orderItem.order.orderTransferCost }"/>
								<td><fmt:formatNumber type="number" value="${orderItem.order.orderTotal}" groupingUsed="true"/>
								</td>	
								<td><fmt:formatNumber type="number" value="${orderItem.order.orderTransferCost }" groupingUsed="true"/></td>
								
								<td><fmt:formatNumber type="number" value="${n + m}" groupingUsed="true"/> </td>
								<td>
									<form action="update.do" method="get">
										<select class="dropdown" name='status' onchange='submit()' data-settings='{"wrapperClass":"metro1"}'>
											<c:forEach var="orderStatusItem" items="${listOrderStatus}" >
												<option value="${orderStatusItem.orderStatusId }" 
					                            <c:if test="${orderStatusItem.orderStatusId == orderItem.orderStatusId }">
					                             	selected = 'selected' 
					                            </c:if> >
					                              ${orderStatusItem.orderStatusName }
				                            	</option>
				                            </c:forEach>  
											
										</select>
										<input type='hidden' name='numPerPage' value='${numPerPage}' />
										<input type='hidden' name='page' value='${page }' />																			
										<input type='hidden' name='id' value='${orderStatusId }' />
										<input type='hidden' name='orderId' value='${orderItem.order.orderId }' />
									</form>
								</td>
                            </tr> 
                            </c:forEach>                          
                        </tbody>

                    </table>
                
            </div>
            <div class="pagination">
                <ul>
                    <c:if test="${page > 1}">
					       <li>
                            <a title="Trang Trước" href="list.do?id=${orderStatusId }&page=${page-1 }&numPerPage=${numPerPage }">
                                <
                            </a>
                        </li>                     
					</c:if> 
                   
					<c:forEach var="p" begin="1" end="${numPage+1 }" >                
                        <c:if test="${page == p}">
                        	<li>
                                <a class="active-page">${p }</a>
                           </li>
                        </c:if> 
                     	<c:if test="${page != p}">
                     		 <li>
								<a title="Trang ${p }" href="list.do?id=${orderStatusId }&page=${p }&numPerPage=${numPerPage }">                               
                                    ${p }
                                </a>
                            </li>
                     	</c:if> 
                    </c:forEach>  

					 <c:if test="${(numPage -1) >= page}">
					       <li>
                            <a title="Trang sau" href="list.do?id=${orderStatusId }&page=${page + 1 }&numPerPage=${numPerPage }">
                                >
                            </a>
                        </li>                     
					</c:if> 
					
                </ul>
            </div>
            

            <!-- End body-->
