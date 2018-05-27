/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.DeportesDTO;
import DTO.EventoDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportes;
import DatoClases.EventoClas;
import Fachadas.DeportesFachada;
import Fachadas.EventoClasFachada;
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
@Path("/EventoSv")
public class EventoSv {

    EventoClasFachada objetoFH = null;
    DeportesFachada objetoFH2 = null;
    EventoDTO dto = null;
    DeportesDTO objFk = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<EventoDTO> getListaDto_JSON() throws ConexionException{
        objetoFH = new EventoClasFachada();
        List<EventoClas> objetoCl = objetoFH.buscarTodoObj();
        List<EventoDTO> objetoDTO = new ArrayList<EventoDTO>();
        for (EventoClas objetoCLS : objetoCl) {
            dto = new EventoDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EventoDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new EventoClasFachada();
        EventoClas objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto.list_Tiempo_Competencias(objetoCLS.getList_Tiempo_Competencias());
        dto = new EventoDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EventoDTO addObjeto(EventoDTO objetoDto) throws ConexionException {

        objetoFH = new EventoClasFachada();
        EventoClas objetoCLS = new EventoClas();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setTipo(objetoDto.getTipo());
        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setLugar(objetoDto.getLugar());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeport_FK(objetoCLS2);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EventoDTO actualizarObjeto(EventoDTO objetoDto) throws ConexionException {

        objetoFH = new EventoClasFachada();
        EventoClas objetoCLS = new EventoClas();
        objetoCLS.setID_Evento(objetoDto.getID_Evento());
        objetoCLS.setID_Evento(objetoDto.getID_Evento());
        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setTipo(objetoDto.getTipo());
        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setLugar(objetoDto.getLugar());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeport_FK(objetoCLS2);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new EventoClasFachada();
        EventoClas objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
