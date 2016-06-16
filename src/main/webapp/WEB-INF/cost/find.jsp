<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee() {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function del(b) {
                var r = window.confirm("确定要删除此资费吗？");
                if(r){
                	location.href="deleteCost.do?id="+ b;
                	console.log(b);
                }
            }
        </script>        
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="images/logo.png" alt="logo" class="left"/>
            <c:import url="../info.jsp"></c:import>         
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <c:import url="../nav.jsp"></c:import>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />-->
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.do';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>                      
 						<c:forEach items="${cost }" var="item" varStatus="s">
 							<tr>
 								<td>${item.costID }</td>
 								<td>${item.name }</td>
 								<td>${item.baseDuration }</td>
 								<td>${item.baseCost }</td>
 								<td>${item.unitCost }</td>
 								<td><fmt:formatDate value="${item.creatime }" pattern="yyyy-MM-dd HH:mm:dd" /></td>
 								<td><fmt:formatDate value="${item.startime }" pattern="yyyy-MM-dd HH:mm:dd" /></td>
 								<td>
 									<c:if test="${item.status == 0 }">开通</c:if>
 									<c:if test="${item.status == 1 }">暂停</c:if>
 								</td>
 							
 	                       		 <td>                                
                               	 	<input type="button" value="启用" class="btn_start" onclick="startFee();" />
                                	<input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.do?id=${item.costID}';" />
                                	<input type="button" value="删除" class="btn_delete" onclick="del('${item.costID}');"  />
                            	</td>
                            </tr>
 						</c:forEach>
 						
 						
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                	<!-- 防止错误判断页数
                		在第一页时，则不能往上
                		在最后一页时，则不能往下
                	 -->
                	<c:if test="${page.nowPage > 1 }">
                		<a href="find.do?page=${page.nowPage - 1 }">上一页</a>
                	</c:if>
                		<!-- begin 循环起始
                			end 循环结束
                			var 每次循环的对象
                		 -->
                		  
                		<c:forEach begin="1" end="${page.page }" var="i">
							<!-- 单i = 当前页时 显示高亮 -->                		
                			<c:if test="${i== page.nowPage }">
                				<a href="find.do?page=${i }" class = "current_page">${i }</a>
                			</c:if>
                			<c:if test="${i != page.nowPage }">
                				<!-- 向服务器传递请求的页数 -->
                				<a href="find.do?page=${i }">${i }</a>       
                			</c:if>
                		</c:forEach>
                	<c:if test="${page.nowPage < page.page }">	
                		<a href="find.do?page=${page.nowPage + 1 }">下一页</a>
                	</c:if>	
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
