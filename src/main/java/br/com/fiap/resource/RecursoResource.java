package br.com.fiap.resource;

import br.com.fiap.model.bo.RecursoBO;
import br.com.fiap.model.to.RecursoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/recursos")
public class RecursoResource {

    private RecursoBO recursoBO = new RecursoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<RecursoTO> resultado = recursoBO.findAll();
        if (resultado != null) {
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid RecursoTO recurso) {
        String resultado = recursoBO.save(recurso);
        if (resultado.contains("sucesso")) {
            return Response.status(Response.Status.CREATED).entity(resultado).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(resultado).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (recursoBO.delete(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, @Valid RecursoTO recurso) {
        recurso.setId(id);
        String resultado = recursoBO.update(recurso);
        if (resultado.contains("sucesso")) {
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(resultado).build();
        }
    }
}