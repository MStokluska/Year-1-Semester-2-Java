
/**
 * Write a description of class XtraVisionApplication here.
 *
 * @author Michael Stokluska
 */
public class XtraVisionApplication
{

    public static void main(String []args){
        int choice;
        System.out.print("Enter the maximum amount of dvds that can be stored in the shop: ");
        int amountOfDvd=EasyScanner.nextInt();
        DVDShop theStore = new DVDShop(amountOfDvd);
        System.out.println();
        do{

            System.out.println("DVD System");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Check if DVD shop is empty");
            System.out.println("4. Check if DVD shop is full");
            System.out.println("5. Add Additional DVD Details");
            System.out.println("6. DVD Details");
            System.out.println("7. Update DVD Length of Time in Store");
            System.out.println("8. Search DVD by Age Classification");
            System.out.println("9. Exit System");
            System.out.println();
            System.out.print("Please enter choice [1-9 only]: ");
            choice=EasyScanner.nextInt();
            System.out.println();

            switch(choice){
                case 1:
                option1(theStore);
                break;
                case 2:
                option2(theStore);    
                break;    
                case 3:
                option3(theStore);
                break;
                case 4:
                option4(theStore);
                break;
                case 5:
                option5(theStore);
                break;
                case 6:
                option6(theStore);
                break;
                case 7:
                option7(theStore);
                break;
                case 8 :
                option8(theStore);
                break;   
            }

        }while(choice != 9);
        System.out.print("Thank you for using the DVD system");
        System.out.println();
    }    

    private static void option1(DVDShop theStore){
        System.out.print("Enter dvd id: ");
        String id=EasyScanner.nextString();
        System.out.print("Enter DVD name   : ");
        String name=EasyScanner.nextString();
        System.out.print("Enter DVD category   : ");
        String category=EasyScanner.nextString();
        System.out.print("Enter DVD age classification   : ");
        int age=EasyScanner.nextInt();

        while((age!=12)&&(age!=15)&&(age!=18)){
            System.out.print("Please enter a valid classification (12, 15, or 18) :");
            age=EasyScanner.nextInt();
        }
        System.out.print("Enter DVD running time (in minutes): ");
        int time=EasyScanner.nextInt();

        DVD newDVD=new DVD(id,name,category,age,time);

        boolean ok=theStore.add(newDVD);

        if(ok==false){
            System.out.println();
            System.out.println("Can not add new DVD. This list is full"+"\n ");}

        else{System.out.println("");
            System.out.print("DVD Added"+"\n ");
            System.out.println();}}

    private static void option2(DVDShop theStore){
        System.out.print("Enter DVD id to remove: ");
        String toRemove=EasyScanner.nextString();
        System.out.println();

        boolean ok=theStore.remove(toRemove);

        if(ok==false){  
            System.out.print("Cannot delete DVD as no such DVD exist"+"\n ");
            System.out.println();
        }else{
            System.out.println("DVD with id number "+toRemove+" is removed");
            System.out.println();}}     

    private static void option3(DVDShop theStore){

        boolean ok=theStore.isEmpty();
        if(ok==false){

            System.out.println("The DVD Shop is not empty"+"\n ");}
        else{

            System.out.println("The DVD Shop is empty"+"\n ");}} 

    private static void option4(DVDShop theStore){
        boolean ok=theStore.isFull();
        if(ok==false){

            System.out.println("The DVD Shop is not full"+"\n ");}
        else{
            System.out.println("The DVD Shop is full"+"\n ");}
    }

    private static void option5(DVDShop theStore){
        System.out.print("Enter DVD Id: ");
        String newId=EasyScanner.nextString();
        System.out.println();

        boolean ok=theStore.addDetails(newId,0);

        if(ok==false){
            System.out.println("No such DVD Id exists"+"\n ");}
        else{

            System.out.print("Enter DVD Rating: ");
            int newRating=EasyScanner.nextInt();
            System.out.println();
            theStore.addDetails(newId,newRating);
            System.out.println("DVD details updated"+"\n ");}
    }

    private static void option6(DVDShop theStore){

        char choiceAD;
        do{
            System.out.println();    
            System.out.println("Employee System");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Check if DVD shop is empty");
            System.out.println("4. Check if DVD shop is full");
            System.out.println("5. Add Additional DVD Details");
            System.out.println("6. DVD Details");
            System.out.println("         a. Display Details of a DVD");
            System.out.println("         b. Display All DVD Details");
            System.out.println("         c. Display Longest Running DVD");
            System.out.println("         d. Display Shortest Running DVD");
            System.out.println("7. Update DVD Length of Time in Store");
            System.out.println("8. Search DVD by Age Classification");
            System.out.println("9. Exit System");
            System.out.print("Enter choice [a - d]: ");
            choiceAD=EasyScanner.nextChar();

            switch(choiceAD){
                case'a': 

                option6a(theStore);
                break;
                case'b':

                option6b(theStore);
                break;       
                case'c':

                option6c(theStore);
                break;
                case'd':

                option6d(theStore);
                break;
                default:

                System.out.println();
                System.out.println("Invalid entry please enter from a -d");
            }
            System.out.println("");}

        while(choiceAD=='a'&&choiceAD=='b'&&choiceAD=='c'&&choiceAD=='d');
    }

    private static void option7(DVDShop theStore){
        String info=theStore.upDatelenOfTime();
        System.out.println(info);
        System.out.println();} 

    private static void option8(DVDShop theStore){
        System.out.print("Enter age classification of DVDs to view: ");
        int ageReq=EasyScanner.nextInt();
        String failed="";
        String newList=theStore.dvdByClassification(ageReq);
        if(newList.equals(failed)){
            System.out.println();
            System.out.println("There are no DVDs for age classification "+ageReq);}
        else{
            System.out.println("The DVDs for age classification "+ageReq+" are as follows"+newList);
            System.out.println();
            System.out.println();
        }
    }

    private static void option6a(DVDShop theStore){

        System.out.println();
        System.out.print("Enter DVD id: ");
        String dvdId=EasyScanner.nextString();
        DVD ok=theStore.getItem(dvdId);

        if(ok==null){
            System.out.println("No such DVD id exists");
        }
        else{
            System.out.println();    
            System.out.println("DVD id: "+ok.getDvdId()+"\nDVD name: "+ok.getDvdName()+"\nDVD age classification: "+ok.getAgeClassification()+"\nDVD category: "+ok.getCategory()+"\nDVD rating: "+ok.getRating()+"\nDVD running time: "+ok.getNumMinutes());    
            System.out.println();
        }
    }

    private static void option6b(DVDShop theStore){

        if(theStore.list().equals("")){ 
            System.out.println();    
            System.out.print("There are no DVDs in the shop");
        }else{
            System.out.println(theStore.list());
            System.out.println();}   
    }

    private static void option6c(DVDShop theStore){

        if(theStore.isEmpty()==true){
            System.out.println();
            System.out.println("No DVD are added into the system");}else{
            System.out.println();
            DVD longest=theStore.checkLongestDVD();
            System.out.println(longest.getDvdName()+" with dvd id "+longest.getDvdId()+" is the longest running dvd ("+longest.getNumMinutes()+" minutes )");}
    }

    private static void option6d(DVDShop theStore){

        if(theStore.isEmpty()==true){
            System.out.println();
            System.out.println("No DVD are added into the system");}else{
            System.out.println();
            DVD shortest=theStore.checkShortestDVD();
            System.out.println(shortest.getDvdName()+" with dvd id "+shortest.getDvdId()+" is the shortest running dvd ("+shortest.getNumMinutes()+" minutes )");}
    }
}

        


