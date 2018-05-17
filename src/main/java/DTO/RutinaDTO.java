/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Deportista;
import DatoClases.Entrenador;
import DatoClases.Rutina;
import DatoClases.TiempoEntreno;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "RutinaDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class RutinaDTO {

    private int ID_Rutina;

    private int repeticiones;
    private int distancia;
    private String estilo;
    private String fecha;
    private String jornada;
    private EntrenadorDTO entrenadorFK;
    private List<TiempoEntrenoDTO> list_TimeEnt;

    public RutinaDTO() {
    }

    public RutinaDTO(Rutina objCL) {
        this.ID_Rutina = objCL.getID_Rutina();
        this.repeticiones = objCL.getRepeticiones();
        this.distancia = objCL.getDistancia();
        this.estilo = objCL.getEstilo();
        this.fecha = objCL.getFecha();
        this.jornada = objCL.getJornada();
        this.entrenadorFK = new EntrenadorDTO(objCL.getEntrenadorFK());
        this.list_TimeEnt = new ArrayList<>();
    }

    public int getID_Rutina() {
        return ID_Rutina;
    }

    public void setID_Rutina(int ID_Rutina) {
        this.ID_Rutina = ID_Rutina;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public EntrenadorDTO getEntrenadorFK() {
        return entrenadorFK;
    }

    public void setEntrenadorFK(EntrenadorDTO entrenadorFK) {
        this.entrenadorFK = entrenadorFK;
    }

    public List<TiempoEntrenoDTO> list_TimeEnt(List<TiempoEntreno> list_TimeEnt) {
        for (TiempoEntreno tiempoEntreno : list_TimeEnt) {
            TiempoEntrenoDTO dTO = new TiempoEntrenoDTO(tiempoEntreno);
            this.list_TimeEnt.add(dTO);
        }
        return this.list_TimeEnt;
    }

}
