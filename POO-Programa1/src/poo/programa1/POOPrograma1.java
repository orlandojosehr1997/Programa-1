/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;


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
