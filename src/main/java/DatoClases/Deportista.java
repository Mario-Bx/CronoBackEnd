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
@Table(name = "DEPORTISTA")
public class Deportista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Deportista;

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int cedula;
    private String ciudad;
    private String categoria;
    private String Contraseña;

    public Deportista() {
        this.list_Tiempo_Competencias = new ArrayList<Tiempo_Competencia>();
        this.list_Chequeos = new ArrayList<Chequeo>();
        this.list_Asistencias = new ArrayList<Asistencia>();
        this.list_Tiempo_Entrenamientos = new ArrayList<TiempoEntreno>();
    }

    public Deportista(String nombre, String apellido, String fechaNacimiento, int cedula, String ciudad, String categoria, String Contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.Contraseña = Contraseña;
        this.list_Tiempo_Competencias = new ArrayList<Tiempo_Competencia>();
        this.list_Chequeos = new ArrayList<Chequeo>();
        this.list_Asistencias = new ArrayList<Asistencia>();
        this.list_Tiempo_Entrenamientos = new ArrayList<TiempoEntreno>();
    }

    public int getID_Deportista() {
        return ID_Deportista;
    }

    public void setID_Deportista(int ID_Deportista) {
        this.ID_Deportista = ID_Deportista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public String toString() {
        return "Deportista{" + "ID_Deportista=" + ID_Deportista + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", cedula=" + cedula + ", ciudad=" + ciudad + ", categoria=" + categoria + ", Contrase\u00f1a=" + Contraseña + ", deporteFK=" + deporteFK + ", entrenadorFK=" + entrenadorFK + '}';
    }
    //Realacoin de 0-1----1 entrew (Evento-Deportista)
    @ManyToOne
    @JoinColumn(name = "deporteFK")
    private Deportes deporteFK;

    public Deportes getDeporteFK() {
        return deporteFK;
    }

    public void setDeporteFK(Deportes deporteFK) {
        this.deporteFK = deporteFK;
    }

    //Realacoin de 0-1----1 entrew (Entrenaodr-Deportista)
    @ManyToOne
    @JoinColumn(name = "entrenadorFK")
    private Entrenador entrenadorFK;

    public Entrenador getEntrenadorFK() {
        return entrenadorFK;
    }

    public void setEntrenadorFK(Entrenador entrenadorFK) {
        this.entrenadorFK = entrenadorFK;
    }

    // Relacion de 1-M entre (Deportista -- Tiempo Competencia)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deportistaFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tiempo_Competencia> list_Tiempo_Competencias;

    public List<Tiempo_Competencia> getList_Tiempo_Competencias() {
        return list_Tiempo_Competencias;
    }

    public void setList_Tiempo_Competencias(List<Tiempo_Competencia> list_Tiempo_Competencias) {
        this.list_Tiempo_Competencias = list_Tiempo_Competencias;
    }

    public void addTiempoComp(Tiempo_Competencia tiempo_Competencia) {
        tiempo_Competencia.setDeportistaFK(this);
        this.list_Tiempo_Competencias.add(tiempo_Competencia);

    }

    // Relacion de 1-M entre (Deportista --- Chequeo)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deportistaFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chequeo> list_Chequeos;

    public List<Chequeo> getList_Chequeos() {
        return list_Chequeos;
    }

    public void setList_Chequeos(List<Chequeo> list_Chequeos) {
        this.list_Chequeos = list_Chequeos;
    }

    public void addChequeo(Chequeo chequeo) {
        chequeo.setDeportistaFK(this);
        this.list_Chequeos.add(chequeo);

    }

    // Relacion de 1-M entre (DEportista --- Asistencia)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deportistaFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asistencia> list_Asistencias;

    public List<Asistencia> getList_Asistencias() {
        return list_Asistencias;
    }

    public void setList_Asistencias(List<Asistencia> list_Asistencias) {
        this.list_Asistencias = list_Asistencias;
    }

    public void addAsistencia(Asistencia objetoR) {
        objetoR.setDeportistaFK(this);
        this.list_Asistencias.add(objetoR);
    }

    // Relacion de 1-M entre (Deportista --- Tiempo entrenamiento)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "deportistaFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TiempoEntreno> list_Tiempo_Entrenamientos;

    public List<TiempoEntreno> getList_Tiempo_Entrenamientos() {
        return list_Tiempo_Entrenamientos;
    }

    public void setList_Tiempo_Entrenamientos(List<TiempoEntreno> list_Tiempo_Entrenamientos) {
        this.list_Tiempo_Entrenamientos = list_Tiempo_Entrenamientos;
    }

    public void addTiempoEntre(TiempoEntreno objetoR) {
        objetoR.setDeportistaFK(this);
        this.list_Tiempo_Entrenamientos.add(objetoR);
    }

}
