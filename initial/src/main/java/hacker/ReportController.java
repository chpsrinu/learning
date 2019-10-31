package hacker;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {

    @RequestMapping(method = RequestMethod.POST, value = "/report/addReport")
    @ResponseBody
    public Report addReport(@RequestBody Report report) {
        ReportService.getInstance().addReport(report);
        return report;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/report/getReport/{reportId}")
    @ResponseBody
    public Object getReports(@PathVariable int reportId) {
        Report report = ReportService.getInstance().getAllReport(reportId);
        if (null == report) {
            return "record not found for reportId : "+ reportId;
        }
        return report;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/report/deleteReport/{reportId}")
    @ResponseBody
    public String deleteReport(@PathVariable int reportId) {
        return ReportService.getInstance().deleteReport(reportId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/report/updateReport")
    @ResponseBody
    public String updateReport(@RequestBody Report report) {
        return ReportService.getInstance().updateReport(report);
    }
}

