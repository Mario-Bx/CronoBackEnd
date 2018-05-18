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
@Table(name = "RUTINA")
public class Rutina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Rutina;

    private int repeticiones;
    private int distancia;
    private String estilo;
    private String fecha;
    private String jornada;

    public Rutina() {
        this.list_TimeEnt = new ArrayList();
    }

    public Rutina(int repeticiones, int distancia, String estilo, String fecha, String jornada) {
        this.repeticiones = repeticiones;
        this.distancia = distancia;
        this.estilo = estilo;
        this.fecha = fecha;
        this.jornada = jornada;
        this.list_TimeEnt = new ArrayList();
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

    @Override
    public String toString() {
        return "Rutina{" + "ID_Rutina=" + ID_Rutina + ", repeticiones=" + repeticiones + ", distancia=" + distancia + ", estilo=" + estilo + ", fecha=" + fecha + ", jornada=" + jornada + ", entrenadorFK=" + entrenadorFK + '}';
    }
    //Realacoin de 0-1----1 entrew (Rutina --- Entrenador)
    @ManyToOne
    @JoinColumn(name = "entrenadorFK")
    private Entrenador entrenadorFK;

    public Entrenador getEntrenadorFK() {
        return entrenadorFK;
    }

    public void setEntrenadorFK(Entrenador entrenadorFK) {
        this.entrenadorFK = entrenadorFK;
    }

    // Relacion de 1-M entre (Deportista --- Tiempo entrenamiento)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "rutinaFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TiempoEntreno> list_TimeEnt;

    //Metodos
    public List<TiempoEntreno> getList_TimeEnt() {
        return list_TimeEnt;
    }

    public void setList_TimeEnt(List<TiempoEntreno> list_TimeEnt) {
        this.list_TimeEnt = list_TimeEnt;
    }

    public void addTiempoEntre(TiempoEntreno objetoR) {
        objetoR.setRutinaFK(this);
        this.list_TimeEnt.add(objetoR);
    }
}
