/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_progra2025pp;
import com.sun.jdi.connect.spi.Connection;
import org.postgresql.ds.PGSimpleDataSource; //org.postgresql.ds.PGSimplemenDataSource;
/**
 *
 * @author ALIS
 */
public class Conexion {
 
   private static PGSimpleDataSource ds = new PGSimpleDataSource();
   
   static {
   ds.setServerNames(new String[] {"ep-muddy-mode-a8q9qrpf-pooler.eastus2.azure.neon.tech"});
   ds.setDatabaseName("Sistema Gestor de Tickets");
   ds.setUser("neondb_owner");
   ds.setPassword("'npg_UD8oxpfsd3Oq'");
   
   }
   
   public static Connection getConexion() throws SQLException, java.sql.SQLException {
   return (Connection) ds.getConnection();
   }

    private static class SQLException extends Exception {

        public SQLException() {
        }
    }
}
