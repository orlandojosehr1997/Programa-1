/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author orlandojose
 */
public class ReadExcelDemo 
{
    public static void leerExcel()
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("sismos.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                org.apache.poi.ss.usermodel.Row row = rowIterator.next();
                row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                String fila[] = new String[8];
                int contador = 0;
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly                  
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            fila[contador++] = (cell.getNumericCellValue() + "");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            fila[contador++] = (cell.getStringCellValue());
                            break;
                    }
                }
                Listas lista = new Listas();
                fila[0] = fila[0].replaceAll("'", "");
                System.out.println(fila[0]);
                Sismo s1 = new Sismo(fila[0],fila[1],fila[2],Origen.valueOf(fila[3]),Provincia.valueOf(fila[4]),fila[5],fila[6],fila[7]);
                lista.agregarSismo(s1);
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void crearArchivo()
    {
        Listas lista = new Listas();
        lista.getListaSismos();
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Sismos Data");

        //This data needs to be written (Object[])
//        Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[] {"IdD", "NAdME", "LdSTNAME"});
//        data.put("2", new Object[] {1, "fsd", "d"});
//        data.put("3", new Object[] {2, "Juan", "fdsfs"});
//        data.put("4", new Object[] {3, "John", "Adwards"});
//        data.put("5", new Object[] {4, "Brfsdian", "fs"});
//
//        //Iterate over data and write to sheet
//        Set<String> keyset = data.keySet();
        Listas listas = new Listas();
        ArrayList<Sismo> listaSismos = listas.getListaSismos();
        int rownum = 0;
        String sismoTitulos[] = {"Fecha",
                                 "Magnitud",
                                 "Profundidad",
                                 "Origen",
                                 "Provincia",
                                 "Descripción",
                                 "Latitud",
                                 "Longitud"};
        Row rowTitulos = sheet.createRow(rownum++);
        int cellnum = 0;
        for (int x=0;x<8;x++)
        {
            Cell cell = rowTitulos.createCell(cellnum++);
            cell.setCellValue(sismoTitulos[x]);
        }
        for (Sismo sismo : listaSismos) 
        {
            String sismoInfo[] = {sismo.getFecha2(),
                                  sismo.getMagnitud(),
                                  sismo.getProfundidad(),
                                  sismo.getOrigenStr(),
                                  sismo.getProvinciaStr(),
                                  sismo.getDescripcion(),
                                  sismo.getLatitud(),
                                  sismo.getLongitud()};
            Row row = sheet.createRow(rownum++);
            cellnum = 0;
            for (int x=0;x<8;x++)
            {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(sismoInfo[x]);
            }
            
        }
        try 
        {
                //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("sismos.xlsx"));
            workbook.write(out);
            out.close();

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
