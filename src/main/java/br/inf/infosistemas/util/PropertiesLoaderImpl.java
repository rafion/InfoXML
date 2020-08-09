/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.util;

/**
 *
 * @author SUPORTE02
 */
public class PropertiesLoaderImpl {
    
    private static PropertiesLoader loader = new PropertiesLoader();
    
    public static String getValor(String chave){
            return (String)loader.getValor(chave);
    }
    
}
