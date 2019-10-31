package hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ReportService {

    private List<Report> allReports;
    private static ReportService reportService;
    private final AtomicLong reportId = new AtomicLong();

    private ReportService(){
        allReports = new ArrayList<>();
    }

    public static ReportService getInstance() {
        if(reportService == null) {
            reportService = new ReportService();
            return reportService;
        } else {
            return reportService;
        }
    }

    public void addReport(Report report) {
        report.setReportId(reportId.incrementAndGet());
        report.setTimeStamp(System.currentTimeMillis());
        allReports.add(report);
    }

    public Report getAllReport(int reportId) {
        for(int i =0;i<allReports.size();i++) {
            if(allReports.get(i).getReportId() == reportId) {
                return allReports.get(i);
            }
        }
        return null;
    }

    public String deleteReport(int reportId) {
        for (int i=0;i<allReports.size();i++) {
            if (allReports.get(i).getReportId() == reportId) {
                allReports.remove(i);
                return "delete successful";
            }
        }
        return "delete unsuccessful";
    }

    public String updateReport(Report report) {
        for (int i=0;i<allReports.size();i++) {
            if (allReports.get(i).getReportId() == report.getReportId()) {
                allReports.set(i, report);
                return "update successful";
            }
        }
        return "update failed";
    }


}
