package org.example;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.List;

public class App {
    static Logger logger = Logger.getLogger(App.class);
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myPersistenceUnit");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    public static void main(String[] args) {
        logger.info("The program has started");

        try {
            transaction.begin();
            CriteriaCRUD criteriaCRUD = new CriteriaCRUD();
            List<MemberInfo> results = criteriaCRUD.findMembersWithoutEntryByCar();

            for (MemberInfo result : results) {
                logger.info(result);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        logger.info("The program has finished");
    }
}
