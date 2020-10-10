/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.proyectohibernate.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Imani
 */

@Entity
@Table(name="evaluaciones")

public class Evaluaciones implements Serializable{
    
    @Id
    @SequenceGenerator(name="eva_sec", sequenceName="sec_evaluaciones", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="eva_sec")
    @Column(name="id")
    private Integer id;
    
    @Column (name="nombres")
    private String nombres;

    @Column (name="apellidos")
    private String apellidos;

    @Column (name="materia")
    private String materia;

    @Column (name="nota")
    private Double nota;

    @Column (name="estado")
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Salario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", materia=" + materia + ", nota=" + nota + ", estado=" + estado + '}';
    }

    
}
