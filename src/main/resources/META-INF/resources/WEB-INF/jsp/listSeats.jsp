<%@ include file="common/header.jspf" %>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
           <h1>Seats for chosen sector </h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Seat number</th>
                        <th>Regular price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${seats}" var="seat">
                        <tr>
                            <td>${seat.id}</td>
                            <td><a href="<c:url value='/list-stadiums/${stadium.id}/sectors/${sector.id}/seats/${seat.id}'/>">${seat.seatNumber}</a></td>
                            <td>${seat.regularPrice}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@ include file="common/footer.jspf" %>
