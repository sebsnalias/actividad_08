/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewBloc;
import models.ModelBloc;
/**
 *LLamar y enviar variables a la interfaz
 * @author Sebastián
 */
public class ControllerBloc implements ActionListener {
    ModelBloc modelBloc;
    ViewBloc viewCBloc;
    public ControllerBloc(ViewBloc viewCBloc, ModelBloc modelBloc){
        this.viewCBloc = viewCBloc;
        this.modelBloc = modelBloc;
        this.viewCBloc.jmi_guardar.addActionListener(this);
        this.viewCBloc.jmi_leer.addActionListener(this);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCBloc.jmi_leer){
            read();
        } 
        else if(e.getSource() == viewCBloc.jmi_guardar){
            save();
        }
    }
    /**
     * llama un metodo readFile de model a controller
     */
    public void read(){
        modelBloc.readFile();
        viewCBloc.jta_texto.setText(modelBloc.getMessage());
    }
    /**
     * llama un metodo setMessage de model a controller para guardoar cambios en el documento
     */
    public void save(){
        modelBloc.setMessage(viewCBloc.jta_texto.getText());
        modelBloc.writeFile();
    }
    private void initComponents(){
        viewCBloc.setVisible(true);
    }
}