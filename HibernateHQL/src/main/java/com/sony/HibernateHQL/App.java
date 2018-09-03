package com.sony.HibernateHQL;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Students.class);
        ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf=cfg.buildSessionFactory(registry);
        Session session=sf.openSession();
        
        double b=60;
        session.beginTransaction();
        Query q=session.createQuery("select sum(marks) from Students s where s.marks> :b");
        q.setParameter("b",b);
        Double marks=(Double) q.uniqueResult();
        System.out.println(marks);
        
//        List<Object[]> studs=q.list();
//        for(Object[] s:studs)
//        {
//        	System.out.println(s[0]+" : "+s[1]+" : "+s[2]);
//        }
////        Random r=new Random();
//        for(int i=1;i<=50;i++)
//        {
//        	Students s1=new Students();
//        	s1.setSid(i);
//        	s1.setSname("student"+i);
//        	s1.setMarks(r.nextInt(100));
//        	session.save(s1);
//        }
        
        session.getTransaction().commit();
    }
}
