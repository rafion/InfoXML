/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SUPORTE02
 */
public class WriteLog {
    
    public static void writeLog(String fileName, String info) {
    //String filename = "activity.log";
    //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    
    String FILENAME = fileName;
    //String FILENAME = "C:\\testing\\" + fileName;
    BufferedWriter bw = null;
    FileWriter fw = null;
    try {
        fw = new FileWriter(FILENAME, true);
        bw = new BufferedWriter(fw);
        bw.write( getCurrentTimeString()  + " - "+  info);
        bw.write("\n");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
    
    public static String getCurrentTimeString()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }
    
}
