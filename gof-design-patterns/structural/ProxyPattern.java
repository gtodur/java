package com.patterns.structural;

public class ProxyPattern {

	public static void main(String[] args) {
        Role accessRole=new Role();
        accessRole.setRole("Manager");
        ReportGenerator proxy=new ReportGeneratorImplProxy(accessRole);
        proxy.displayReportTemplate("Pdf",150);
        proxy.generateComplexReport("Pdf",150);
        proxy.generateSensitiveReport();

	}

}

/*
 * Subject
 * Is an interface for both the real object and its proxy. 
 * The Subject enables the proxy to be used anywhere the real object is expected.
 */
interface ReportGenerator {
    void displayReportTemplate(String reportFormat,int reportEntries);
    void generateComplexReport(String reportFormat,int reportEntries);
    void generateSensitiveReport();
}

/*
 * RealSubject
 * The real object that is expensive to create, requires protection, or running on a remote JVM. 
 * RealSubject implements Subject and we create proxy of it.
 */
class ReportGeneratorImpl implements ReportGenerator {
    public ReportGeneratorImpl(){
        System.out.println("ReportGeneratorImpl instance created");
    }
    @Override
    public void displayReportTemplate(String reportFormat,int reportEntries) {
    }
    @Override
    public void  generateComplexReport(String reportFormat, int reportEntries){
        System.out.println("ReportGeneratorImpl: Generating complex report in "+reportFormat+" format with "+ reportEntries+" entries");
    }
    @Override
    public void  generateSensitiveReport(){
        System.out.println("ReportGeneratorImpl: Generating sensitive report");
    }
}

/*
 * Proxy
 * Implements Subject and maintains a reference to RealSubject.
 */
class ReportGeneratorImplProxy implements ReportGenerator{
    ReportGenerator reportGeneratorImpl;
    private Role accessRole;
    public ReportGeneratorImplProxy(Role accessRole){
            this.accessRole=accessRole;
    }
    @Override
    public void displayReportTemplate(String reportFormat,int reportEntries) {
        System.out.println("ReportGeneratorImplProxy: Displaying blank report template in " + reportFormat + " format with " + reportEntries + " entries");
    }
    @Override
    public void  generateComplexReport(String reportFormat,int reportEntries){
        if(reportGeneratorImpl==null)
            reportGeneratorImpl = new ReportGeneratorImpl();
            reportGeneratorImpl.generateComplexReport(reportFormat,reportEntries);
    }
    @Override
    public void generateSensitiveReport(){
        if(accessRole.getRole().equals("Manager")){
            if(reportGeneratorImpl==null)
                reportGeneratorImpl = new ReportGeneratorImpl();
                reportGeneratorImpl.generateSensitiveReport();
        }
        else{
            System.out.println("You are not authorized to access sensitive reports.");
        }
    }
}

class Role {
    private String role;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
  }
