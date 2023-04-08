<%@ include file="commen/header.jspf" %>
<%@ include file="commen/navigation.jspf" %>
        <div class="container">
            <h1>Your Todos</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Data</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <th>${todo.description}</th>
                        <th>${todo.targetDate}</th>
                        <th>${todo.done}</th>
                        <th><a href="delete-page?id=${todo.id}" class="btn btn-danger">Delete</a></th>
                        <th><a href="update-page?id=${todo.id}" class="btn btn-success">Update</a></th>
                    </tr>
                </c:forEach>
            </table>
            <a href="add-todo" class="btn btn-success">Add New</a>
        </div>
<%@ include file="commen/footer.jspf" %>
