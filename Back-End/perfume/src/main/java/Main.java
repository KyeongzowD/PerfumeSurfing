import SearchPerfume.*;

import javax.persistence.*;

public class Main {

    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");

        EntityManager em=emf.createEntityManager();

        EntityTransaction tx= em.getTransaction();
        tx.begin();

        try{
            System.out.println("test");
            Brand brand=new Brand();
            brand.setName("르라보");
            em.persist(brand);

            Perfume perfume=new Perfume();
            perfume.setName("떼 마차");
            perfume.setBrand(brand);
            em.persist(perfume);

            Perfume p=em.find(Perfume.class, perfume.getBrand());
            System.out.println("p: "+p.getBrand().getName());

            em.flush();
            em.clear();

            tx.commit();
            System.out.println("test");

        }catch(Exception e){
            System.out.println("test");

            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

}
