/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author SUPORTE02
 */
public class PropertiesLoader {

    private Properties props;
    
    private String nomeDoProperties = "infoxml.properties";

    protected PropertiesLoader(){
            props = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream(nomeDoProperties); 
            try{
                    props.load(in);
                    in.close();
            }
            catch(IOException e){e.printStackTrace();}
    }

    protected String getValor(String chave){
            return (String)props.getProperty(chave);
    }
}