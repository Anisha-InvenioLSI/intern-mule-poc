import java.util.Date;

 

public class Line {

    private String recordType;
    private String lineNumber;
    private String refDocNum;
    private String city;
    private double amount;


    public Line() {
        super();
    }

 


    public String getRecordType() {
        return recordType;
    }

 


    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

 


    public String getLineNumber() {
        return lineNumber;
    }

 


    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

 


    public String getRefDocNum() {
        return refDocNum;
    }

 


    public void setRefDocNum(String refDocNum) {
        this.refDocNum = refDocNum;
    }

 


    public String getCity() {
        return city;
    }

 


    public void setCity(String city) {
        this.city = city;
    }

 


    public double getAmount() {
        return amount;
    }

 


    public void setAmount(double amount) {
        this.amount = amount;
    }

 


    @Override
    public String toString() {
        return "Line [recordType=" + recordType + ", lineNumber=" + lineNumber + ", refDocNum=" + refDocNum + ", city="
                + city + ", amount=" + amount + "]";
    }

 

}