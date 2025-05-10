/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_progra2025pp;
import java.util.LinkedList;
import java.util.Queue;
//Cola de Tickets
/**
 *
 * @author ALIS
 */
public class Cola_tickets {
    
    private Queue<Ticket> colaTickets = new LinkedList<>();
    private int contadorId = 1;

    public void agregarTicket(String descripcion) {
        Ticket nuevo = new Ticket(contadorId++, descripcion);
        colaTickets.add(nuevo);
        System.out.println("Ticket agregado: " + nuevo);
    }

    public Ticket atenderTicket() {
        Ticket atendido = colaTickets.poll();
        if (atendido != null) {
            System.out.println("Atendiendo " + atendido);
        } else {
            System.out.println("No hay tickets por atender.");
        }
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("Cola de tickets:");
        for (Ticket t : colaTickets) {
            System.out.println(" - " + t);
        }
    }
}


