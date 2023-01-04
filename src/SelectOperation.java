import java.util.ArrayList;
import java.util.List;

public class SelectOperation {

    public static void select(Field field, String value) {
        List<String> resultList = new ArrayList<>();

        switch (field) {
            case NAME :
                if (InfoDataBase.allStudentInfo.get(value) == null) {
                    System.out.println(SelectPrintFormat.retryName);
                    break;
                }
                SelectPrintFormat.success(value);
                System.out.println(InfoDataBase.allStudentInfo.get(value));
                break;
            case PHONENUMBER: case ADDRESS: case EMAIL: case SCORE :
                for (String key : InfoDataBase.allStudentInfo.keySet()) {
                    List<String> valueList = InfoDataBase.allStudentInfo.get(key);
                    for (String checkValue : valueList) {
                        if (checkValue.equals(value)) {
                            resultList.add(key);
                        }
                    }
                }
                if (resultList.size() == 0) {
                    System.out.println(SelectPrintFormat.retry);
                } else {
                    System.out.printf("➤➤➤ 찾기 완료! : %s",resultList);
                }
            }

    }
}

class SelectPrintFormat extends CommonPrintFormat {

    public static String askField = "➤➤➤ 1.이름 2.전화번호 3.집주소 4.이메일 5.성적 중 어떤 항목으로 검색 하고 싶은가요? \n(단, 이름 선택 시 관련 학생의 정보를 제공하지만, 이 외의 항목은 학생 이름을 제공합니다.)";

    public static String askName = "➤➤➤ 검색하고 싶은 학생의 이름을 입력하세요.";
    public static String retry = "\uD83D\uDE4F 입력하신 정보를 가지고 있는 학생 이름을 찾을 수 없습니다. \uD83D\uDE4F";
    public static String retryName = "\uD83D\uDE4F 입력하신 학생 이름을 찾을 수 없습니다. \uD83D\uDE4F";

    public static void success(String value){
        System.out.printf("- %s 의 정보: ", value);
    }
}
