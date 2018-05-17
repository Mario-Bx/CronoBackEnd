/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "ASISTENCIA")
public class Asistencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Asistencia;

    private String fecha;
    private String jornada;

    public Asistencia() {
    }

    public Asistencia(String fecha, String jornada) {
        this.fecha = fecha;
        this.jornada = jornada;
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

    @Override
    public String toString() {
        return "Asistencia{" + "ID_Asistencia=" + ID_Asistencia + ", fecha=" + fecha + ", jornada=" + jornada + ", entrenadorFK=" + entrenadorFK + ", deportistaFK=" + deportistaFK + '}';
    }

    //Realacoin de 0-1----1 entrew (Asistencia --- Entrenador)
    @ManyToOne
    @JoinColumn(name = "entrenadorFK")
    private Entrenador entrenadorFK;

    public Entrenador getEntrenadorFK() {
        return entrenadorFK;
    }

    public void setEntrenadorFK(Entrenador entrenadorFK) {
        this.entrenadorFK = entrenadorFK;
    }

    //Realacoin de 0-1----1 entrew (Asistencia --- Deportista)
    @ManyToOne
    @JoinColumn(name = "deportistaFK")
    private Deportista deportistaFK;

    public Deportista getDeportistaFK() {
        return deportistaFK;
    }

    public void setDeportistaFK(Deportista deportistaFK) {
        this.deportistaFK = deportistaFK;
    }

}
