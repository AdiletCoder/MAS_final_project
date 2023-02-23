<%@ include file="common/header.jspf" %>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
                <h1>List of games</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>team's name</th>
                            <th>tournaments</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${games}" var="game">
                            <tr>
                                <td>${game.id}</td>
                                <td><a href="<c:url value='/list-games/${game.id}/times' />">${game.teamsName}</a></td>
                                <td>${game.tournaments}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
<%--                </table>--%>
<%--            <a href="add-game" class="btn btn-success">Add game</a>--%>
        </div>
        <%@ include file="common/footer.jspf" %>
