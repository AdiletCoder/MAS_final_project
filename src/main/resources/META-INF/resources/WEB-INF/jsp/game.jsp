<%@ include file="common/header.jspf" %>
    <body>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
           <h1>Enter Game Details </h1>
           <form:form method="post" modelAttribute="game">
            <fieldset class="mb-3">
                <form:label path="teamsName">Team's name</form:label>
                <form:input type="text" path="teamsName" required="required"/>
                <form:errors path="teamsName" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">
                <form:label path="tournaments">Tournaments</form:label>
                <form:input type="text" path="tournaments" required="required"/>
                <form:errors path="tournaments" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type="submit" class="btn btn-success">
            </form:form>
        </div>


        <script type="text/javascript">
                    $('#targetDate').datepicker({
                        format: 'yyyy-mm-dd'
                    });
                </script>
       <%@ include file="common/footer.jspf" %>
