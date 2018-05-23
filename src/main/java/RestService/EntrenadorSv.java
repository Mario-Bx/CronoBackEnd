/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.EntrenadorDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportes;
import DatoClases.Entrenador;
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
@Path("/EntrenadorSv")
public class EntrenadorSv {

    EntrenadorFachada objetoFH = null;
    DeportesFachada objetoFH2 = null;
    EntrenadorDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<EntrenadorDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new EntrenadorFachada();
        List<Entrenador> objetoCl = objetoFH.buscarTodoObj();
        List<EntrenadorDTO> objetoDTO = new ArrayList<EntrenadorDTO>();
        for (Entrenador objetoCLS : objetoCl) {
            dto = new EntrenadorDTO(objetoCLS);
            dto.list_Asistencias(objetoCLS.getList_Asistencias());
//            dto.list_Deportistas(objetoCLS.getList_Deportistas());
            dto.list_Rutinas(objetoCLS.getList_Rutinas());
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EntrenadorDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new EntrenadorFachada();
        Entrenador objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new EntrenadorDTO(objetoCLS);
        dto.list_Asistencias(objetoCLS.getList_Asistencias());
        dto.list_Deportistas(objetoCLS.getList_Deportistas());
        dto.list_Rutinas(objetoCLS.getList_Rutinas());
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EntrenadorDTO addObjeto(EntrenadorDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new EntrenadorFachada();
        Entrenador objetoCLS = new Entrenador();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setApellido(objetoDto.getApellido());
        objetoCLS.setFechaNacimiento(objetoDto.getFechaNacimiento());
        objetoCLS.setCedula(objetoDto.getCedula());
        objetoCLS.setCiudad(objetoDto.getCiudad());
//        objetoCLS.setContraseña(objetoDto.getContraseña());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeporteFK(objetoCLS2);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EntrenadorDTO actualizarObjeto(EntrenadorDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new EntrenadorFachada();
        Entrenador objetoCLS = new Entrenador();

        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setApellido(objetoDto.getApellido());
        objetoCLS.setFechaNacimiento(objetoDto.getFechaNacimiento());
        objetoCLS.setCedula(objetoDto.getCedula());
        objetoCLS.setCiudad(objetoDto.getCiudad());
//        objetoCLS.setContraseña(objetoDto.getContraseña());

        objetoFH2 = new DeportesFachada();
        Deportes objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeporteFK().getID_Deporte());
        objetoCLS.setDeporteFK(objetoCLS2);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new EntrenadorFachada();
        Entrenador objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
