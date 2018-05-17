/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Deportista;
import DatoClases.EventoClas;
import DatoClases.Tiempo_Competencia;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "EventoDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoDTO {

    private int ID_Evento;
    private String nombre;
    private String Tipo;
    private String fecha;
    private String lugar;
    private DeportesDTO deporteFK;
    private List<TiempoCompDTO> list_Tiempo_Competencias;

    public EventoDTO() {
    }

    public EventoDTO(EventoClas objCL) {
        this.ID_Evento = objCL.getID_Evento();
        this.nombre = objCL.getNombre();
        this.Tipo = objCL.getTipo();
        this.fecha = objCL.getFecha();
        this.lugar = objCL.getLugar();
        this.deporteFK = new DeportesDTO(objCL.getDeport_FK());
        this.list_Tiempo_Competencias = new ArrayList<>();
    }

    public int getID_Evento() {
        return ID_Evento;
    }

    public void setID_Evento(int ID_Evento) {
        this.ID_Evento = ID_Evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public DeportesDTO getDeporteFK() {
        return deporteFK;
    }

    public void setDeporteFK(DeportesDTO deporteFK) {
        this.deporteFK = deporteFK;
    }

    public List<TiempoCompDTO> list_Tiempo_Competencias(List<Tiempo_Competencia> list_Tiempo_Competencias) {
        for (Tiempo_Competencia list_Tiempo_Competencia : list_Tiempo_Competencias) {
            TiempoCompDTO compDTO = new TiempoCompDTO(list_Tiempo_Competencia);
            this.list_Tiempo_Competencias.add(compDTO);
        }
        return this.list_Tiempo_Competencias;
    }
}
