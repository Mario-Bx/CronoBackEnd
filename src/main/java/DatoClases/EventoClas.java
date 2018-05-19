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
@Table(name = "EVENTOS")
public class EventoClas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Evento;

    private String nombre;
    private String Tipo;
    private String fecha;
    private String lugar;

    public EventoClas() {
        this.list_Tiempo_Competencias = new ArrayList<Tiempo_Competencia>();
    }

    public EventoClas(String nombre, String Tipo, String fecha, String lugar) {
        this.nombre = nombre;
        this.Tipo = Tipo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.list_Tiempo_Competencias = new ArrayList<Tiempo_Competencia>();
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

    @Override
    public String toString() {
        return "EventoClas{" + "ID_Evento=" + ID_Evento + ", nombre=" + nombre + ", Tipo=" + Tipo + ", fecha=" + fecha + ", lugar=" + lugar + ", deport_FK=" + deport_FK + '}';
    }
    //Realacoin de 0-1----1 entrew (EventoClas --- Deporte)
    @ManyToOne
    @JoinColumn(name = "deport_FK")
    private Deportes deport_FK;

    public Deportes getDeport_FK() {
        return deport_FK;
    }

    public void setDeport_FK(Deportes deport_FK) {
        this.deport_FK = deport_FK;
    }

    // Relacion de 1-M entre (EventoClas -- Tiempo Competencia)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "EventoFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tiempo_Competencia> list_Tiempo_Competencias;

    public List<Tiempo_Competencia> getList_Tiempo_Competencias() {
        return list_Tiempo_Competencias;
    }

    public void setList_Tiempo_Competencias(List<Tiempo_Competencia> list_Tiempo_Competencias) {
        this.list_Tiempo_Competencias = list_Tiempo_Competencias;
    }

    public void addEvento(Tiempo_Competencia tiempo_Competencia) {
        tiempo_Competencia.setEventoFK(this);
        this.list_Tiempo_Competencias.add(tiempo_Competencia);

    }

}
