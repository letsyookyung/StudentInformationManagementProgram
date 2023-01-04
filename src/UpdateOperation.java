import java.util.HashMap;
import java.util.List;

public class UpdateOperation {
    // 필드별로 값 걸러야 하는 로직 추가 필요
    public static void update(DataForUpdate data) {
        String priorValue = InfoDataBase.allStudentInfo.get(data.key).get(data.field.ordinal());
        InfoDataBase.allStudentInfo.get(data.key).set(data.field.ordinal(), data.value);
        UpdatePrintFormat.success(priorValue, data.value);
    }
}

class DataForUpdate {
    public DataForUpdate(String key, String value, Field field) {
        this.key = key;
        this.value = value;
        this.field = field;
    }

    public String key, value;
    public Field field;
}


class UpdatePrintFormat extends CommonPrintFormat {

    public static String askName = "➤➤➤ 수정하고 싶은 학생의 이름을 입력하세요.";
    public static String askField = "➤➤➤ 1.전화번호 2.집주소 3.이메일 4.성적 중 어떤 항목을 수정하고 싶습니까?";
    public static String askHow = "➤➤➤ 어떻게 변경할까요?";

    public static void success(String priorValue, String value) {
        System.out.printf("➤➤➤ 변경 완료! %s -> %s", priorValue, value);
    }


}