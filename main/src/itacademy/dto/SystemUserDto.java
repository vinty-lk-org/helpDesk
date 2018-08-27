package itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SystemUserDto {
  private Long id;
  private String name;
  private String family;
  private String email;
  private String password;
  private Long branchId;
  private String branchName;
  private Long subdivisionId;
  private String subdivisionName;

  public SystemUserDto(Long id,
                       String name,
                       String family,
                       String email,
                       String password,
                       String branchName,
                       String subdivisionName) {
    this.id = id;
    this.name = name;
    this.family = family;
    this.email = email;
    this.password = password;
    this.branchName = branchName;
    this.subdivisionName = subdivisionName;
  }
}
