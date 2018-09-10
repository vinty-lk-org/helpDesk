package itacademy.domain.services;

import itacademy.domain.dao.impl.CategoryDaoImpl;
import itacademy.domain.services.interfaces.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private static final Object LOCK = new Object();
    private static CategoryServiceImpl INSTANCE = null;

    public static CategoryServiceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryServiceImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void deletePtoblem(Long id) {
        CategoryDaoImpl.getInstance().delete(id);
    }
}