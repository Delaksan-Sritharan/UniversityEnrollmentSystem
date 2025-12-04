package universityenrollmentsystem;

public class ExchangeStudent extends Student{
    private String homeUniversity;
    private String homeCountry;
    private int exchangeDurationMonths;
    private boolean hasScholarship;

    public ExchangeStudent(String name, String surname,String homeUniversity) {
        super(name, surname);
        this.homeUniversity = homeUniversity;
        this.homeCountry = homeCountry;
    }

    public String getHomeUniversity() {
        return homeUniversity;
    }

    public void setHomeUniversity(String homeUniversity) {
        this.homeUniversity = homeUniversity;
    }

    public String getHomeCountry(){
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry){
        this.homeCountry = homeCountry;
    }

    public int getExchangeDurationMonths() {
        return exchangeDurationMonths;
    }

    public void setExchangeDurationMonths(int exchangeDurationMonths) {
        this.exchangeDurationMonths = exchangeDurationMonths;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    @Override
    public String toString(){
        return super.toString();
    }

}
