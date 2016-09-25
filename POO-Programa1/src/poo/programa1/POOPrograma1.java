/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.util.ArrayList;

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 */
public class POOPrograma1
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ReadExcelDemo.leerExcel();
        Interfaz ventanaPrincipal = new Interfaz();
        ventanaPrincipal.setSize(1000, 600);
        ventanaPrincipal.updateTablaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
    
}
