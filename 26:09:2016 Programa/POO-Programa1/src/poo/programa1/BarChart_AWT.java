/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 */
public class BarChart_AWT extends ApplicationFrame
{
    public BarChart_AWT( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Provincia",            
         "Número de Sismos",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String meses[] = {"Enero",
                              "Febrero",
                              "Marzo",
                              "Abril",
                              "Mayo",
                              "Junio",
                              "Julio",
                              "Agosto",
                              "Setiembre",
                              "Octubre",
                              "Noviembre",
                              "Diciembre"};
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for (int mes = 0; mes<12;mes++)
      {
          dataset.addValue( Listas.getCantidadSismos(mes),meses[mes],meses[mes]);
      }             

      return dataset; 
   }
}
