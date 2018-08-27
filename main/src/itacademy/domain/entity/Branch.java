package itacademy.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Branch {
    private Long id;
    private String name;
    private String adress;

    public Branch(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public Branch(String name) {
        this.name = name;
    }
}
