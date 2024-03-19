import entity.Customer;
import entity.Major;
import entity.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void init(EntityManager em){
        Student stu1 = new Student("김씨","1학년");
        Student stu2 = new Student("이씨","2학년");
        Student stu3 = new Student("박씨","3학년");
        Major m1 = new Major("컴싸","소프트엔지니어링");
        em.persist(m1); //@id --> mysql auto_increment : persist 해올때 insert 쿼리문을 날려서 id 값을 받아온다

//        stu1.setMajorId(m1.getMajorId());
//        stu2.setMajorId(m1.getMajorId());
//        stu3.setMajorId(m1.getMajorId());
        stu1.setMajor(m1);
        stu2.setMajor(m1);
        stu3.setMajor(m1);

        em.persist(stu1);
        em.persist(stu2);
        em.persist(stu3);

    }

    public static void main(String[] args) {
        // 객체 sessitonFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-ex");
        EntityManager em = emf.createEntityManager(); // session 객체
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // start transction;
        try {
             // init(em);
//
            Student findStudent = em.find(Student.class,1L);
            System.out.println("findStudent = " + findStudent);
            
            Major major = findStudent.getMajor();
            System.out.println("major.getCategory() = " + major.getCategory());

//            Major findMajor = em.find(Major.class, findStudent.getMajor());
//            System.out.println("findMajor = " + findMajor);


            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
            emf.close();
        }

    }
}
