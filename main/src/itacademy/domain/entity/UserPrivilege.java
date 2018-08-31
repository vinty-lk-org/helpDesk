package itacademy.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class UserPrivilege {
    private SystemUser userId;
    private Privilege privilegeId;
}