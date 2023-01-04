import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DataValidation {

    public static String validation(String field) {
        List<String>  validationResult = isValidForm(2, field);

        if (!Boolean.parseBoolean(validationResult.get(0))) {
            return null;
        } else {
            return validationResult.get(1);
        }
    }

    public static List<String> isValidForm(int iteration, String field) {
        Scanner sc = new Scanner(System.in);
        String input = null, pattern = null;

        for (int i = 0; i <= iteration; ++i) {

            switch (field) {
                case "name":
                    System.out.println(CommonPrintFormat.name);
                    pattern = CommonPrintFormat.namePattern;
                    break;
                case "phoneNumber":
                    System.out.println(CommonPrintFormat.phoneNumber);
                    pattern = CommonPrintFormat.phoneNumberPattern;
                    break;
                case "address":
                    System.out.println(CommonPrintFormat.address);
                    pattern = CommonPrintFormat.addressPattern;
                    break;
                case "email":
                    System.out.println(CommonPrintFormat.email);
                    pattern = CommonPrintFormat.emailPattern;
                    break;
                case "grade":
                    System.out.println(CommonPrintFormat.grade);
                    pattern = CommonPrintFormat.gradePattern;
                    break;
            }

            input = sc.nextLine();
            if (!input.matches(Objects.requireNonNull(pattern))) {
                System.out.println(CommonPrintFormat.retry);
            } else {
                return Arrays.asList("true", input);
            }
        }
        return Arrays.asList("false", input);
    }


}
