<%@ include file="common/header.jspf" %>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
           <h1>Sectors </h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Name</th>
                            <th>numberOfSeats</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sectors}" var="sector">
                            <tr>
                                <td>${sector.id}</td>
                                <td>${sector.name}</td>
                                <td><a href="<c:url value='/list-stadiums/${stadium.id}/sectors/${sector.id}/seats'/>">${sector.numberOfSeats}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
        <%@ include file="common/footer.jspf" %>
