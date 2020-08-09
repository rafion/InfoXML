/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.main;

import br.inf.infosistemas.dao.Conexao;
import br.inf.infosistemas.interfaces.Config;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SUPORTE02
 */
public class ExportaXml {

    
    /*
    
    private static Runnable exporta = new Runnable() {
        @Override
        public void run() {

            try {

                Statement statement = null;
                ResultSet rs = null;

                statement = Conexao.conectar().createStatement();
                rs = statement.executeQuery("select * from xml_nfc where cast(data as date)='31.07.2020' and autorizacao<>'' ");
                //rs = statement.executeQuery("select * from xml_nfc where data between cast("+dataInicio+" as date) and cast("+dataFim+" as date) and autorizacao<>'' ");
                int total = 0;

                while (rs.next()) {
                    //System.out.println("CHAVE: " + rs.getString("CHAVE"));
                    //System.out.println("DATA: " + rs.getDate("DATA"));
                    String fileName = rs.getString("CHAVE");

                    Blob mapBlob = rs.getBlob("ARQUIVO");
                    byte[] arquivo = null;
                    arquivo = mapBlob.getBytes(1, (int) mapBlob.length());

                    // cria se o arquivo nao existir
                    File file = new File(path + "\\" + fileName + ".xml");
                    if (!file.exists()) {
                        file.createNewFile();

                        // System.out.println("Arquivo Criado!" + path + "\\" + fileName + ".xml");
                    }

                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(arquivo);
                    total++;

                    fos.close();

                }

                JOptionPane.showMessageDialog(null, "XML Exportados com sucesso!\nTotal de arquivos: " + total + "\nDiretorio: " + path);
                Conexao.desconectar();

            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nFalha. Tente outra vez.");

            }
        }
    };

    //quando for chamar na outra classe
    //ExportaXml exporta = new ExportaXml(construtor);
    //   exporta.main(new String[]{});
    //public void atualiza(int valor){ jProgressBarExportXml.setValue(valor); }
    public static void main(String[] args) {
        new Thread(exporta).start();
    }
*/
}
