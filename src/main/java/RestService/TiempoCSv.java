/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.TiempoCompDTO;
import DaoGenerico.ConexionException;
import DatoClases.Tiempo_Competencia;
import DatoClases.EventoClas;
import DatoClases.Deportista;
import Fachadas.TiempooCompFachada;
import Fachadas.EventoClasFachada;
import Fachadas.DeportistaFachada;
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
@Path("/TiempoCSv")
public class TiempoCSv {

    TiempooCompFachada objetoFH = null;
    DeportistaFachada objetoFH2 = null;
    EventoClasFachada objetoFH3 = null;
    TiempoCompDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TiempoCompDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new TiempooCompFachada();
        List<Tiempo_Competencia> objetoCl = objetoFH.buscarTodoObj();
        List<TiempoCompDTO> objetoDTO = new ArrayList<TiempoCompDTO>();
        for (Tiempo_Competencia objetoCLS : objetoCl) {
            dto = new TiempoCompDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoCompDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new TiempooCompFachada();
        Tiempo_Competencia objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new TiempoCompDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoCompDTO addObjeto(TiempoCompDTO objetoDto) throws ConexionException {

        objetoFH = new TiempooCompFachada();
        Tiempo_Competencia objetoCLS = new Tiempo_Competencia();

        objetoCLS.setPrueba(objetoDto.getPrueba());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setTiempo(objetoDto.getTiempo());
        objetoCLS.setCategoria(objetoDto.getCategoria());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH3 = new EventoClasFachada();
        EventoClas objetoCLS3 = objetoFH3.busacarObj(objetoDto.getEventoFK().getID_Evento());
        objetoCLS.setEventoFK(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoCompDTO actualizarObjeto(TiempoCompDTO objetoDto) throws ConexionException {

        objetoFH = new TiempooCompFachada();
        Tiempo_Competencia objetoCLS = new Tiempo_Competencia();
        objetoCLS.setID_tiempos(objetoDto.getID_tiempos());
        objetoCLS.setPrueba(objetoDto.getPrueba());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setTiempo(objetoDto.getTiempo());
        objetoCLS.setCategoria(objetoDto.getCategoria());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH3 = new EventoClasFachada();
        EventoClas objetoCLS3 = objetoFH3.busacarObj(objetoDto.getEventoFK().getID_Evento());
        objetoCLS.setEventoFK(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new TiempooCompFachada();
        Tiempo_Competencia objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }

}
