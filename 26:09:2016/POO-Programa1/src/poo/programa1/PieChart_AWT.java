/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 */
public class PieChart_AWT extends ApplicationFrame
{
    public PieChart_AWT( String title ) 
    {
        super( title ); 
        setContentPane(createDemoPanel());
    }
    private PieDataset createDataset( ) 
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if(Listas.getCantidadSismos(Origen.Choque_Placas)!=0)
            dataset.setValue( Origen.Choque_Placas , Listas.getCantidadSismos(Origen.Choque_Placas));
        if(Listas.getCantidadSismos(Origen.Deformacion_Interna)!=0)
            dataset.setValue( Origen.Deformacion_Interna , Listas.getCantidadSismos(Origen.Deformacion_Interna)); 
        if(Listas.getCantidadSismos(Origen.IntraPlaca)!=0)
            dataset.setValue( Origen.IntraPlaca , Listas.getCantidadSismos(Origen.IntraPlaca)); 
        if(Listas.getCantidadSismos(Origen.Subducción)!=0)
            dataset.setValue( Origen.Subducción , Listas.getCantidadSismos(Origen.Subducción)); 
        if(Listas.getCantidadSismos(Origen.Tectonico_Falla_Local)!=0)
            dataset.setValue( Origen.Tectonico_Falla_Local , Listas.getCantidadSismos(Origen.Tectonico_Falla_Local)); 
        return dataset;         
    }
    private JFreeChart createChart(PieDataset dataset)
    {
        JFreeChart chart = ChartFactory.createPieChart(      
          "Cantidad de sismos por tipo de origen",
          dataset,       
          true,            
          true, 
          false);
        
        return chart;
   }
    public JPanel createDemoPanel( )
    {
        JFreeChart chart = createChart(createDataset( ));  
        return new ChartPanel( chart ); 
    }
}
