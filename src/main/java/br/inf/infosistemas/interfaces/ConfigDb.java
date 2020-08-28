/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author SUPORTE02
 */
public class ConfigDb implements Serializable {
    //do acesso ao banco

    private String host;
    private String port;
    private String dataBaseFile;
    private String admUserNameDb;
    private String password;
    private String urlDb;
    private Boolean rememberPassword;

    public ConfigDb() {
    }

    public ConfigDb(String host, String port, String dataBaseFile, String admUserNameDb, String password, String urlDb, Boolean rememberPassword) {
        this.host = host;
        this.port = port;
        this.dataBaseFile = dataBaseFile;
        this.admUserNameDb = admUserNameDb;
        this.password = password;
        this.urlDb = urlDb;
        this.rememberPassword = rememberPassword;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDataBaseFile() {
        return dataBaseFile;
    }

    public void setDataBaseFile(String dataBaseFile) {
        this.dataBaseFile = dataBaseFile;
    }

    public String getAdmUserNameDb() {
        return admUserNameDb;
    }

    public void setAdmUserNameDb(String admUserNameDb) {
        this.admUserNameDb = admUserNameDb;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlDb() {
        return urlDb;
    }

    public void setUrlDb(String urlDb) {
        this.urlDb = urlDb;
    }

    public Boolean getRememberPassword() {
        return rememberPassword;
    }

    public void setRememberPassword(Boolean rememberPassword) {
        this.rememberPassword = rememberPassword;
    }

    public void salvar() {

        
            try {
                ObjectOutputStream arquivoGravar = new ObjectOutputStream(new FileOutputStream(new File("configDb.dat")));
                arquivoGravar.writeObject(this); //aqui entra o objeto
                JOptionPane.showMessageDialog(null, "Configuração gravada com sucesso");
            } catch (IOException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar os dados no aquivo configDb.dat, erro: " + erro);
            }
        } 
    
   public static ConfigDb carregarConfigDb() throws FileNotFoundException, IOException, ClassNotFoundException {
         ConfigDb conf = new ConfigDb();
         try {
             ObjectInputStream configLer = new ObjectInputStream(new FileInputStream("configDb.dat"));
            
           
            conf = (ConfigDb) configLer.readObject();
            return conf;
            
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Erro de classe erro = " + erro);
        } catch (FileNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "O arquivo de configuração: configDb.dat não foi encontrado.\nO sistema vai tentar conectar em:\n C:\\info Sistemas\\dados\\docsxml.fdb");

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler dados no arquivo de configurção: configDb.dat erro= " + erro);
        }
         
         
         return null;
   } 

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
