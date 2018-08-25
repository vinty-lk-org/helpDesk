package itacademy.domain.dao.interfaces;

import itacademy.domain.entity.Branch;

import java.util.List;

public interface BranchDao {

    Branch findById(Long id);

    Long save(Branch branch);

    List<Branch> findAll();

    void delete(Long id);
    }