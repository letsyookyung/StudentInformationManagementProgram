import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    static boolean exitFlag = false;
    static String  name = null, phoneNumber = null, address = null, email = null, grade = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (!exitFlag) {
            System.out.println(CommonPrintFormat.menuForm);
            ProgramFunction operation = converterToFunctionEnum(sc.nextLine());

            switch (operation) {
                case EXIT:
                    exitFlag = true;
                    break;
                case INSERT:
                    //1. name
                    name = DataValidation.validation("name");
                    if (name == null) {
                        break;
                    }
                    if (InsertOperation.checkDuplicate(name)) {
                        System.out.println(InsertPrintFormat.alreadyExist);
                        break;
                    }
                    //2. phone number
                    phoneNumber = DataValidation.validation("phoneNumber");
                    if (phoneNumber == null) {
                        break;
                    }
                    //3. address
                    address = DataValidation.validation("address");
                    if (address == null) {
                        break;
                    }
                    //4. email
                    email = DataValidation.validation("email");
                    if (email == null) {
                        break;
                    }
                    //5. grade
                    grade = DataValidation.validation("grade");
                    if (grade == null) {
                        break;
                    }

                    List<String> infoList = new ArrayList<>(Arrays.asList(phoneNumber, address, email, grade));
                    InsertOperation.insert(name, infoList);
                    break;
                case UPDATE:
                    System.out.println(UpdatePrintFormat.askName);
                    name = DataValidation.validation("name");
                    if (name == null) {
                        break;
                    }
                    if (!InsertOperation.checkDuplicate(name)) {
                        System.out.println(InsertPrintFormat.retryName);
                        break;
                    }

                    System.out.println(UpdatePrintFormat.askField);
                    Field field = converterToFieldEnum(sc.nextLine());

                    System.out.println(UpdatePrintFormat.askHow);
                    String value = sc.nextLine();
                    UpdateOperation.update(new DataForUpdate(name, value, field));
                    break;
                case DELETE:
                    System.out.println(DeletePrintFormat.askName);
                    name = DataValidation.validation("name");
                    if (name == null) {
                        break;
                    }
                    if (!InsertOperation.checkDuplicate(name)) {
                        System.out.println(InsertPrintFormat.retryName);
                        break;
                    }

                    DeleteOperation.delete(name);
                    break;
                case SELECT:
                    System.out.println(SelectPrintFormat.askField);
                    field = converterToFieldEnum(sc.nextLine());
                    value = "";

                    switch (field) {
                        case NAME :
                            System.out.println(SelectPrintFormat.askName);
                            value = DataValidation.validation("name");
                            if (value == null) {
                                break;
                            }
                            if (!InsertOperation.checkDuplicate(name)) {
                                System.out.println(InsertPrintFormat.retryName);
                                break;
                            }
                            break;
                        case PHONENUMBER :
                            value = DataValidation.validation("phoneNumber");
                            if (value == null) {
                                break;
                            }
                            break;
                        case ADDRESS :
                            value = DataValidation.validation("address");
                            if (value == null) {
                                break;
                            }
                            break;
                        case EMAIL :
                            value = DataValidation.validation("email");
                            if (value == null) {
                                break;
                            }
                            break;
                        case SCORE :
                            value = DataValidation.validation("score");
                            if (value == null) {
                                break;
                            }
                    }

                    SelectOperation.select(field, value);
                    break;
                case PRINT:
                    PrintOperation.printAll();

                    System.out.println(PrintPrintFormat.askField);
                    String nextAction = sc.nextLine();

                    if (nextAction.equalsIgnoreCase("q")) {
                        break;
                    } else {
                        PrintOperation.optionalPrint(nextAction);
                    }
            }
        }
    }



    public static ProgramFunction converterToFunctionEnum(String field) {
        switch (field) {
            case "0" :
                return ProgramFunction.EXIT;
            case "1" :
                return ProgramFunction.INSERT;
            case "2" :
                return ProgramFunction.UPDATE;
            case "3" :
                return ProgramFunction.DELETE;
            case "4" :
                return ProgramFunction.SELECT;
            case "5" :
                return ProgramFunction.PRINT;
            default :
                throw new IllegalArgumentException("올바르지 않은 필드입니다.");
        }
    }

    public static Field converterToFieldEnum(String field) {
        switch (field) {
            case "1":
                return Field.NAME;
            case "2":
                return Field.PHONENUMBER;
            case "3":
                return Field.ADDRESS;
            case "4":
                return Field.EMAIL;
            case "5":
                return Field.SCORE;
            default:
                throw new IllegalArgumentException("올바르지 않은 필드입니다.");
        }
    }

}