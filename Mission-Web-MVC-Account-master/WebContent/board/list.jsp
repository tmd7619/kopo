<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>게시판 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css"/>
<style>
	#title h2{
		color: #252525;
	    font-weight: 1000;
	    text-align: center;
	    margin-top : 100px;
	    font-family: "Muli", sans-serif;
	}
	
	
	.p_name{
		
		text-align: center;
		font-weight: 1000;
	}
	
	#title{
	
		color : black
	
	}
	#board, #pageForm, #searchForm{
            text-align :center;
            
    }

	section {
		text-align :center;
	}
	
</style>

<script type="text/javascript">

        function writeForm(){
            location.href=   "/board/writeForm.do";
        }
        
        
</script>


</head>

<body>
    <!-- Header Section Begin -->
    <header>
        <jsp:include page="/include/topMenu.jsp"></jsp:include>
    </header>
    <!-- Header End -->

    <!-- Breadcrumb Section Begin -->
    
    <div class="contact-title" id="title">
			<h2>게시글 목록</h2>
	</div>
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th >번호</th>
                                    <th >제목</th>
                                    <th >글쓴이</th>
                                    <th>등록일</th>
                                </tr>
                            </thead>
                            <tbody>
                                   	<c:forEach items="${list }" var="board"  varStatus="loop" >
	                                <tr>
	                                    <td class="p-price first-row">
	                                        <h5><c:out value="${board.no}"/></h5>
	                                    </td>
	                                    <td align="left" style="padding-left: 50px">
						                    <c:if test="${board.board_re_lev > 1}">
						                        <c:forEach begin="1" end="${board.board_re_lev}">
						                            &nbsp;&nbsp; <!-- 답변글일경우 글 제목 앞에 공백을 준다. -->
						                        </c:forEach>
						                        RE : 
						                    </c:if>
						                  <a href="<%= request.getContextPath()%>/board/detail.do?no=${board.no }" id="title"> 
	                                        <c:out value="${board.title }"  /> </a>
						                </td>
	                                    <td class="p-price first-row">
	                                    	<h5><c:out value="${board.writer }" /></h5>
	                                    </td>
	                                    <td class="p-price first-row">
	                                    	<h5><c:out value="${board.regDate }" /></h5>
	                                    </td>
	                                </tr>
	                         		</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
		        <c:if test="${userVO.id !=null}">
		            <input type="button" value="글쓰기" onclick="writeForm()" id="writeBtn">
		        </c:if> 
		        <br>
        <!-- 페이지 넘버 부분 -->
    		<br>
		    <div id="pageForm">
		        <c:if test="${startPage != 1}">
		            <a href='<%=request.getContextPath() %>/board/list.do?page=${startPage-1}'>[ 이전 ]</a>
		        </c:if>
		        
		        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
		            <c:if test="${pageNum == spage}">
		                ${pageNum}&nbsp;
		            </c:if>
		            <c:if test="${pageNum != spage}">
		                <a href='<%=request.getContextPath() %>/board/list.do?page=${pageNum}'>${pageNum}&nbsp;</a>
		            </c:if>
		        </c:forEach>
		        
		        <c:if test="${endPage != maxPage }">
		            <a href='<%=request.getContextPath() %>/borad/list.do?page=${endPage+1 }'>[다음]</a>
		        </c:if>
		    </div>
			 <!-- 페이지 넘버 부분 -->
    </section>
    <!-- Shopping Cart Section End -->


    <!-- Footer Section Begin -->
    <footer>
    	<jsp:include page="/include/bottom.jsp"></jsp:include>
    </footer>
    <!-- Footer Section End -->

</body>

</html>




