/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.adminPersonas.beans;

import cl.inacap.adminPersonas.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author alumnossur
 */
@Singleton
public class PersonaBean implements PersonaBeanLocal {

    private List<Persona> list = new ArrayList<>();

    public PersonaBean() {
        this.list.add(new Persona("16570113-5", "pcjuan@gmail.com", "admin", "Juan", 31, true, "1234"));
        this.list.add(new Persona("12345678-5", "pedro@gmail.com", "user", "Pedro", 31, false, "1234"));
        this.list.add(new Persona("11111111-1", "seba@gmail.com", "admin", "Sebita", 31, true, "1234"));
        this.list.add(new Persona("22222222-2", "daniel@gmail.com", "user", "DANIEL!", 31, true, "1234"));
    }

    @Override
    public Persona buscar(String rut) {
        for (Persona persona : this.list) {
            if (persona.getRut().equals(rut)) {
                return persona;
            }
        }
        return null;
    }

    @Override
    public Persona loguear(String rut, String clave) {
        for (Persona persona : this.list) {
            if (persona.getRut().equals(rut) && persona.getClave().equals(clave)) {
                return persona;
            }
        }
        return null;
    }

    @Override
    public void editar(String rut, boolean activo) {
        Persona persona = buscar(rut);
        persona.setActivo(activo);
    }

    @Override
    public List<Persona> getPersonaList() {
        return this.list;
    }

    @Override
    public String agregarPersona(Persona persona) {
        Persona p = buscar(persona.getRut());

        if (p != null) {
            this.list.add(persona);
            return "Persona creada con exito";
        } else {
            return "Rut ya se encuentra registrado";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
