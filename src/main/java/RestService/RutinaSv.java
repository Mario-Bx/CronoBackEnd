/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.RutinaDTO;
import DaoGenerico.ConexionException;
import DatoClases.Rutina;
import DatoClases.Entrenador;
import Fachadas.RutinaFachada;
import Fachadas.EntrenadorFachada;
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
@Path("/RutinaSv")
public class RutinaSv {

    RutinaFachada objetoFH = null;
    EntrenadorFachada objetoFH3 = null;
    RutinaDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RutinaDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new RutinaFachada();
        List<Rutina> objetoCl = objetoFH.buscarTodoObj();
        List<RutinaDTO> objetoDTO = new ArrayList<RutinaDTO>();
        for (Rutina objetoCLS : objetoCl) {
            dto = new RutinaDTO(objetoCLS);
            dto.list_TimeEnt(objetoCLS.getList_TimeEnt());
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RutinaDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new RutinaFachada();
        Rutina objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new RutinaDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RutinaDTO addObjeto(RutinaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new RutinaFachada();
        Rutina objetoCLS = new Rutina();

        objetoCLS.setRepeticiones(objetoDto.getRepeticiones());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setEstilo(objetoDto.getEstilo());
        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setJornada(objetoDto.getJornada());

        objetoFH3 = new EntrenadorFachada();
        Entrenador objetoCLS3 = objetoFH3.busacarObj(objetoDto.getEntrenadorFK().getID_Entrenador());
        objetoCLS.setEntrenadorFK(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RutinaDTO actualizarObjeto(RutinaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new RutinaFachada();
        Rutina objetoCLS = new Rutina();

        objetoCLS.setRepeticiones(objetoDto.getRepeticiones());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setEstilo(objetoDto.getEstilo());
        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setJornada(objetoDto.getJornada());

        objetoFH3 = new EntrenadorFachada();
        Entrenador objetoCLS3 = objetoFH3.busacarObj(objetoDto.getEntrenadorFK().getID_Entrenador());
        objetoCLS.setEntrenadorFK(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new RutinaFachada();
        Rutina objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
