/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaEjecucion;

import DatoClases.Deportes;
import Fachadas.ConexionException;
import Fachadas.DeportesFachada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARIO
 */
public class Pruebas {

    public static void main(String[] args) throws ConexionException {
//        String s = "01:10:87";
//        String miliseg ="";
//        String seg="";
//        String minu="";
//        
//        miliseg= Character.toString(s.charAt(6))+Character.toString(s.charAt(7));
//        seg= Character.toString(s.charAt(3))+Character.toString(s.charAt(4));
//        minu= Character.toString(s.charAt(0))+Character.toString(s.charAt(1));
//        
//        int i = Integer.parseInt(miliseg);
//        int j = Integer.parseInt(seg);
//        int k = Integer.parseInt(minu);
//        
//        double d = 0.01*i + j + k*60;
//        System.out.println(d);

        DeportesFachada deportesFachada = new DeportesFachada();

//        List<Deportes> DeList = new ArrayList();
//        DeList = deportesFachada.buscarTodoObj();
//
//        List<String> listNombres = new ArrayList<String>();
//        List<String> listTiempos = new ArrayList<String>();
//
//        for (int i = 0; i < DeList.size(); i++) {
//            listNombres.add(DeList.get(i).getNombre());
//        }

//        System.out.println(listNombres);
    }
}
