<%@ include file="common/header.jspf" %>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
           <h1>Matches for ${game.teamsName} </h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Start time</th>
                            <th>End time</th>
                            <th>Check sectors</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${times}" var="time">
                        <tr>
                                <td>${time.id}</td>
                                <td>${time.startingDateTime}</td>
                                <td>${time.endingDateTime}</td>
                                <td><a href="<c:url value='/list-times/${time.id}/sectors'/>">Select sectors</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
        <%@ include file="common/footer.jspf" %>
