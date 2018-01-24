/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.model;

/**
 *
 * @author sarayar
 */
public class Persona {
    private String nombre;
    private String rut;
    private String perfil;
    private String mail;
    private String clave;
    private boolean activo;

    public Persona() {
    }

    public Persona(String nombre, String rut, String perfil, String mail, String clave, boolean activo) {
        this.nombre = nombre;
        this.rut = rut;
        this.perfil = perfil;
        this.mail = mail;
        this.clave = clave;
        this.activo = activo;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
