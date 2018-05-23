/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Asistencia;
import DatoClases.Deportes;
import DatoClases.Deportista;
import DatoClases.Entrenador;
import DatoClases.Rutina;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "EntrenadorDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntrenadorDTO {

    private int ID_Entrenador;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int cedula;
    private String ciudad;
    private String password;
    private DeportesDTO deporteFK;
    private List<AsistenciaDTO> list_Asistencias;
    private List<DeportistaDTO> list_Deportistas;
    private List<RutinaDTO> list_Rutinas;

    public EntrenadorDTO() {
    }

    public EntrenadorDTO(Entrenador objCL) {
        this.ID_Entrenador = objCL.getID_Entrenador();
        this.nombre = objCL.getNombre();
        this.apellido = objCL.getApellido();
        this.fechaNacimiento = objCL.getFechaNacimiento();
        this.cedula = objCL.getCedula();
        this.ciudad = objCL.getCiudad();
        this.password = objCL.getPassword();
        this.deporteFK = new DeportesDTO(objCL.getDeporteFK());
        this.list_Asistencias = new ArrayList<AsistenciaDTO>();
        this.list_Deportistas = new ArrayList<DeportistaDTO>();
        this.list_Rutinas = new ArrayList<RutinaDTO>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DeportesDTO getDeporteFK() {
        return deporteFK;
    }

    public void setDeporteFK(DeportesDTO deporteFK) {
        this.deporteFK = deporteFK;
    }

    public List<AsistenciaDTO> list_Asistencias(List<Asistencia> list_Asistencias) {
        for (Asistencia list_Asistencia : list_Asistencias) {
            AsistenciaDTO adto = new AsistenciaDTO(list_Asistencia);
            this.list_Asistencias.add(adto);
        }
        return this.list_Asistencias;
    }

    public List<DeportistaDTO> list_Deportistas(List<Deportista> list_Deportistas) {
        for (Deportista list_Deportista : list_Deportistas) {
            DeportistaDTO dTO = new DeportistaDTO(list_Deportista);
        }
        return this.list_Deportistas;
    }

    public List<RutinaDTO> list_Rutinas(List<Rutina> list_Rutinas) {
        for (Rutina list_Rutina : list_Rutinas) {
            RutinaDTO dTO = new RutinaDTO(list_Rutina);
            this.list_Rutinas.add(dTO);
        }

        return this.list_Rutinas;
    }

}
