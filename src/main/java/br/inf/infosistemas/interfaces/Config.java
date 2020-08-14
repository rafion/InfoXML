/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.infosistemas.interfaces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author SUPORTE02
 */
public class Config implements Serializable {
   //da tela inicial 
   private String path;
   private String hora;
   private Boolean nfc = false;
   private Boolean nfe = false;
   private Boolean entradas= false;
   private Date dataInicio;
   private Date dataFim;
   
  
    
    Config() {
        
    }

    public Config(String patch, String hora) {
        this.path = patch;
        this.hora = hora;
    }

    public Config(String path, String hora, Boolean nfc, Boolean nfe, Boolean entradas) {
        this.path = path;
        this.hora = hora;
        this.nfc = nfc;
        this.nfe = nfe;
        this.entradas = entradas;
    }

    public Config(String path, String hora, Boolean nfc, Boolean nfe, Boolean entradas, Date dataInicio, Date dataFim) {
        this.path = path;
        this.hora = hora;
        this.nfc = nfc;
        this.nfe = nfe;
        this.entradas = entradas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    

    
    public String getPatch() {
        return path;
    }

    public void setPatch(String patch) {
        this.path = path;
    }

    public String getHoraExportacao() {
        return hora;
    }

    public void setHoraExportacao(String hora) {
        this.hora = hora;
    }

    public Boolean getNfc() {
        return nfc;
    }

    public void setNfc(Boolean nfc) {
        this.nfc = nfc;
    }

    public Boolean getNfe() {
        return nfe;
    }

    public void setNfe(Boolean nfe) {
        this.nfe = nfe;
    }

    public Boolean getEntradas() {
        return entradas;
    }

    public void setEntradas(Boolean entradas) {
        this.entradas = entradas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    public void salvar(){
        try {
            ObjectOutputStream arquivoGravar = new ObjectOutputStream(new FileOutputStream(new File("infoxml.dat")));
            arquivoGravar.writeObject(this); //aqui entra o objeto
            JOptionPane.showMessageDialog(null, "Configuração gravada com sucesso");
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gravar os dados no aquivo infoxml.dat, erro: " + erro);
        }
    }
    
}
