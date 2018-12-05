
/**
 * creating a DVD
 *
 * @author Michael Stokluska CA2
 */

public class DVD
{
    private String dvdId;
    private String dvdName;
    private int ageClassification;
    private String category;
    private int numMinutes;
    private static int lenOfTime;
    private int rating; 
    public DVD(String dvdId,String dvdName,String category,int ageClassification,int numMinutes){
        this.dvdId=dvdId;
        this.dvdName=dvdName;
        this.category=category;
        this.ageClassification=ageClassification;
        this.numMinutes=numMinutes;
        lenOfTime=0;
        rating=0;}
    public void setDvdId(String dvdId){
        this.dvdId=dvdId;}
    public String getDvdId(){
        return dvdId;}
    public void setDvdName(String dvdName){
        this.dvdName=dvdName;}
    public String getDvdName(){
        return dvdName;}
    public void setCategory(String category){
        this.category=category;}
    public String getCategory(){
        return category;}
    public void setAgeClassification(int ageClassification){
        this.ageClassification=ageClassification;}
    public int getAgeClassification(){
        return ageClassification;}
    public void setNumMinutes(int numMinutes){
        this.numMinutes=numMinutes;}
    public int getNumMinutes(){
        return numMinutes;}
    public static void setLenOfTime(){
        lenOfTime=lenOfTime+1;}
    public int getLenOfTime(){
        return lenOfTime;}
    public void setRating(int rating){
        this.rating=rating;}   
    public int getRating(){
        return rating;}
}
