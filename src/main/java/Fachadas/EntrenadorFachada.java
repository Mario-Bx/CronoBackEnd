/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.Entrenador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class EntrenadorFachada extends ServiceImpl<Entrenador> {

    public EntrenadorFachada() throws ConexionException {
        super(Entrenador.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en Deporte Fachada");
        }
    }

    @Override
    public List<Entrenador> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
