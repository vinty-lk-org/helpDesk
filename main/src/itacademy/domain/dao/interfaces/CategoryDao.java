package itacademy.domain.dao.interfaces;

import itacademy.domain.dao.common.BaseDao;
import itacademy.domain.entity.Category;

public interface CategoryDao extends BaseDao {

   void update(Category category);

}