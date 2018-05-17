/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Asistencia;
import DatoClases.Deportista;
import DatoClases.Entrenador;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "AsistenciaDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class AsistenciaDTO {

    private int ID_Asistencia;
    private String fecha;
    private String jornada;
    private EntrenadorDTO entrenadorFK;
    private DeportistaDTO deportistaFk;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(Asistencia objCL) {
        this.ID_Asistencia = objCL.getID_Asistencia();
        this.fecha = objCL.getFecha();
        this.jornada = objCL.getJornada();
        this.entrenadorFK = new EntrenadorDTO(objCL.getEntrenadorFK());
        this.deportistaFk = new DeportistaDTO(objCL.getDeportistaFK());
    }

    public int getID_Asistencia() {
        return ID_Asistencia;
    }

    public void setID_Asistencia(int ID_Asistencia) {
        this.ID_Asistencia = ID_Asistencia;
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

    public DeportistaDTO getDeportistaFk() {
        return deportistaFk;
    }

    public void setDeportistaFk(DeportistaDTO deportistaFk) {
        this.deportistaFk = deportistaFk;
    }

}
