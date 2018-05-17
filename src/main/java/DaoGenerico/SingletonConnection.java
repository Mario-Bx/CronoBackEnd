/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fabian Giraldo
 */
public class SingletonConnection {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    private static void initConnection() {
        emf = Persistence.createEntityManagerFactory("CronoJpa");
    }

    public static EntityManager getConnection() {
        if (em == null) {

            initConnection();
            em = emf.createEntityManager();
            em.getTransaction().begin();
        }
        return em;
    }

    public static void closeEmf() {
        if (emf.isOpen() || emf != null) {
            em.close();
            emf.close();
        }
        emf = null;
    }
}
