<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Shoes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:choose>
                    <c:when test="${not empty sessionScope.account}">
                        <%--javax.el.PropertyNotFoundException: Property [isSeller] not found on type [com.webshop.entity.Account]--%>
                        <%--Lỗi này do thuộc tính không có getter và setter rõ ràng--%>
                        <c:if test="${sessionScope.account.isAdmin == 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="/shop/manager/account">Manager Account</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.account.isSeller == 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="/shop/manager/product">Manager Product</a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <a class="nav-link" href="/shop/account">Hello ${sessionScope.account.username}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <%--                    ${txtS}--%>
                    <input value="${key}" name="key" type="text" class="form-control" aria-label="Small"
                           aria-describedby="inputGroup-sizing-sm" placeholder="Search..." required>
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="/shop/cart">
                    <i class="fa fa-shopping-cart"></i> Cart
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ
            Trung Quốc</p>
    </div>
</section>
<!--end of menu-->
