package itacademy.domain.entity;

import lombok.*;

import java.util.prefs.Preferences;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class Branch {
    private Long id;
    private String name;
    private String address;

    public Branch(String name) {
        this.name = name;
    }

    public Branch(Long id) {
        this.id = id;
    }

    public Branch(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Branch(Branch build) {
        this.name = build.name;
        this.address = build.address;
    }
}