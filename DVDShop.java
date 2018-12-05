
/**
 * Write a description of class DVDShop here.
 *
 * @author Michael Stokluska
 */
public class DVDShop
{
    private DVD [] dvdList;
    private int total;
    public DVDShop(int totalIn){
        dvdList= new DVD[totalIn];
        total=0;}
    private int getTotal(){
        return total;} 
    public boolean add(DVD dvdIn){
        if(isFull()==false){
            dvdList[total]=dvdIn;
            total++;
            return true;}
        else{return false;}} 
    public boolean remove(String idIn){
        int index=search(idIn);
        if(index==-999){
            return false;}
        else{
            for(int i=index;i<total-1;i++){
                dvdList[i]=dvdList[i+1];}
            total--;
            return true;}}
    public boolean isEmpty(){
        if(total==0){
            return true;}
        else{return false;}}
    public boolean isFull(){
        if(total==dvdList.length){
            return true;}
        else{return false;}}
    public DVD checkLongestDVD(){
        DVD max=dvdList[0];
        
        for(int i=1;i<total;i++){
            if(dvdList[i].getNumMinutes()>max.getNumMinutes()){
                max=dvdList[i];}
        }
        return max;}
    public DVD checkShortestDVD(){
        DVD min=dvdList[0];
        for(int i=1;i<total;i++){
            if(dvdList[i].getNumMinutes()<min.getNumMinutes()){
                min=dvdList[i];}}
        return min;}
    private int search(String searchIn){
        for(int i=0;i<total;i++){
            if(dvdList[i].getDvdId().equals(searchIn)){
                return i;}}
        return -999;}
    public String list(){
        String theList="";
        if(isEmpty()==true){
            return theList;}
        else{
            for(int i=0;i<total;i++){
                theList=theList+"\nDVD id: "+dvdList[i].getDvdId()+"\nDVD Name: "+dvdList[i].getDvdName()+"\nDVD Classification : "+dvdList[i].getAgeClassification()+"\nDVD Category: "+dvdList[i].getCategory()+"\nDVD Rating: "+dvdList[i].getRating()+"\nLength of dvd: "+dvdList[i].getNumMinutes()+"\nNumber of years in shop: "+dvdList[i].getLenOfTime()+"\n "+"\n ";   
            }
        }return theList;}
    public DVD getItem(String dvdIdIn){
        int index;
        index = search(dvdIdIn);
        if(index == -999){
            return null;}
        else{return dvdList[index];}}
    public String upDatelenOfTime(){
        DVD.setLenOfTime();
        String info="All information updated";
        return info;} 
    public boolean addDetails(String idIn,int newRating){
        int index;
        index=search(idIn);
        if(index==-999){
            return false;}
        else{dvdList[index].setRating(newRating);
            return true;}}
    public String dvdByClassification(int ageSpec){
        String theList="";
            for(int i=0;i<total;i++){
                if(dvdList[i].getAgeClassification()==ageSpec){
                    theList=theList+"\nDVD id: "+dvdList[i].getDvdId()+"\nDVD Name: "+dvdList[i].getDvdName()+"\nDVD Classification : "+dvdList[i].getAgeClassification()+"\nDVD Category: "+dvdList[i].getCategory()+"\nDVD Rating: "+dvdList[i].getRating()+"\nLength of dvd: "+dvdList[i].getNumMinutes()+"\n ";  
                }}return theList;}
        
    }


               
