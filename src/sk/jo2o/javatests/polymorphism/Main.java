package sk.jo2o.javatests.polymorphism;

public class Main {

    public static void main(String[] args) {
        ReportData reportData1 = new DetailedReportData();
        ReportData reportData2 = new CumulatedReportData();

        System.out.println(call(reportData1));
        System.out.println(call(reportData2));
    }

    public static String call(ReportData reportData) {
        return reportData.getData();
    }

//    public static String call(CumulatedReportData reportData) {
//        return reportData.getData();
//    }

}
