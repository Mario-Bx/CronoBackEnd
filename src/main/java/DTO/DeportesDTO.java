/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Deportes;
import DatoClases.Deportista;
import DatoClases.Entrenador;
import DatoClases.EventoClas;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "DeporteDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeportesDTO {

    private int ID_Deporte;
    private String nombre;
    private String descripcion;
    private List<EventoDTO> list_Eventos;
    private List<EntrenadorDTO> list_Entrenadores;
    private List<DeportistaDTO> list_Deportistas;

    public DeportesDTO() {
    }

    public DeportesDTO(Deportes objetoCL) {
        this.ID_Deporte = objetoCL.getID_Deporte();
        this.nombre = objetoCL.getNombre();
        this.descripcion = objetoCL.getDescripcion();
        this.list_Eventos = new ArrayList();
        this.list_Entrenadores = new ArrayList();
        this.list_Deportistas = new ArrayList();
    }

    public int getID_Deporte() {
        return ID_Deporte;
    }

    public void setID_Deporte(int ID_Deporte) {
        this.ID_Deporte = ID_Deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<EventoDTO> List_Eventos(List<EventoClas> list_Eventos) {
        for (EventoClas list_Evento : list_Eventos) {
            EventoDTO dTO = new EventoDTO(list_Evento);
            this.list_Eventos.add(dTO);
        }
        return this.list_Eventos;
    }

    public List<EntrenadorDTO> list_Entrenadores(List<Entrenador> list_Entrenadores) {
        for (Entrenador list_Entrenadore : list_Entrenadores) {
            EntrenadorDTO dTO = new EntrenadorDTO(list_Entrenadore);
            this.list_Entrenadores.add(dTO);
        }
        return this.list_Entrenadores;
    }

    public List<DeportistaDTO> list_Deportistas(List<Deportista> list_Deportistas) {
        for (Deportista list_Deportista : list_Deportistas) {
            DeportistaDTO dTO = new DeportistaDTO(list_Deportista);
            this.list_Deportistas.add(dTO);
        }
        return this.list_Deportistas;
    }

}
