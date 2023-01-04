import java.util.*;

public class CommonPrintFormat {

    public static String menuForm = "\n\n------------------\n" +
            " 메뉴의 번호 입력하세요.\n" +
            "  1. 학생 정보 등록\n" +
            "  2. 학생 정보 수정\n" +
            "  3. 학생 정보 삭제\n" +
            "  4. 학생 정보 검색\n" +
            "  5. 학생 정보 출력\n" +
            "  0. 프로그램  종료\n" +
            "------------------\n";

    public static String name = "➤➤➤ 이름 (ex.이유경):";
    public static String namePattern = "^[가-힣]{2,5}$";
    public static String phoneNumber = "➤➤➤ 전화번호 (ex. 010-6255-7065):";
    public static String phoneNumberPattern = "\\d{3}-\\d{4}-\\d{4}";
    public static String address = "➤➤➤ 집주소 (ex. 경기도 고양시 일산동구) :";
    public static String addressPattern = "^[가-힣]{1,5}\\s[가-힣]{1,5}\\s[가-힣]{1,5}$";

    public static String email = "➤➤➤ 이메일 : (ex. yookyung.lee@outlook.kr)";
    public static String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    public static String grade = "➤➤➤ 기말 성적 : \nex. A+, A0, A- (단, A~D까지 입력 가능) ";
    public static String gradePattern = "[A-D+0-]{1,2}$";

    public static String retry = "\uD83D\uDE4F 형식에 맞춰 입력해주세요 \uD83D\uDE4F \n";

    public static String retryName = "\uD83D\uDE4F 해당하는 정보가 없습니다 \uD83D\uDE4F \n";

    static String nothing = "--------------------------------------------------------------------------------------";
    public static String field = String.format("%s\n%-5s%-8s%-15s%-20s%-20s%-8s\n%s", nothing, "번호", "이름", "전화번호", "집주소", "이메일", "성적", nothing);


    public static List<String> keyWordCheckList = new ArrayList<>(Arrays.asList("이름", "전화번호", "집주소", "이메일","성적", "a", "b"));



}
