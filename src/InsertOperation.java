import java.util.List;

public class InsertOperation {

    public static boolean checkDuplicate(String name) {
        return InfoDataBase.allStudentInfo.containsKey(name);
    }

    public static void insert(String name, List<String> infoList) {
        InfoDataBase.allStudentInfo.put(name, infoList);
        System.out.println(InsertPrintFormat.success);
        System.out.printf("%s : %s", name, InfoDataBase.allStudentInfo.get(name));

    }

}

class InsertPrintFormat extends CommonPrintFormat {

    public static String alreadyExist = "➤➤➤ 이미 등록되어 있는 이름입니다.\n";

    public static String success = "➤➤➤ 등록 완료! ";

}

