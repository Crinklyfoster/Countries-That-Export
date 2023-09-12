
/**
 * Write a description of Part1 here.
 * 
 * @ Snehil S P
 * @version (15 June 2023)
 */


import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String country = "Germany";
        String FindCountry = countryInfo(parser, country);
        System.out.println(FindCountry);
        
        parser = fr.getCSVParser();
        String exportItem1 = "cotton";
        String exportItem2 = "flowers";
        listExportersTwoProducts(parser, exportItem1, exportItem2);
        
        parser = fr.getCSVParser();
        String exportItem = "cocoa";
        int Exporters = numberOfExporters(parser, exportItem);
        System.out.println(Exporters);
        
        parser = fr.getCSVParser();
        String amount = "$999,999,999,999";
        bigExporters(parser,amount);
    }
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord allInfo : parser) {
            String countryColumn = allInfo.get("Country");
            if(countryColumn.contains(country)){
                String countryFound = allInfo.get("Country");
                String exportsFound =  allInfo.get("Exports");
                String valueFound = allInfo.get("Value (dollars)");
                String allTogether = countryFound + ": " + exportsFound + " " + valueFound + "";
                //System.out.println(allTogether);
                return allTogether;
            }
            else {
                return "Country not found";
            }
        }
        return "";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord allInfo : parser) {
            String countryColumn = allInfo.get("Exports");
            if(countryColumn.contains(exportItem1)&& countryColumn.contains(exportItem2)){
                String countryFound = allInfo.get("Country");
                System.out.println(countryFound);
            }
            else {
                System.out.print("");
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord allInfo : parser) {
            String exportsColumn = allInfo.get("Exports");
            if(exportsColumn.contains(exportItem)){
              count = count +1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord allInfo : parser) {
            String valueColumn = allInfo.get("Value (dollars)");
            if (valueColumn.length() > amount.length()){
                String countryFound = allInfo.get("Country");
                String valueFound =  allInfo.get("Value (dollars)");
                String allTogether = countryFound + ": " + valueFound;
                System.out.println(allTogether);
            }
        }
        
    }
}