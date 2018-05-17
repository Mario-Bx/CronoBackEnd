/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.DeportesDTO;
import DTO.AsistenciaDTO;
import DaoGenerico.ConexionException;
import DatoClases.Entrenador;
import DatoClases.Deportista;
import DatoClases.Asistencia;
import Fachadas.EntrenadorFachada;
import Fachadas.DeportistaFachada;
import Fachadas.AsistenciaFachada;
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
@Path("/AsistenciaSv")
public class AsistenciaSv {

    AsistenciaFachada objetoFH = null;
    EntrenadorFachada objetoFH2 = null;
    DeportistaFachada objetoFH3 = null;
    AsistenciaDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AsistenciaDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new AsistenciaFachada();
        List<Asistencia> objetoCl = objetoFH.buscarTodoObj();
        List<AsistenciaDTO> objetoDTO = new ArrayList<AsistenciaDTO>();
        for (Asistencia objetoCLS : objetoCl) {
            dto = new AsistenciaDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AsistenciaDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new AsistenciaFachada();
        Asistencia objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new AsistenciaDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AsistenciaDTO addObjeto(AsistenciaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new AsistenciaFachada();
        Asistencia objetoCLS = new Asistencia();

        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setJornada(objetoDto.getJornada());

        objetoFH2 = new EntrenadorFachada();
        Entrenador objetoCLS2 = objetoFH2.busacarObj(objetoDto.getEntrenadorFK().getID_Entrenador());
        objetoCLS.setEntrenadorFK(objetoCLS2);

        objetoFH3 = new DeportistaFachada();
        Deportista objetoCLS3 = objetoFH3.busacarObj(objetoDto.getDeportistaFk().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AsistenciaDTO actualizarObjeto(AsistenciaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new AsistenciaFachada();
        Asistencia objetoCLS = new Asistencia();

        objetoCLS.setFecha(objetoDto.getFecha());
        objetoCLS.setJornada(objetoDto.getJornada());

        objetoFH2 = new EntrenadorFachada();
        Entrenador objetoCLS2 = objetoFH2.busacarObj(objetoDto.getEntrenadorFK().getID_Entrenador());
        objetoCLS.setEntrenadorFK(objetoCLS2);

        objetoFH3 = new DeportistaFachada();
        Deportista objetoCLS3 = objetoFH3.busacarObj(objetoDto.getDeportistaFk().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new AsistenciaFachada();
        Asistencia objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
