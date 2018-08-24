package itacademy.domainModel.dao.interfaces;

import itacademy.domainModel.entity.Branch;

import java.util.List;

public interface BranchDao {

    Branch findById(Long id);

    Long save(Branch branch);

    List<Branch> findAll();

}
