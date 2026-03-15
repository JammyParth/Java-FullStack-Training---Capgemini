package com.capg.lpu.util;

import javax.persistence.*;

public class JPAUtil {

    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("crmPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}