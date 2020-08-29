/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.util;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SUPORTE02
 */
public class LogToFile {

    protected static final Logger logger=Logger.getLogger("MYLOG");
    /**
     * log Method 
     * enable to log all exceptions to a file and display user message on demand
     * @param ex
     * @param level
     * @param msg 
     */
    public static void log(Exception ex, String level, String msg){

        FileHandler fh = null;
        try {
            fh = new FileHandler("LogInfo.xml",true);
            logger.addHandler(fh);
            switch (level) {
                case "severe":
                    logger.log(Level.SEVERE, msg, ex);
                    if(!msg.equals(""))
                      //  JOptionPane.showMessageDialog(null,msg,
                       //     "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case "warning":
                    logger.log(Level.WARNING, msg, ex);
                    if(!msg.equals(""))
                      //  JOptionPane.showMessageDialog(null,msg,
                      //      "Warning", JOptionPane.WARNING_MESSAGE);
                    break;
                case "info":
                    logger.log(Level.INFO, msg, ex);
                    if(!msg.equals(""))
                      //  JOptionPane.showMessageDialog(null,msg,
                       //     "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "config":
                    logger.log(Level.CONFIG, msg, ex);
                    break;
                case "fine":
                    logger.log(Level.FINE, msg, ex);
                    break;
                case "finer":
                    logger.log(Level.FINER, msg, ex);
                    break;
                case "finest":
                    logger.log(Level.FINEST, msg, ex);
                    break;
                default:
                    logger.log(Level.CONFIG, msg, ex);
                    break;
            }
        } catch (IOException | SecurityException ex1) {
            logger.log(Level.SEVERE, null, ex1);
        } finally{
            if(fh!=null)fh.close();
        }
    }
}