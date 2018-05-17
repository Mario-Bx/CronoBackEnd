/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.TiempoEntreno;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "TiempoEntrenoDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class TiempoEntrenoDTO {

    private int ID_tiempos;
    private String tiempo;
    private String tiempoexigencia;
    private String tiempodescanso;
    private int serie;
    private DeportistaDTO deportistaFK;
    private RutinaDTO rutinaFK;

    public TiempoEntrenoDTO() {
    }

    public TiempoEntrenoDTO(TiempoEntreno objCL) {
        this.ID_tiempos = objCL.getID_tiempos();
        this.tiempo = objCL.getTiempo();
        this.tiempoexigencia = objCL.getTiempoexigencia();
        this.tiempodescanso = objCL.getTiempodescanso();
        this.serie = objCL.getSerie();
        this.deportistaFK = new DeportistaDTO(objCL.getDeportistaFK());
        this.rutinaFK = new RutinaDTO(objCL.getRutinaFK());
    }

    public int getID_tiempos() {
        return ID_tiempos;
    }

    public void setID_tiempos(int ID_tiempos) {
        this.ID_tiempos = ID_tiempos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTiempoexigencia() {
        return tiempoexigencia;
    }

    public void setTiempoexigencia(String tiempoexigencia) {
        this.tiempoexigencia = tiempoexigencia;
    }

    public String getTiempodescanso() {
        return tiempodescanso;
    }

    public void setTiempodescanso(String tiempodescanso) {
        this.tiempodescanso = tiempodescanso;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public DeportistaDTO getDeportistaFK() {
        return deportistaFK;
    }

    public void setDeportistaFK(DeportistaDTO deportistaFK) {
        this.deportistaFK = deportistaFK;
    }

    public RutinaDTO getRutinaFK() {
        return rutinaFK;
    }

    public void setRutinaFK(RutinaDTO rutinaFK) {
        this.rutinaFK = rutinaFK;
    }

}
