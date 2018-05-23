/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.DeportistaDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportista;
import DatoClases.Deportes;
import DatoClases.Entrenador;
import Fachadas.DeportistaFachada;
import Fachadas.DeportesFachada;
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
@Path("/DeportistaSv")
public class DeportistaSv {

    DeportistaFachada objetoFH = null;
    DeportesFachada objetoFH2 = null;
    EntrenadorFachada objetoFH3 = null;
    DeportistaDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<DeportistaDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new DeportistaFachada();
        List<Deportista> objetoCl = objetoFH.buscarTodoObj();
        List<DeportistaDTO> objetoDTO = new ArrayList<DeportistaDTO>();
        for (Deportista objetoCLS : objetoCl) {
            dto = new DeportistaDTO(objetoCLS);
            dto.list_Asistencias(objetoCLS.getList_Asistencias());
            dto.list_Chequeos(objetoCLS.getList_Chequeos());
            dto.list_Tiempo_Competencias(objetoCLS.getList_Tiempo_Competencias());
            dto.list_Tiempo_Entrenamientos(objetoCLS.getList_Tiempo_Entrenamientos());
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeportistaDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new DeportistaFachada();
        Deportista objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new DeportistaDTO(objetoCLS);
        dto.list_Asistencias(objetoCLS.getList_Asistencias());
        dto.list_Chequeos(objetoCLS.getList_Chequeos());
        dto.list_Tiempo_Competencias(objetoCLS.getList_Tiempo_Competencias());
        dto.list_Tiempo_Entrenamientos(objetoCLS.getList_Tiempo_Entrenamientos());
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeportistaDTO addObjeto(DeportistaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new DeportistaFachada();
        Deportista objetoCLS = new Deportista();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setApellido(objetoDto.getApellido());
        objetoCLS.setFechaNacimiento(objetoDto.getFechaNacimiento());
        objetoCLS.setCedula(objetoDto.getCedula());
        objetoCLS.setCiudad(objetoDto.getCiudad());
        objetoCLS.setCategoria(objetoDto.getCategoria());
        objetoCLS.setPassword(objetoDto.getPassword());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeporteFK(objetoCLS2);

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
    public DeportistaDTO actualizarObjeto(DeportistaDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new DeportistaFachada();
        Deportista objetoCLS = new Deportista();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setApellido(objetoDto.getApellido());
        objetoCLS.setFechaNacimiento(objetoDto.getFechaNacimiento());
        objetoCLS.setCedula(objetoDto.getCedula());
        objetoCLS.setCiudad(objetoDto.getCiudad());
        objetoCLS.setCategoria(objetoDto.getCategoria());
        objetoCLS.setPassword(objetoDto.getPassword());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeporteFK(objetoCLS2);

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

        objetoFH = new DeportistaFachada();
        Deportista objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
