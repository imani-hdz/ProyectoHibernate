/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.proyectohibernate.Operations;

import com.test.proyectohibernate.Dao.EvaluacionesDao;
import com.test.proyectohibernate.modelo.Evaluaciones;
import java.util.Scanner;

/**
 *
 * @author Imani
 */
public class OperHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EvaluacionesDao evaluaciones = new EvaluacionesDao();
        
        Evaluaciones p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, nombres, apellidos, materia, estado;
        Double nota; 

        
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Evaluaciones" + 
          "\n2.-Buscar evaluación por Id\n" +
                    "3.-Agregar un nuevo registro de evaluación\n" +
                    "4.-Modificar un registro\n"+
                    "5.-Eliminar un registro\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    evaluaciones.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar evaluacion por Id***********");
                    System.out.println("Introduce el Id del registro de evaluación a buscar:");
                    id = entrada.nextLine();
                    p1 = new Evaluaciones();
                    p1.setId(new Integer(id));
                    p1 = evaluaciones.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los nombres de la persona a agregar al registro");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce los apellidos de la persona a agregar");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la materia de la persona a agregar");
                    materia = entrada.nextLine();
                    
                    System.out.println("Introduce la nota correspondiente");
                    nota = Double.parseDouble(entrada.nextLine());
        
                    System.out.println("Introduce el estado (1/0) correspondiente");
                    estado = entrada.nextLine();
                                  
                    p1 = new Evaluaciones();
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setMateria(materia);
                    p1.setNota(nota);
                    p1.setEstado(estado);
                    evaluaciones.Insertar(p1);
                    break;

                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id de persona a modificar en el registro de evaluaciones");
                    id = entrada.nextLine();
                    p1= new Evaluaciones();
                    p1.setId(new Integer(id));
                    evaluaciones.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre de la persona a modificar en el registro");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce el apellido de la persona");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la materia asociada para modificar en el registro");
                    materia = entrada.nextLine();
                    
                    System.out.println("Introduce la nota correspondiente ");
                    nota = Double.parseDouble(entrada.nextLine());
        
                    System.out.println("Introduce el estado (1/0) correspondiente ");
                    estado = entrada.nextLine();
                    
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setMateria(materia);
                    p1.setNota(nota);
                    p1.setEstado(estado);
                    evaluaciones.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id de la persona a eliminar en el registro de evaluaciones");
                    id= entrada.nextLine();
                    p1 = new Evaluaciones();
                    p1.setId(new Integer(id));
                    p1 = evaluaciones.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    evaluaciones.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        } 
    }
    
}
