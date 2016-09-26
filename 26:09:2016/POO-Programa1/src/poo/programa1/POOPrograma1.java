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
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 */
public class POOPrograma1
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Excel.leerExcel();
        Interfaz ventanaPrincipal = new Interfaz();
        ventanaPrincipal.setSize(1000, 600);
        ventanaPrincipal.updateTablaPrincipal();
        ventanaPrincipal.updateSismosInfoMapa();
        ventanaPrincipal.setVisible(true);
        ArrayList<Provincia> provincias = new ArrayList<>();
        provincias.add(Provincia.Alajuela);
        provincias.add(Provincia.Cartago);
        provincias.add(Provincia.Guanacaste);
        provincias.add(Provincia.Heredia);
        provincias.add(Provincia.Limón);
        provincias.add(Provincia.Mar_Caribe);
        provincias.add(Provincia.Puntarenas);
        provincias.add(Provincia.San_José);
        provincias.add(Provincia.Oceano_Pacífico);
        provincias.add(Provincia.Sin_Asignar);
        Listas.agregarCliente(new Cliente("Orlando","orlandojosehr1997@gmail.com","",provincias,true,false));
        Listas.agregarCliente(new Cliente("Alejandro","aletapiab28@gmail.com","",provincias,true,false));
        Listas.agregarCliente(new Cliente("Francisco","franciscovall95@gmail.com","",provincias,true,false));
        
        
        
        
//         ChartPanel myChart = new ChartPanel(chart);
//            myChart.setMouseWheelEnabled(true);
//            jPanel1.setLayout(new java.awt.BorderLayout());
//            jPanel1.add(myChart,BorderLayout.CENTER);
//            jPanel1.validate();
//        PieChart_AWT demo = new PieChart_AWT("Cantidad de sismos por tipo de origen");  
//        demo.setSize( 560 , 367 );    
//        RefineryUtilities.centerFrameOnScreen( demo );    
//        demo.setVisible( true );
    }
    
}
