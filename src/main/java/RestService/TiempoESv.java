/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.TiempoEntrenoDTO;
import DaoGenerico.ConexionException;
import DatoClases.Deportista;
import DatoClases.Rutina;
import DatoClases.TiempoEntreno;
import Fachadas.DeportistaFachada;
import Fachadas.RutinaFachada;
import Fachadas.TiempoEntFachada;
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
@Path("/TiempoESv")
public class TiempoESv {

    TiempoEntFachada objetoFH = null;
    DeportistaFachada objetoFH2 = null;
    RutinaFachada objetoFH3 = null;
    TiempoEntrenoDTO dto = null;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TiempoEntrenoDTO> getListaDto_JSON() throws ConexionException{
        objetoFH = new TiempoEntFachada();
        List<TiempoEntreno> objetoCl = objetoFH.buscarTodoObj();
        List<TiempoEntrenoDTO> objetoDTO = new ArrayList<TiempoEntrenoDTO>();
        for (TiempoEntreno objetoCLS : objetoCl) {
            dto = new TiempoEntrenoDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    /////
    /////
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoEntrenoDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new TiempoEntFachada();
        TiempoEntreno objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new TiempoEntrenoDTO(objetoCLS);
        return dto;
    }
//    
//    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoEntrenoDTO addObjeto(TiempoEntrenoDTO objetoDto) throws ConexionException {

        objetoFH = new TiempoEntFachada();
        TiempoEntreno objetoCLS = new TiempoEntreno();

        objetoCLS.setTiempo(objetoDto.getTiempo());
        objetoCLS.setTiempoexigencia(objetoDto.getTiempoexigencia());
        objetoCLS.setTiempodescanso(objetoDto.getTiempodescanso());
        objetoCLS.setSerie(objetoDto.getSerie());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH3 = new RutinaFachada();
        Rutina objetoCLS3 = objetoFH3.busacarObj(objetoDto.getRutinaFK().getID_Rutina());
        objetoCLS.setRutinaFK(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TiempoEntrenoDTO actualizarObjeto(TiempoEntrenoDTO objetoDto) throws ConexionException {

        objetoFH = new TiempoEntFachada();
        TiempoEntreno objetoCLS = new TiempoEntreno();
        objetoCLS.setID_tiempos(objetoDto.getID_tiempos());
        objetoCLS.setTiempo(objetoDto.getTiempo());
        objetoCLS.setTiempoexigencia(objetoDto.getTiempoexigencia());
        objetoCLS.setTiempodescanso(objetoDto.getTiempodescanso());
        objetoCLS.setSerie(objetoDto.getSerie());

        objetoFH2 = new DeportistaFachada();
        Deportista objetoCLS2 = objetoFH2.busacarObj(objetoDto.getDeportistaFK().getID_Deportista());
        objetoCLS.setDeportistaFK(objetoCLS2);

        objetoFH3 = new RutinaFachada();
        Rutina objetoCLS3 = objetoFH3.busacarObj(objetoDto.getRutinaFK().getID_Rutina());
        objetoCLS.setRutinaFK(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    /////
    /////
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new TiempoEntFachada();
        TiempoEntreno objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
