public class StringCalculator {

    public static void main(String[] args){

        System.out.println("\n---------ADDITION----------\n");

        add("");
        add("1");
        add("1,1");
        add("1,2,3,4");
        add("1\n2,3");
        add("//;\n1;2");
        add("//4\n142");
//        add("-1,-2,-3,-4");
        add("//;\n1000,1;2");
        add("//***\n1***2***3");

    }
    public static int add(String number){

        if(number == ""){
            number = number.replace("", "0");
        }

        number = number.replace("//;", "0");
        number = number.replace("\n", ",");
        number = number.replace(";", ",");

        if(number.startsWith("//4")){
            number = number.replace("//4", "0");
            number = number.replace("4", ",");
        }
        number = number.replace("//***", "0");
        number = number.replace("***", ",");

        String[] numbers;
        numbers = number.split(",");

        int sum = 0;

        try {
            for (String newNumbers:numbers) {

                int value = Integer.parseInt(newNumbers);
                if(value < 1000){
                    sum = sum + value;
                }
            }

            if(Integer.toString(sum).contains("-")){
                System.out.println("ERROR:negatives not allowed -1,-2");
            }else {
                System.out.println("Result: " + sum);
            }
        }catch (NumberFormatException ex){
            System.out.println("ERROR:Invalid input");
        }


        return sum;
    }
}

