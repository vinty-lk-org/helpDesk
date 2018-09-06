package itacademy.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
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
  private Long usersIdPrivilegesId;

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

  public SystemUserDto(String name,
                       String family,
                       String email,
                       String password,
                       Long branchId,
                       Long subdivisionId) {
    this.name = name;
    this.family = family;
    this.email = email;
    this.password = password;
    this.branchId = branchId;
    this.subdivisionId = subdivisionId;
  }

  public SystemUserDto(SystemUserDto build) {
    this.name = build.getName();
    this.family = build.getFamily();
    this.email = build.getEmail();
    this.password = build.getPassword();
    this.branchId = build.getBranchId();
    this.subdivisionId = build.getSubdivisionId();
  }
}
