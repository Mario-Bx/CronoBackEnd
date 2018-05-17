/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.DeportesDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportes;
import Fachadas.DeportesFachada;
//// COPIAR
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MARIO
 */
@Path("/DeporteSv")
public class DeporteSv {

    DeportesFachada objetoFH = null;
    DeportesDTO dto = null;

    ///////OBTENER TODOS LOS DEPORTES
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<DeportesDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new DeportesFachada();
        List<Deportes> objetoCl = objetoFH.buscarTodoObj();
        List<DeportesDTO> objetoDTO = new ArrayList<DeportesDTO>();
        for (Deportes objetoCLS : objetoCl) {
            dto = new DeportesDTO(objetoCLS);
            dto.List_Eventos(objetoCLS.getList_Eventos());
            dto.list_Entrenadores(objetoCLS.getList_Entrenadores());
            dto.list_Deportistas(objetoCLS.getList_Deportistas());
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////OBTENER UN DEPORTE ESPECIFICO
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeportesDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new DeportesFachada();
        Deportes objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new DeportesDTO(objetoCLS);
        return dto;
    }

    /////INSERTAR UN NUEVO DEPORTE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeportesDTO addObjeto(DeportesDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new DeportesFachada();
        Deportes objetoCLS = new Deportes();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setDescripcion(objetoDto.getDescripcion());

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    //// ACTUALIZAR UN DEPORTE
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeportesDTO actualizarObjeto(DeportesDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new DeportesFachada();
        Deportes objetoCLS = new Deportes();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setDescripcion(objetoDto.getDescripcion());

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////ELIMINAR UN DEPORTE
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new DeportesFachada();
        Deportes objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
