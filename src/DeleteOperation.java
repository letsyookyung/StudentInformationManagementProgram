public class DeleteOperation {

    public static void delete(String name) {
        InfoDataBase.allStudentInfo.remove(name);
        DeletePrintFormat.success(name);
    }
}


class DeletePrintFormat extends CommonPrintFormat {
    public static String askName = "➤➤➤ 삭제하고 싶은 학생의 이름을 입력하세요.";

    public static void success(String name){
        System.out.printf("➤➤➤ %s 정보 삭제 완료! 다음에 만나요 \uD83D\uDC4B",name);
    }

}