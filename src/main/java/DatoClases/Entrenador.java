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
@Table(name = "ENTRENADOR")
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Entrenador;

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int cedula;
    private String ciudad;
    private String Contraseña;

    public Entrenador() {
        this.list_Asistencias = new ArrayList();
        this.list_Deportistas = new ArrayList();
        this.list_Rutinas = new ArrayList();
    }

    public Entrenador(String nombre, String apellido, String fechaNacimiento, int cedula, String ciudad, String Contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.Contraseña = Contraseña;
        this.list_Asistencias = new ArrayList();
        this.list_Deportistas = new ArrayList();
        this.list_Rutinas = new ArrayList();
    }

    public int getID_Entrenador() {
        return ID_Entrenador;
    }

    public void setID_Entrenador(int ID_Entrenador) {
        this.ID_Entrenador = ID_Entrenador;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "ID_Entrenador=" + ID_Entrenador + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", cedula=" + cedula + ", ciudad=" + ciudad + ", Contrase\u00f1a=" + Contraseña + ", deporteFK=" + deporteFK + '}';
    }
    //Realacoin de 0-1----1 entrew (Evento-Entrenador)
    @ManyToOne
    @JoinColumn(name = "deporteFK")
    private Deportes deporteFK;

    public Deportes getDeporteFK() {
        return deporteFK;
    }

    public void setDeporteFK(Deportes deporteFK) {
        this.deporteFK = deporteFK;
    }

///// Relacion de 1-M entre (Entrenador --- Asistencia)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "entrenadorFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asistencia> list_Asistencias;

    ////
    public List<Asistencia> getList_Asistencias() {
        return list_Asistencias;
    }

    public void setList_Asistencias(List<Asistencia> list_Asistencias) {
        this.list_Asistencias = list_Asistencias;
    }

    public void addAsistencia(Asistencia objetoR) {
        objetoR.setEntrenadorFK(this);
        this.list_Asistencias.add(objetoR);
    }

    // Relacion de 1-M entre (Entrenador --- Deportista)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "entrenadorFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deportista> list_Deportistas;

    public List<Deportista> getList_Deportistas() {
        return list_Deportistas;
    }

    public void setList_Deportistas(List<Deportista> list_Deportistas) {
        this.list_Deportistas = list_Deportistas;
    }

    public void addDeportista(Deportista objetoR) {
        objetoR.setEntrenadorFK(this);
        this.list_Deportistas.add(objetoR);
    }

    // Relacion de 1-M entre (Entrenador --- Rutina)
    //Se Referencia al mapeo, con elnombre de la variable en la clase
    @OneToMany(mappedBy = "entrenadorFK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rutina> list_Rutinas;

    public List<Rutina> getList_Rutinas() {
        return list_Rutinas;
    }

    public void setList_Rutinas(List<Rutina> list_Rutinas) {
        this.list_Rutinas = list_Rutinas;
    }

    public void addRutina(Rutina objetoR) {
        objetoR.setEntrenadorFK(this);
        this.list_Rutinas.add(objetoR);
    }

}
