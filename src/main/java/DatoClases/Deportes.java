/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "DEPORTES")
public class Deportes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Deporte;

    private String nombre;
    private String descripcion;

    public Deportes() {
        this.list_Eventos = new ArrayList<EventoClas>();
        this.list_Entrenadores = new ArrayList<Entrenador>();
        this.list_Deportistas = new ArrayList<Deportista>();
    }

    public Deportes(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.list_Eventos = new ArrayList<EventoClas>();
        this.list_Entrenadores = new ArrayList<Entrenador>();
        this.list_Deportistas = new ArrayList<Deportista>();
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

    @Override
    public String toString() {
        return "Deportes{" + "ID_Deporte=" + ID_Deporte + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    // Relacion de 1-M entre (Deportes --- Evento)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deport_FK", cascade = CascadeType.ALL)
    private List<EventoClas> list_Eventos;

    ////Metodos (Deportes getMapeoDeportesEvento)
    public List<EventoClas> getList_Eventos() {
        return list_Eventos;
    }

    public void setList_Eventos(List<EventoClas> list_Eventos) {
        this.list_Eventos = list_Eventos;
    }

    public void addEvento(EventoClas evento) {
        evento.setDeport_FK(this);
        this.list_Eventos.add(evento);
    }

    //Bi-dirreccional
    // Relacion de 1-M entre (Deportes-Entrenador)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deporteFK", cascade = CascadeType.ALL)
    private List<Entrenador> list_Entrenadores;

    ///Metodos de (Deportes-Entrenador)
    public List<Entrenador> getList_Entrenadores() {
        return list_Entrenadores;
    }

    public void setList_Entrenadores(List<Entrenador> list_Entrenadores) {
        this.list_Entrenadores = list_Entrenadores;
    }

    public void addEntrenador(Entrenador entrenador) {
        entrenador.setDeporteFK(this);
        this.list_Entrenadores.add(entrenador);
    }

    //Bi-dirreccional
    // Relacion de 1-M entre (Deportes-Deportista)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deporteFK", cascade = CascadeType.ALL)
    private List<Deportista> list_Deportistas;

    ///Metodos (Deportes-Deportista)
    public List<Deportista> getList_Deportistas() {
        return list_Deportistas;
    }

    public void setList_Deportistas(List<Deportista> list_Deportistas) {
        this.list_Deportistas = list_Deportistas;
    }

    public void addDeportista(Deportista deportista) {
        deportista.setDeporteFK(this);
        this.list_Deportistas.add(deportista);
    }
}
