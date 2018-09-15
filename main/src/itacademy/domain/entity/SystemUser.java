package itacademy.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class SystemUser {
  private Long id;
  private String name;
  private String family;
  private String email;
  private String password;
  private Branch branch;
  private Subdivision subdivision;

  public SystemUser(Long id) {
    this.id = id;
  }

  public SystemUser(String name) {
    this.name = name;
  }

  public SystemUser(String name,
                    String family,
                    String email,
                    String password,
                    Branch branch,
                    Subdivision subdivision) {
    this.name = name;
    this.family = family;
    this.email = email;
    this.password = password;
    this.branch = branch;
    this.subdivision = subdivision;
  }

  public SystemUser(String name, String family) {
    this.name = name;
    this.family = family;
  }

}