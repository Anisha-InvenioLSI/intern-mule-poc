import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

 

public class ReadDetails {

 

    public static String DELIMITER=";";
    static List<Line> lineList = new ArrayList<Line>();
    static HashMap<String, Line> lineMap= new HashMap<>();
    static HashMap<String, Line> lines= new HashMap<>();
    static HashMap<String, List> lineDetails= new HashMap<>();

 

    public static HashMap<String, List> readCSV(String CSVfile) {

        try {

            File file = new File(CSVfile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String detail = " ";
            String[] val;
            Header header=new Header();
            while ((detail = br.readLine()) != null) {
                val= detail.split(DELIMITER);
                if (val[0].equalsIgnoreCase("HAUDIT")){
                    header.setRecordType(val[0]);
                    header.setTotalLines(Integer.parseInt(val[1]));
                    header.setTotalAmt(Double.parseDouble(val[2]));
                    header.setMinAmt(Integer.parseInt(val[3]));
                    header.setCurrentDate(val[4]);
                }
                else {
                    Line line=new Line();
                    line.setRecordType(val[0]);
                    line.setLineNumber(val[1]);
                    line.setRefDocNum(val[2]);
                    line.setCity(val[3]);
                    line.setAmount(Double.parseDouble(val[4]));
                    lineList.add(line);
                    lines.put(line.getRefDocNum(), line);
                }
            }
            br.close();
            HashMap<String, List> lineMap=createLineMap(lines,lineList);
            System.out.println("Final Output");
            System.out.println("Header details: ");
            System.out.println(header.toString());
            System.out.println("Line Details");
            System.out.println(lineMap);
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return lineDetails;
    }

 

    public static HashMap<String, List> createLineMap(HashMap<String, Line> lines, List<Line> linesList) {
        Set<String> distinctRefNum=lines.keySet();
        for (String refNum: distinctRefNum) {
            List<Line> refNumList = new ArrayList<Line>();
            for (Line line:linesList) {
                if (refNum.equalsIgnoreCase(line.getRefDocNum())) {
                    refNumList.add(line);
                }
            }
            lineDetails.put(refNum, refNumList);
        }
        return lineDetails;
    }

 

 

}