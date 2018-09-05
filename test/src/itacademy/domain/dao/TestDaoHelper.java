package itacademy.domain.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

public class TestDaoHelper {

    private static final int PHONE_NUMBER_LENGTH = 7;

    public static String getRandomWord(int lengthWordBegin, int lengthWordEnd, boolean isCapitalFirstChar) {
        String text = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getRandomNumberInRange(lengthWordBegin, lengthWordEnd); i++) {
            if (isCapitalFirstChar) {
                if (i == 0) {
                    char c = text.charAt(getRandomNumberInRange(0, text.length() - 1));
                    String s = String.valueOf(c);
                    stringBuilder.append(s.toUpperCase());
                } else {
                    stringBuilder.append((text.charAt(getRandomNumberInRange(0, text.length() - 1))));
                }
            } else {
                stringBuilder.append((text.charAt(getRandomNumberInRange(0, text.length() - 1))));
            }
        }
        return stringBuilder.toString();
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static String getRandomPhone() {
        String s = "0123456789";
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("+375-");
        String[] codeOperatorArray = {"29", "44", "33", "25", "17"};
        phoneNumber.append(codeOperatorArray[(new Random().nextInt(codeOperatorArray.length))]).append("-");
        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }

    public static String getRandomEmail() {
       return TestDaoHelper.getRandomWord(5, 10, false) + "@" +
                TestDaoHelper.getRandomWord(3, 5, false) + ".com";
    }

    public static Long getRandomIdFromList(List<?> objects){
        Long id = null;
        int index = getRandomNumberInRange(0, objects.size() - 1);
        Object o = objects.get(index);
        Class<?> oClass = o.getClass();
        try {
            Field field = oClass.getDeclaredField("id");
            field.setAccessible(true);
            id = Long.valueOf(field.get(o).toString());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return id;
    }
}