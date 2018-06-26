public class Country{

    private String countryName;
    private String capitalName;

    public Country(String country, String capital){

        this.countryName = country;
        this.capitalName = capital;
    }
    public String getCountryName(){
        return this.countryName;
    }
    public String getCapitalName(){
        return this.capitalName;
    }
}