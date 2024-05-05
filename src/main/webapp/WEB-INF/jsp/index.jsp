<%@include file="comunes/head.jsp"%>
<%@include file="comunes/navbar.jsp"%>



<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3> sistema de estudiantes </h3>
    </div>
</div>

<div class="container">
    <table class="table table-striped table-hover table-bordered aling-middle">
        <thead class="table-dark text-center">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">materia</th>
            <th scope="col">Calificacion</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <!-- sintaxis para hacer el foreach para recorrer cada objeto de tipo estudiante
        de min indexControlador -->
        <c:forEach var="Estudiante" items="${estudiantes}">
        <tr>
            <th scope="row">${Estudiante.idEstudiante}</th>
            <td>${Estudiante.nombre}</td>
            <td>${Estudiante.materia}</td>
            <td>
            <fmt:formatNumber type="number" value="${Estudiante.nota}" pattern="credits: #"/>
            </td>
            <td class="text-center">
                <c:set var="urleditar">
                    <c:url value="${application.contextPath}/edit">
                        <c:param name="idEstudiante" value="${Estudiante.idEstudiante}"/>
                    </c:url>
                </c:set>
                <a href="${urleditar}" class="btn btn-warning btn-sm me-3">modificar</a>

                <c:set var="urleliminar">
                    <c:url value="${application.contextPath}/delete">
                        <c:param name="idEstudiante" value="${Estudiante.idEstudiante}"/>
                    </c:url>
                </c:set>
                <a href="${urleliminar}" class="btn btn-danger btn-sm me-3">eliminar</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<%@include file="comunes/footer.jsp"%>
