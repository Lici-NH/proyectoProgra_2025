/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_progra2025pp;

/**
 *
 * @author ALIS
 */
public class Ticket {
    private int idT;
    private String descripcion;

    public Ticket(int idT, String descripcion) {
        this.idT = idT;
        this.descripcion = descripcion;
    }

    public int getId() {
        return idT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Ticket #" + idT + ": " + descripcion;
    }
}
 
    
