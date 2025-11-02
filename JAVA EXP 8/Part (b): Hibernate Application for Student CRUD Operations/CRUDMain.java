package com.example.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUDMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Student s1 = new Student("Ayush", "Java");
        session.save(s1);

        // READ
        Student s2 = session.get(Student.class, s1.getId());
        System.out.println("Read Student: " + s2.getName());

        // UPDATE
        s2.setCourse("Spring Boot");
        session.update(s2);

        // DELETE
        session.delete(s2);

        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
