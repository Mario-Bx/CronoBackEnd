package PruebaEjecucion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DaoGenerico.ConexionException;
import DatoClases.*;
import Fachadas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARIO
 */
public class Ejecucion {

    public static void main(String[] args) throws ConexionException {

////////Crear Deporte        
////        Deportes deportes = new Deportes("Futbol", "balon pie");
//        DeportesFachada deportesFachada = new DeportesFachada();
////        deportesFachada.crearObj(deportes);
////        
/////// Creacion de evento
//        EventoClas eventoClas = new EventoClas("Aletas", "Mundia", "2018-03-08", "Rusia");
////        
//        Deportes deportes1 = new Deportes();
////        deportes1 = deportesFachada.busacarObj(3);
////        deportes1.addEvento(eventoClas);
////        deportesFachada.actualizarObj(deportes1);
//
//////Asignar Entrenador de deporte
//        Entrenador entrenador = new Entrenador("Yeraldin", "Diaz", "2018-03-15", 12345, "Bogota", "Motos");
//        deportes1 = deportesFachada.busacarObj(6);
////        deportes1.addEntrenador(entrenador);
////        deportesFachada.actualizarObj(deportes1);
//
////// Asignar Deportista (Entrenador y Deporte)
//        Deportista deportista = new Deportista("CAmilo", "suarez", "2018-03-15", 12345, "Bogota", "S10", "Carros");
//
//        deportes1 = deportesFachada.busacarObj(6);
//        EntrenadorFachada entrenadorFachada = new EntrenadorFachada();
//        Entrenador entrenador1 = new Entrenador();
//        entrenador1 = entrenadorFachada.busacarObj(4);
//
//        deportista.setEntrenadorDeportista(entrenador1);
//        deportista.setDeportesDeportista(deportes1);
//
//        DeportistaFachada deportistaFachada = new DeportistaFachada();
////        deportistaFachada.crearObj(deportista);
//
//////Asignar tiempo de competencia;
//        EventoClasFachada eventoClasFachada = new EventoClasFachada();
//        eventoClas = eventoClasFachada.busacarObj(1);
//
//        deportista = deportistaFachada.busacarObj(1);
//        Tiempo_Competencia tiempo_Competencia = new Tiempo_Competencia("Espalda", 100, "01:21:33", deportista.getCategoria());
//        tiempo_Competencia.setEventoTienpoC(eventoClas);
//
//        TiempooCompFachada tiempooCompFachada = new TiempooCompFachada();
////        tiempooCompFachada.crearObj(tiempo_Competencia);
//        tiempo_Competencia = tiempooCompFachada.busacarObj(2);
//        tiempo_Competencia.setDeportistaTiempoC(deportista);
////        tiempooCompFachada.actualizarObj(tiempo_Competencia);
//
//        ////Asgnar Chequeo
//        Chequeo chequeo = new Chequeo("Espalda", 100, "01:21:33");
//        deportista.addChequeo(chequeo);
////        deportistaFachada.actualizarObj(deportista);
//
///////Asistencias
//        Asistencia asistencia = new Asistencia("2018-03-15", "Mañana");
//        AsistenciaFachada asistenciaFachada = new AsistenciaFachada();
//        asistencia = asistenciaFachada.busacarObj(3);
//
//        Deportista deportista3 = new Deportista();
//        deportista3 = DeportistaFachada.busacarObj(4);
////
//        asistencia.setDeportistaAsistencia(deportista3);
////        asistenciaFachada.actualizarObj(asistencia);
//
//
///////Rutinas
//Rutina rutina = new Rutina(5, 200, "Combinado", "2018-03-15", asistencia.getJornada());
//entrenador = entrenadorFachada.busacarObj(8);
////entrenador.addRutina(rutina);
////entrenadorFachada.actualizarObj(entrenador);
//
//
//
/////tiempo entrenamiento
//        TiempoEntreno tiempoEntreno = new TiempoEntreno("00:55:88", "00:50:50", "00:10:10", 2);
//
//        RutinaFachada rutinaFachada = new RutinaFachada();
//        Rutina rutina = rutinaFachada.busacarObj(1);
//        tiempoEntreno.setRutinaFK(rutina);
//
//        DeportistaFachada deportistaFachada = new DeportistaFachada();
//        Deportista deportista = deportistaFachada.busacarObj(1);
//        tiempoEntreno.setDeportistaFK(deportista);
//
//        TiempoEntFachada tiempoEntFachada = new TiempoEntFachada();
////        tiempoEntFachada.crearObj(tiempoEntreno);
//
//        tiempoEntreno = tiempoEntFachada.busacarObj(2);
//        System.out.println(tiempoEntreno.toString());
//        
//        tiempoEntreno.setTiempoexigencia("55:55:55");
//        tiempoEntFachada.actualizarObj(tiempoEntreno);

        Deportes d = new Deportes();
        DeportesFachada deportesFachada = new DeportesFachada();

        d = deportesFachada.busacarObj(1);
        System.out.println(d);

        System.out.println(d.getList_Entrenadores().get(0));

        List<Entrenador> list_Entrenadores = d.getList_Entrenadores();
        System.out.println(list_Entrenadores.toString());
    }

}
