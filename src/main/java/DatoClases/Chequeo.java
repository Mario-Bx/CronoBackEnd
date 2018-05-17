/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "CHEQUEOS")
public class Chequeo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Chequeo;

    private String prueba;
    private int distancia;
    private String tiempo;

    public Chequeo() {
    }

    public Chequeo(String prueba, int distancia, String tiempo) {
        this.prueba = prueba;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    public int getID_Chequeo() {
        return ID_Chequeo;
    }

    public void setID_Chequeo(int ID_Chequeo) {
        this.ID_Chequeo = ID_Chequeo;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Chequeo{" + "ID_Chequeo=" + ID_Chequeo + ", prueba=" + prueba + ", distancia=" + distancia + ", tiempo=" + tiempo + ", deportistaFK=" + deportistaFK + '}';
    }

    //Realacoin de 0-1----1 entrew (Chequeo---Deportista)
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
