/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import views.ViewBloc;

/**
 *Generar variables, getters and setters
 * @author Sebastián
 */
public class ModelBloc {
    ViewBloc viewbloc;
    private String path="C:\\Archivos\\archivo.txt";
    private String message = "";
    boolean condicion = false;

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * permite la lectura del archivo
     */
    public void readFile(){
        try{
            String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        message = message + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        }catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operation" + ex.getMessage());
        }
    }
    /**
     * permite la sobreescritura del archivo en la ruta
     */
    public void writeFile(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter (file,condicion);
            try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                printWriter.print(message);
                printWriter.close();
            }
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
}
