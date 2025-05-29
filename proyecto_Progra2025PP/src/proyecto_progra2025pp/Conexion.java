/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_progra2025pp;
/*import com.sun.jdi.connect.spi.Connection;
import org.postgresql.ds.PGSimpleDataSource; //org.postgresql.ds.PGSimplemenDataSource;
*/

import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ALIS
 */
public class Conexion {
 
   private static final PGSimpleDataSource ds = new PGSimpleDataSource();
   
   static {
   ds.setServerNames(new String[] {"ep-muddy-mode-a8q9qrpf-pooler.eastus2.azure.neon.tech"});
   ds.setDatabaseName("Sistema Gestor de Tickets");
   ds.setUser("neondb_owner");
   ds.setPassword("'npg_UD8oxpfsd3Oq'");
   ds.setSsl(true);
   }
   
   public static Connection getConexion() throws SQLException {
   return ds.getConnection();
   }

 
    }

