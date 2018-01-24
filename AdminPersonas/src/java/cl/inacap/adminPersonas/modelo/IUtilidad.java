/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.adminPersonas.modelo;

import java.util.List;

/**
 *
 * @author sarayar
 */
public interface IUtilidad {
    Persona loguear(String nombre, String clave, List<Persona> lista);
}
