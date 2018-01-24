/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.adminPersonas.modelo;

/**
 *
 * @author sarayar
 */
public class Persona {

    private String rut;
    private String mail;
    private String perfil;
    private String nombre;
    private int edad;
    private boolean activo;
    private String clave;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Persona() {
    }

    public Persona(String rut, String mail, String perfil, String nombre, int edad, boolean activo, String clave) {
        this.rut = rut;
        this.mail = mail;
        this.perfil = perfil;
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
