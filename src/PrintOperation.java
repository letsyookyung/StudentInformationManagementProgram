import java.util.*;

public class PrintOperation {

    public static void printAll() {
        System.out.println(PrintPrintFormat.field);
        iterateMap(InfoDataBase.allStudentInfo);
    }


    public static void optionalPrint(String option) {

        String option1, option2;

        try {
            option1 = option.split("-")[0];
            option2 = option.split("-")[1];

            if (!CommonPrintFormat.keyWordCheckList.contains(option1) || !CommonPrintFormat.keyWordCheckList.contains(option2)) {
                System.out.println(PrintPrintFormat.retry);
                return;
            }

            System.out.println(PrintPrintFormat.field);
            switch (option1) {
                case "이름":
                    if (option2.equals("a")) {
                        Map<String, List<String>> sortedMap = new TreeMap<>(InfoDataBase.allStudentInfo);
                        iterateMap(sortedMap);
                    } else {
                        Map<String, List<String>> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
                        reverseSortedMap.putAll(InfoDataBase.allStudentInfo);
                        iterateMap(reverseSortedMap);
                    }
                    break;
                case "성적":
                    HashMap<String, List<String>> sortedMap = new LinkedHashMap<>();
                    List<String> list = new ArrayList<>();

                    for (Map.Entry<String, List<String>> entry : InfoDataBase.allStudentInfo.entrySet()) {
                        list.add(entry.getValue().get(1));
                    }
                    list.sort(Comparator.naturalOrder());

                    if (!option2.equals("a")) {
                        list.sort(Collections.reverseOrder());
                    }

                    for (String str : list) {
                        for (Map.Entry<String, List<String>> entry : InfoDataBase.allStudentInfo.entrySet()) {
                            if (entry.getValue().get(1).equals(str)) {
                                sortedMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    iterateMap(sortedMap);
            }
        } catch (Exception e) {
            System.out.println(PrintPrintFormat.retry);
        }
    }

    public static void iterateMap(Map<String, List<String>> map) {
        List<String> valueList;

        int i = 1;
        for (String key : map.keySet()) {
            valueList = InfoDataBase.allStudentInfo.get(key);
            String result2 = String.format("%-5s%-8s%-17s%-20s%-25s%-8s\n", i, key, valueList.get(0),
                    valueList.get(1), valueList.get(2), valueList.get(3));
            System.out.printf(result2);

            i += 1;
        }

    }

}


class PrintPrintFormat extends CommonPrintFormat {
    public static String askField = "\n➤➤➤ 특정 필드 기준으로 정렬하여 보고 싶으면, 특정 필드와 정렬방법을 지정해주세요. 만약, 원하지 않는다면 Q를 눌러주세요." +
            "\nex) 이름-b (이름/성적 - a.오름차순 b.내림차순)";
}


