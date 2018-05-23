/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.Asistencia;
import DatoClases.Chequeo;
import DatoClases.Deportes;
import DatoClases.Deportista;
import DatoClases.Entrenador;
import DatoClases.TiempoEntreno;
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
@XmlRootElement(name = "DeportistaDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeportistaDTO {

    private int ID_Deportista;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int cedula;
    private String ciudad;
    private String categoria;
    private String password;
    private DeportesDTO deporteFK;
    private EntrenadorDTO entrenadorFK;
    private List<TiempoCompDTO> list_Tiempo_Competencias;
    private List<ChequeoDTO> list_Chequeos;
    private List<AsistenciaDTO> list_Asistencias;
    private List<TiempoEntrenoDTO> list_Tiempo_Entrenamientos;

    public DeportistaDTO() {
    }

    public DeportistaDTO(Deportista objCL) {
        this.ID_Deportista = objCL.getID_Deportista();
        this.nombre = objCL.getNombre();
        this.apellido = objCL.getApellido();
        this.fechaNacimiento = objCL.getFechaNacimiento();
        this.cedula = objCL.getCedula();
        this.ciudad = objCL.getCiudad();
        this.categoria = objCL.getCategoria();
        this.password = objCL.getPassword();
        this.deporteFK = new DeportesDTO(objCL.getDeporteFK());
        this.entrenadorFK = new EntrenadorDTO(objCL.getEntrenadorFK());
        this.list_Tiempo_Competencias = new ArrayList<TiempoCompDTO>();
        this.list_Chequeos = new ArrayList<ChequeoDTO>();
        this.list_Asistencias = new ArrayList<AsistenciaDTO>();
        this.list_Tiempo_Entrenamientos = new ArrayList<TiempoEntrenoDTO>();
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

    public EntrenadorDTO getEntrenadorFK() {
        return entrenadorFK;
    }

    public void setEntrenadorFK(EntrenadorDTO entrenadorFK) {
        this.entrenadorFK = entrenadorFK;
    }

    public List<TiempoCompDTO> list_Tiempo_Competencias(List<Tiempo_Competencia> list_Tiempo_Competencias) {
        for (Tiempo_Competencia list_Tiempo_Competencia : list_Tiempo_Competencias) {
            TiempoCompDTO compDTO = new TiempoCompDTO(list_Tiempo_Competencia);
            this.list_Tiempo_Competencias.add(compDTO);
        }
        return this.list_Tiempo_Competencias;
    }

    public List<ChequeoDTO> list_Chequeos(List<Chequeo> list_Chequeos) {
        for (Chequeo list_Chequeo : list_Chequeos) {
            ChequeoDTO cdto = new ChequeoDTO(list_Chequeo);
            this.list_Chequeos.add(cdto);
        }
        return this.list_Chequeos;
    }

    public List<TiempoEntrenoDTO> list_Tiempo_Entrenamientos(List<TiempoEntreno> list_Tiempo_Entrenamientos) {
        for (TiempoEntreno list_Tiempo_Entrenamiento : list_Tiempo_Entrenamientos) {
            TiempoEntrenoDTO dTO = new TiempoEntrenoDTO(list_Tiempo_Entrenamiento);
            this.list_Tiempo_Entrenamientos.add(dTO);
        }
        return this.list_Tiempo_Entrenamientos;
    }

    public List<AsistenciaDTO> list_Asistencias(List<Asistencia> list_Asistencias) {
        for (Asistencia list_Asistencia : list_Asistencias) {
            AsistenciaDTO adto = new AsistenciaDTO(list_Asistencia);
            this.list_Asistencias.add(adto);
        }
        return this.list_Asistencias;
    }

}
