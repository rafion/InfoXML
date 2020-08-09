/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.dao;

/**
 *
 * @author SUPORTE02
 */
import br.inf.infosistemas.util.PropertiesLoaderImpl;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    

    private static Connection conexao;
    
     
    

    public static Connection conectar() throws IOException {
        try {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }

           
           String host = PropertiesLoaderImpl.getValor("host");
           String porta = PropertiesLoaderImpl.getValor("porta");
           String database = PropertiesLoaderImpl.getValor("database");
           String user = PropertiesLoaderImpl.getValor("user");
           String password = PropertiesLoaderImpl.getValor("password");
           String url = PropertiesLoaderImpl.getValor("url");
            
            conexao = DriverManager.getConnection(
                    "jdbc:firebirdsql:" + url,
                    user,
                    password);
            
            
           // JOptionPane.showMessageDialog(null, "Conexão firebird realizada com sucesso");
           // System.out.println(url);
            
            return conexao;

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Conexão firebird falhou!");
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

   /* public static void main(String[] args) throws ClassNotFoundException {
        Conexao.conectar();
    } */
}
