/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jasperdemo;



import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author guillermo
 */
public class JasperDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
      String reportSource ="./reports/templates/HolaMundo.jrxml";
     
       String reportDest= "./reports/results/HolaMundo.html";
       Map<String, Object> params = new HashMap<String, Object>();
       
    try{
          JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
     
          JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params, new JREmptyDataSource());
          JasperExportManager.exportReportToHtmlFile(jasperPrint,reportDest);
          JasperViewer.viewReport(jasperPrint);
       
       }catch (JRException ex){
       System.out.println(ex.getMessage());
       } 
    }
}
    

