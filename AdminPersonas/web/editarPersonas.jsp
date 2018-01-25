<%@include file="templates/header.jsp" %>


<c:if test="${not empty sessionScope.admin}">
    <%@include file="templates/menu.jsp" %>

    <div class="row">
        <div class="col s6 offset-s3 z-depth-3">
            <h4 class="center-align">Editar Persona</h4>
            <form action="control.do" method="post">
                <input type="text" readonly="true" name="rut"
                       value="${requestScope.persona.rut}"/>
                <input type="text" readonly="true" name="nombre"
                       value="${requestScope.persona.nombre}"/>
                <input type="text" readonly="true" name="mail" 
                       value="${requestScope.persona.mail}"/>
                <input type="text" readonly="true" name="perfil"
                       value="${requestScope.persona.perfil}"/>
                <select name="activo">
                    <option ${requestScope.persona.activo?"selected":""}>Si</option>
                    <option ${requestScope.persona.activo?"":"selected"}>No</option>
                </select>
                <button class="btn" id="${requestScope.persona.rut}" name="btn" value="editar">
                    Editar
                </button>
                <br><br>
            </form>
        </div>
    </div>

</c:if>

<c:if test="${empty sessionScope.admin}">
    No tienes permisos para estar aqui.
    <br> <a href="index.jsp">Iniciar Session</a>
</c:if>    


<%@include file="templates/footer.jsp" %>