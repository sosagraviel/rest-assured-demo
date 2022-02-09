package pojo;

public class EmployeePojo {
    private String name;
    private String job;
    private String[] skill;
    private Details details;

    public EmployeePojo (String name, String job, String[] skill, String companyName, String emailId){
    this.name=name;
    this.job=job;
    this.skill=skill;
    this.details=new Details(companyName,emailId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
