<%@include file="templates/header.jsp" %>

<c:if test="${not empty sessionScope.admin}">
    <%@include file="templates/menu.jsp" %>

    <div class="row">
        <div class="col s6 offset-s3 z-depth-3">
            <h4 class="center-align">Gestion Personas</h4>
            <form action="control.do" method="post">
                <table class="bordered">
                    <thead>
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Mail</th>
                            <th>Perfil</th>
                            <th>Edad</th>
                            <th>Clave</th>
                            <th>Activo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! private PersonaBeanLocal service;%>
                        <%
                            InitialContext ctx = new InitialContext();
                            this.service = (PersonaBeanLocal) ctx.lookup("java:global/AdminPersonas/PersonaBean!cl.inacap.adminPersonas.beans.PersonaBeanLocal");
                        %>
                        <c:set var="personas" scope="page" value="<%=this.service.getPersonaList()%>"/>

                        <c:forEach items="${pageScope.personas}" var="p">
                            <tr>
                                <td>${p.rut}</td>
                                <td>${p.nombre}</td>
                                <td>${p.mail}</td>
                                <td>${p.perfil}</td>
                                <td>${p.edad}</td>
                                <td>${p.clave}</td>
                                <td>${p.activo?"Si":"No"}</td>
                                <td>
                                    <button name="boton" value="${p.rut}"
                                            class="btn-floating blue">
                                        <i class="material-icons">
                                            edit
                                        </i>
                                    </button>
                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                </table>
            </form>
        </div>
    </div>

</c:if>

<c:if test="${empty sessionScope.admin}">
    No tienes permisos para estar aqui.
    <br> <a href="login.jsp">Iniciar Session</a>
</c:if>    


<%@include file="templates/footer.jsp" %>
