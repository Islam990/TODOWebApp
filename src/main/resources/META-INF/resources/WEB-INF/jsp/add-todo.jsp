<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="commen/header.jspf" %>
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

    <body>
    <%@ include file="commen/navigation.jspf" %>
        <div class="container">
            <h1>Type Todo Details</h1>
            <%--@elvariable id="todo" type="com.islamgad.springboot.todowebapp.data.TODO"--%>
            <form:form method="post" modelAttribute="todo">

                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required"/>
                    <form:errors  path="description" cssClass="text-warning"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors  path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <form:input type="hidden" name="id" path="id"/>

                <form:input type="hidden" name="done" path="done"/>

                <input type="submit" class="btn btn-success">

            </form:form>
        </div>
    <%@ include file="commen/footer.jspf" %>

    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>