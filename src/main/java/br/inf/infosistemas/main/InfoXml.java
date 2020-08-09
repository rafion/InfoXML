/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.main;

import br.inf.infosistemas.dao.Conexao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import static java.sql.JDBCType.BLOB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SUPORTE02
 */
public class InfoXml {

    /**
     * @param args the command line arguments
     
    //public static void main(String[] args) throws SQLException, IOException {

        Statement statement = null;
        ResultSet rs = null;

        statement = Conexao.conectar().createStatement();
        // rs =  statement.executeQuery("select * from pdv_nfc");
        rs = statement.executeQuery("select * from xml_nfc where cast(data as date)='31.07.2020' and autorizacao<>'' ");

        while (rs.next()) {
            System.out.println("CHAVE: " + rs.getString("CHAVE"));
            System.out.println("DATA: " + rs.getDate("DATA"));
            //System.out.println("ARQUIVO: " + rs.getBlob("ARQUIVO"));
            String fileName = rs.getString("CHAVE");
            Blob mapBlob = rs.getBlob("ARQUIVO");
            byte[] arquivo = null;
            //String content =null;
            arquivo = mapBlob.getBytes(1, (int) mapBlob.length());

            // cria se o arquivo nao existir
            File file = new File(fileName + ".xml");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Arquivo Criado!");
            }

            FileOutputStream fos = new FileOutputStream(file);
            //fis = new FileInputStream(arquivo);
            fos.write(arquivo);
            //bytes2 = bytes;
            fos.close();

            /* Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Escreve e fecha arquivo
            bw.write(content);
            bw.close(); 
        }
    } */
    
   

}
