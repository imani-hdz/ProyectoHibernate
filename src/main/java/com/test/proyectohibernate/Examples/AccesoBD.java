/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.proyectohibernate.Examples;

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
public class AccesoBD {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public AccesoBD (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
}
    
  private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
  
 public void consultar(){
    em = getEntityManager();
    String sql = "SELECT * FROM Evaluaciones";
    Query query = em.createNativeQuery(sql,Evaluaciones.class);
    List<Evaluaciones> lista = query.getResultList();
    for (Evaluaciones p : lista){
        System.out.print(p + "\n");
        }
    }
    
    
    public void Insertar(Integer id, String nombres, String apellidos, String materia, Double nota, String estado){
        
        try{
        em=getEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO EVALUACIONES(ID,NOMBRES,APELLIDOS,MATERIA,NOTA,ESTADO)VALUES(?,?,?,?,?,?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, id);
        query.setParameter(2, nombres);
        query.setParameter(3, apellidos);
        query.setParameter(4, materia);
        query.setParameter(5, nota);
        query.setParameter(6, estado);
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Inserción de registro de evaluación fue un exito");
    
        }catch(Exception ex){
        System.out.println("Sucedio un error en el programa " + ex.getMessage());
        
        
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
    
    
    }
  
    public void actualizar(String nombres, String apellidos, String materia, Double nota, String estado, Integer id){
        try{ 
            em=getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE EVALUACIONES SET NOMBRES=?,APELLIDOS=?,MATERIA=?,NOTA=?,ESTADO=? WHERE ID=?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, nombres);
            query.setParameter(2, apellidos);
            query.setParameter(3, materia);
            query.setParameter(4, nota);
            query.setParameter(5, estado);
            query.setParameter(7, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Actualización de registro de evaluaciones fue un exito");
    
        }catch(Exception ex){
            System.out.println("Sucedio un error en el programa " + ex.getMessage());
                
        }finally{
        if(em !=null){
            em.close();
            
            }
                      
        }
    
    }
    
  
 
    public void eliminar(Integer id) {
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "DELETE FROM EVALUACIONES WHERE ID = ?";
            Query query = em.createNativeQuery(sql).setParameter(1, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Borrado de Registro de evaluación satisfactorio");
           
        }catch(Exception ex){
            
            System.out.println("Sucedio un error en el programa"+ex.getMessage());
       
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
             
        
    }


}
