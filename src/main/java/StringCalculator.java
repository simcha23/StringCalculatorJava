
public class StringCalculator {


    public static void main(String[] args){

        try {
            //Calling a method Add and pass the required data
            add("");
            add("1");
            add("1,1");
            add("1,2,3,4");
            add("1\n2,3");
            add("//;\n1;2");
            add("//4\n142");
            add("//;\n1000,1;2");
            add("//***\n1***2***3");

//          Method whose parameters contain negative numbers
//          add("1,-2,3,-4,-5,8");

//          Method with invalid parameters
//          add("//;\n1000;1;2;");
//          add("   //;\n1000,1;2");
//          add("1,2,3//;\n1000,1;2");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static boolean add(String num){

        if( num.isEmpty() ){
            num = "0";
        }

        String delimiter = "[,\n;*]"; //Delimiter used to spit a string into array

        //
        if( num.startsWith("//") ) {

            String[] str;
            //Check if string start with certain characters and give it a new delimiter
            if( num.startsWith("//;") || num.startsWith("//4") ){
                str = num.split("\n", 2);
                delimiter = "[" + str[0].substring(2) +",]";
            }
            else {
                str = num.split("\n", 4);
                str[1] = str[1].replace(str[0].substring(2,5),";");
                delimiter = ";";
            }

            num  = str[1];

            if( num.endsWith(";") ){
                num = "@#$%";
            }
        }

        String[] array = num.split( delimiter ); //split string into array from a given delimiter
        int sum = 0;
        boolean condition = true;
        String statement = "ERROR:negatives not allowed ";

        try {
            for ( String number : array ) {
                int input = Integer.parseInt(number); //Validates if is an integer number
                if ( input < 0 ) {
                    statement = statement.concat( number.concat( "," ) );
                    condition = false;
                }
                if ( condition && input < 1000 ) { //Calculating a sum of integer numbers
                    sum = sum + Integer.parseInt( number );
                    condition = true;
                }
            }
            if ( condition ) {
                System.out.println("Output " + sum); //Prints the sum of integer numbers
            } else {
                System.out.println(statement); //Prints negative numbers warning
            }
        }catch ( NumberFormatException ex ){
            System.out.println("ERROR:Invalid input"); //Prints invalid input message when invalid input entered
            condition = false;
        }catch ( Exception ex ){
            ex.printStackTrace();
        }

        return condition;
    }
}
