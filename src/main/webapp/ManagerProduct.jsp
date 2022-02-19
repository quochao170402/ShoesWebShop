<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manager Product</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        img {
            width: 200px;
            height: 120px;
        }
    </style>
<body>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Product</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addProductModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New Product</span></a>
                    <a href="#deleteProductModal">
                        <button type="button" class="btn btn-danger"><i
                                class="material-icons">&#xE15C;</i><span>Delete</span></button>
                    </a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                </th>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listProduct}" var="o">
                <tr>
                    <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="${o.id}">
                                        <label for="checkbox1"></label>
                                    </span>
                    </td>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td>
                        <img src="${o.image}">
                    </td>
                    <td>${o.price} $</td>
                    <td>
                        <a href="/shop/manager/product/edit?id=${o.id}" class="edit" data-toggle="modal"><i
                                class="material-icons"
                                data-toggle="tooltip"
                                title="Edit">&#xE254;</i></a>
                        <a href="/shop/manager/product/delete?id=${o.id}" class="delete" data-toggle="modal"><i
                                class="material-icons"
                                data-toggle="tooltip"
                                title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${not empty pageSize}">
            <div class="clearfix">
                <div class="hint-text">Showing <b>${pageSize}</b> out of <b>${listSize}</b> entries</div>
                <ul class="pagination">

                    <c:choose>
                        <c:when test="${numberPage == 1 || index ==1 }">
                            <li class="page-item disabled"><a href="#" class="page-link">Previous</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a href="/shop/manager/product?index=${index - 1}" class="page-link">Previous</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach begin="1" end="${numberPage}" var="i">
                        <li class="page-item ${index == i ? 'active':''}">
                            <a href=/shop/manager/product?index=${i}
                               class="page-link">${i}</a>
                        </li>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${numberPage == 1 || index == numberPage }">
                            <li class="page-item disabled"><a href="#" class="page-link">Previous</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a href="/shop/manager/product?index=${index + 1}" class="page-link">Next</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </c:if>
        <%--        <div class="clearfix">--%>
        <%--            <div class="hint-text">Showing <b>5</b> out of <b>${listSize}</b> entries</div>--%>
        <%--            <ul class="pagination">--%>
        <%--                <li class="page-item ${index==1?'disabled':''}"><a href="/webshop/manager?index=${index-1}">Previous</a>--%>
        <%--                </li>--%>
        <%--                <c:forEach begin="1" end="${numberPage}" var="i">--%>
        <%--                    <li class="page-item ${index == i ? 'active':''}"><a href=/webshop/manager?index=${i}"--%>
        <%--                                                                         class="page-link">${i}</a></li>--%>
        <%--                </c:forEach>--%>
        <%--                &lt;%&ndash;                <li class="page-item"><a href="#" class="page-link">1</a></li>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <li class="page-item"><a href="#" class="page-link">2</a></li>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <li class="page-item active"><a href="#" class="page-link">3</a></li>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <li class="page-item"><a href="#" class="page-link">4</a></li>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <li class="page-item"><a href="#" class="page-link">5</a></li>&ndash;%&gt;--%>
        <%--                <li class="page-item"><a href="#" class="page-link">Next</a></li>--%>
        <%--            </ul>--%>
        <%--        </div>--%>
    </div>
    <a href="/shop/home">
        <button type="button" class="btn btn-primary">Back to home</button>
    </a>
</div>
<!-- Add Modal HTML -->
<div id="addProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/shop/manager/product/add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" required value="${product.name}">
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input name="image" type="text" class="form-control" required value="${product.image}">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" class="form-control" required value="${product.price}">
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <textarea name="title" class="form-control" required value="${product.title}"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control" required
                                  value="${product.description}"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="categoryId" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listCategory}" var="o">
                                <option value="${o.id}">${o.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Delete Modal HTML -->
<div id="deleteProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="delete" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

<script src="js/manager.js" type="text/javascript"></script>
<script>

</script>
</body>
</html>