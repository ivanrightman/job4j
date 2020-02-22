package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        HtmlReport htmlReport = new HtmlReport();
        JSONReport jsonReport = new JSONReport();
        String text = textReport.generate("Report's name", "Report's body");
        String html = htmlReport.generate("Report's name", "Report's body");
        String json = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println(html);
        System.out.println(json);
    }
}
