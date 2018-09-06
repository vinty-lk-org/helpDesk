package itacademy.domain.entity;

public enum Status {

    SUBMITTED("Подана"),
    PENDING("Исполняется"),
    COMPLETED("Выполнена"),
    CLOSED("Отклонена");
    private String description;

    private Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


//public static void main(String[] args) {
//        for (Season s : Season.values())
//        System.out.println(s + ": " + s.getDescription());
//        }
