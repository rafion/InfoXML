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
import br.inf.infosistemas.interfaces.ConfigDb;
import br.inf.infosistemas.util.PropertiesLoaderImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection conexao;

    public static Connection conectar() throws IOException, ClassNotFoundException {
        try {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }

            /*ler aquivo .dat
            ObjectInputStream configLer = new ObjectInputStream(new FileInputStream("infoxml.dat"));
            config = (Config) configLer.readObject();*/
            
            
            String host = null;
            String porta = null;
            String database = null;
            String user = null;
            String password = null;
            String url = null;
           
            //se o arquivo existir carrega conexão por ele, se não carrega do properties
          ConfigDb config = ConfigDb.carregarConfigDb();
            if (config !=null ) {
                host=config.getHost();
                porta=config.getPort();
                database = config.getDataBaseFile();
                user = config.getAdmUserNameDb();
                password = config.getPassword();
                url = config.getUrlDb();
               // JOptionPane.showMessageDialog(null, "load configdb: " + host +"\n" + porta +"\n"+ database +"\n"+ user +"\n"+password +"\n"+ url);
            
                conexao = DriverManager.getConnection(
                    "jdbc:firebirdsql:" + host + "/" + porta + ":" + database,
                    user,
                    password);
            
            
            } else {
            
            
            host = PropertiesLoaderImpl.getValor("host");
            porta = PropertiesLoaderImpl.getValor("porta");
            database = PropertiesLoaderImpl.getValor("database");
            user = PropertiesLoaderImpl.getValor("user");
            password = PropertiesLoaderImpl.getValor("password");
            url = PropertiesLoaderImpl.getValor("url");
           // JOptionPane.showMessageDialog(null, "load proprietes: " + host +"\n" + porta +"\n"+ database +"\n"+ user +"\n"+password +"\n"+ url);
            
            conexao = DriverManager.getConnection(
                    "jdbc:firebirdsql:" + url,
                    user,
                    password);
            
            }
            
           
            
            
            

            // JOptionPane.showMessageDialog(null, "load proprietes: " + host +"\n" + porta +"\n"+ database +"\n"+ user +"\n"+password +"\n"+ url);
            //ConfigDb configdb = new ConfigDb();
            
            
            /* */

            // JOptionPane.showMessageDialog(null, "Conexão firebird realizada com sucesso " + url);
            // System.out.println(url);
            return conexao;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexão firebird falhou!\n"
                    + "Verifique se o banco esta em:\n"
                    + "C:\\info Sistemas\\dados\\DOCSXML.FDB");
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
