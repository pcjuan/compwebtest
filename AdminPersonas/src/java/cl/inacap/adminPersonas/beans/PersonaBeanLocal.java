/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.adminPersonas.beans;

import cl.inacap.adminPersonas.modelo.Persona;
import javax.ejb.Local;
import java.util.*;

/**
 *
 * @author alumnossur
 */
@Local
public interface PersonaBeanLocal {

    Persona buscar(String rut);

    Persona loguear(String rut, String clave);

    void editar(String rut, boolean activo);

    List<Persona> getPersonaList();

    String agregarPersona(Persona persona);

    void businessMethod();

}
