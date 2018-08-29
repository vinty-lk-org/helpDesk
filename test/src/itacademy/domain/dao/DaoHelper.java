package itacademy.domain.dao;

import java.util.Random;

public class DaoHelper {

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

    private static final int PHONE_NUMBER_LENGTH = 13;
    public static String getRandomPhone() {
        String s = "123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }
}
