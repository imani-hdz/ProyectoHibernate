/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.proyectohibernate.Examples;

/**
 *
 * @author Imani
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoBD select = new AccesoBD(); //Instanciamos el objeto que maneja las operaciones sobre la base de datos
         select.consultar();
    }
    
}
