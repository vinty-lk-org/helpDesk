package itacademy.domain.dao.impl;

import itacademy.domain.entity.Category;
import itacademy.domain.entity.Listener;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CategoryDaoImplTest {

    @Test
    public void update() {
        CategoryDaoImpl dao = CategoryDaoImpl.getInstance();
        Category category = new Category(4L,"77777");
        dao.update(category);
    }

    @Test
    public void findById() {
        Optional<Category> categoryId = CategoryDaoImpl.getInstance().findById(8L);
        System.out.println(categoryId);
    }
}