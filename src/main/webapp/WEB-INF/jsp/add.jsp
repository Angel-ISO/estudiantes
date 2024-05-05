<%@include file="comunes/head.jsp"%>
<%@include file="comunes/navbar.jsp"%>


<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>registro de nuevo  estudiante</h3>
    </div>
</div>

<div class="container">
    <form action="${pageContext.request.contextPath}/add" modelAtribute="estudianteForma" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre del estudiante</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required="required">
        </div>
        <div class="mb-3">
            <label for="materia" class="form-label">Que materia termino de cursar?</label>
            <input type="text" class="form-control" id="materia" name="materia">
        </div>
        <div class="mb-3">
            <label for="nota" class="form-label">Que nota obtuvo?</label>
            <input type="number" step="any" class="form-control" name="nota" id="nota">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-warning btn-sm  me-3">Registrar Estudiante</button>
            <a href="${pageContext.request.contextPath}" class="btn btn-danger btn-sm" >Regresar</a>
        </div>
    </form>
</div>


<%@include file="comunes/footer.jsp"%>
