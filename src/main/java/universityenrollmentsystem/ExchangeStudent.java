package universityenrollmentsystem;

public class ExchangeStudent extends Student{
    private String homeUniversity;
    private String homeCountry;
    private int exchangeDurationMonths;
    private boolean hasScholarship;

    public ExchangeStudent(String name, String surname,String homeUniversity,String homeCountry) {
        super(name, surname);
        this.homeUniversity = homeUniversity;
        this.homeCountry = homeCountry;
        this.exchangeDurationMonths = 1;
        this.hasScholarship = false;
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
        if (exchangeDurationMonths < 1){
            System.out.println("Exchange duration must be at least 1 month. Setting to 1.");
            this.exchangeDurationMonths = 1;
        }else {
            this.exchangeDurationMonths = exchangeDurationMonths;
        }
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public boolean isLongTermExchange(){
        return exchangeDurationMonths >=6;
    }

    @Override
    public String toString(){
        String durationType = isLongTermExchange()? "Long-term": "Short-term";
        return super.toString()+
                "\nHome University: " + homeUniversity +
                "\nHome Country: " + homeCountry +
                "\nExchange Duration: " + exchangeDurationMonths + " months" +
                "\nExchange Type: " + durationType +
                "\nHas Scholarship: " + (hasScholarship ? "Yes" : "No");

    }

}
