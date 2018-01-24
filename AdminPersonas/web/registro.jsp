<%@include  file="templates/header.jsp" %>
<c:if test="${requestScope.msg != null}">
    <div class="row">
        <div class=" red darken-4 white-text">
            ${requestScope.msg}
        </div>
    </div>
</c:if>
<form class="row form" method="POST" action="control.do">
    <div class="col s3 offset-s4">

        <div class="row">
            <h3>Registro</h3>
        </div>
        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="rut" class="active">Rut</label>
                <input type="text" name="rut" class="validate"  />
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" class="validate"  />
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="mail">Mail</label>
                <input type="text" name="mail" class="validate"  />
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <div class="input-field">
                    <select>
                        <option value="" disabled selected>Seleccione perfil</option>
                        <option value="admin">Admin</option>
                        <option value="user">User</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="edad">Edad</label>
                <input type="number" name="edad" class="validate"  />
            </div>
        </div>

        <input hidden="true" type="text" name="active" value="true" class="validate"  />

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="clave">Clave</label>
                <input type="password" name="clave" class="validate"  />
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <label for="confirmarClave">Confirmar Clave</label>
                <input type="password" name="confirmarClave" class="validate"  />
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12 l12 m12">
                <input type="submit" class="btn waves-light waves-effect red darken-4" value="Aceptar" />
            </div>
        </div>
        <div class="row">
            <div class="col s12 offset-s1">
                <a href="login.jsp">Volver</a>
            </div>
        </div>
    </div>
</form>
<%@include file="templates/footer.jsp" %>