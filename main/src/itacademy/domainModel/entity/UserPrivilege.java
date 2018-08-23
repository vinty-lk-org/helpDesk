package itacademy.domainModel.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class UserPrivilege {
    private SystemUser userId;
    private Privilege privilegeId;
}
