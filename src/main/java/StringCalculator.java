import javax.swing.JOptionPane;

public class StringCalculator {

    public static void main(String[] args){

        System.out.println("\n---------ADDITION----------\n");

        String string = JOptionPane.showInputDialog("Please enter a string: ");

        if(string.isEmpty()){
            string = "";
        }

        add(string);

        // IN CASE YOU WANT TO USE THE HARDCODED INPUT UNCOMMENT THE CODE BELOW AND COMMENT THE ONE ON TOP.

//        add("");
//        add("1");
//        add("1,1");
//        add("1,2,3,4");
//        add("1\n2,3");
//        add("//;\n1;2");
//        add("//4\n142");
//        add("-1,-2,-3,-4"); // Negative not allowed
//        add("//;\n1000,1;2");
//        add("//***\n1***2***3");
//        add("//***\n1***2***3567676v gf"); //Invalid input

    }
    public static boolean add(String number){

        boolean status = false;

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
                status = false;
            }else {
                System.out.println("Result: " + sum);
                status = true;
            }
        }catch (NumberFormatException ex){
            System.out.println("ERROR:Invalid input");
            status = false;
        }

        return status;
    }
}

