/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.DeportesDTO;
import DTO.ChequeoDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportista;
import DatoClases.Chequeo;
import Fachadas.DeportistaFachada;
import Fachadas.ChequeoFachada;
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
@Path("/ChequeoSv")
public class ChequeoSv {

    ChequeoFachada objetoFH = null;
    DeportistaFachada objetoFH2 = null;
    ChequeoDTO dto = null;
    DeportesDTO objFk = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ChequeoDTO> getListaDto_JSON() throws ConexionException, Fachadas.ConexionException {
        objetoFH = new ChequeoFachada();
        List<Chequeo> objetoCl = objetoFH.buscarTodoObj();
        List<ChequeoDTO> objetoDTO = new ArrayList<ChequeoDTO>();
        for (Chequeo objetoCLS : objetoCl) {
            dto = new ChequeoDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ChequeoDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {
        objetoFH = new ChequeoFachada();
        Chequeo objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new ChequeoDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ChequeoDTO addObjeto(ChequeoDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new ChequeoFachada();
        Chequeo objetoCLS = new Chequeo();

        objetoCLS.setPrueba(objetoDto.getPrueba());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setTiempo(objetoDto.getTiempo());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ChequeoDTO actualizarObjeto(ChequeoDTO objetoDto) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new ChequeoFachada();
        Chequeo objetoCLS = new Chequeo();

        objetoCLS.setPrueba(objetoDto.getPrueba());
        objetoCLS.setDistancia(objetoDto.getDistancia());
        objetoCLS.setTiempo(objetoDto.getTiempo());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException, Fachadas.ConexionException {

        objetoFH = new ChequeoFachada();
        Chequeo objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
