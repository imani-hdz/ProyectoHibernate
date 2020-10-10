/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.proyectohibernate.Dao;

import com.test.proyectohibernate.modelo.Evaluaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Imani
 */
public class EvaluacionesDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public EvaluacionesDao (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
    public Evaluaciones fyndbyId(Evaluaciones s){
        em = getEntityManager();
        return em.find(Evaluaciones.class, s.getId());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT e from Evaluaciones e";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Evaluaciones> lista = query.getResultList();
        for (Evaluaciones p : lista){
        System.out.print(p + "\n");
        }
        
    }

    
    
    
    public void Insertar (Evaluaciones evaluaciones){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(evaluaciones);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (Evaluaciones evaluaciones){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(evaluaciones);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Evaluaciones evaluaciones){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(evaluaciones));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
}
