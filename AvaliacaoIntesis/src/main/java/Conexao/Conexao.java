/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;


/**
 *
 * @author Leonardo
 */
public class Conexao {
    
    private static String driver = "org.postgresql.Driver";
    private static String user = "postgres";
    private static String pass = "Nunes1403";
    private static String url = "jdbc:postgresql://localhost:5432/avaliacaoIntesis";
    


public static Connection getConnection(){
            
            try {
                Class.forName(driver);
                return DriverManager.getConnection(url, user, pass);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException("ERRO", ex);
            }
        }

public static void closeConnection(Connection conexao){
    try {
            if(conexao!=null){
            conexao.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão - " + ex.getMessage());
        }
    }

public static void closeConnection(Connection conexao, PreparedStatement stmt){
    closeConnection(conexao);
    try {
            if(stmt!=null){
            stmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão - " + ex.getMessage());
        }
    }


public static void closeConnection(Connection conexao, PreparedStatement stmt, ResultSet rs){
    closeConnection(conexao, stmt);
    try {
            if(rs!=null){
            rs.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão - " + ex.getMessage());
        }
    }
        
}
