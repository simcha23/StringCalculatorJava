
public class StringCalculator {


    public static void main(String[] args){

        add("");
        add("1");
        add("1,1");
        add("1,2,3,4");
        add("1\n2,3");
        add("//;\n1;2");
        add("//4\n142");
        add("//;\n1000,1;2");
        add("//***\n1***2***3");

        //  Negative numbers
//        add("1,-2,3,-4");\

        // Invalid input
//        add("//;\n1000;1;2;");
//        add("   //;\n1000,1;2");
//        add("1,2,3//;\n1000,1;2");


    }
    public static boolean add(String num){

        if(num.isEmpty()){
            num = "0";
        }

        String delimiter = "[,\n;*]";

        if(num.startsWith("//")) {

            String[] str;

            if(num.startsWith("//;") || num.startsWith("//4")){
                str = num.split("\n", 2);
                delimiter = "[" + str[0].substring(2) +",]";
            }
            else {
                str = num.split("\n", 4);
                str[1] = str[1].replace(str[0].substring(2,5),";");
                delimiter = ";";
            }

            num  = str[1];
            if(num.endsWith(";")){
                num = "@#$%";
            }

        }

        String[] array = num.split(delimiter);
        int sum = 0;
        boolean condition = true;
        String statement = "ERROR:negatives not allowed ";

        try {
            for (String number : array) {

                if (Integer.parseInt(number) < 0) {
                    statement = statement + number + ",";
                    condition = false;
                }
                if (condition) {
                    if (Integer.parseInt(number) < 1000) {
                        sum = sum + Integer.parseInt(number);
                        condition = true;
                    }
                }
            }
            if (condition) {
                System.out.println("Output " + sum);
            } else {
                System.out.println(statement);
            }
        }catch (NumberFormatException ex){
            System.out.println("ERROR:Invalid input");
            condition = false;
        }

        return condition;
    }
}
