<%@ include file="common/header.jspf" %>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
           <h1>Stadiums </h1>
                <h1>List of stadiums</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Name</th>
                            <th>address</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${stadiums}" var="stadium">
                            <tr>
                                <td>${stadium.id}</td>
                                <td><a href="<c:url value='/list-stadiums/${stadium.id}/sectors' />">${stadium.name}></td>
                                <td>${stadium.address}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
               </table>
        </div>
        <%@ include file="common/footer.jspf" %>
