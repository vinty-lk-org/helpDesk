package itacademy.domain.dao.impl;

import itacademy.domain.dao.interfaces.TaskOperatorDao;
import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Category;
import itacademy.domain.entity.Task;
import itacademy.domain.services.TaskServiceImpl;
import itacademy.dto.models.TaskOperatorDto;
import itacademy.dto.models.TaskOperatorShortDto;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TaskOperatorDaoImplTest {

    @Test
    public void findAllShortOperator() {
        List<TaskOperatorShortDto> operatorDaoList = TaskOperatorDaoImpl.getInstance().findAllShortOperator(294L);
        for (TaskOperatorShortDto taskOperatorShortDto : operatorDaoList) {
            System.out.println(taskOperatorShortDto);
        }
    }

    @Test
    public void findByIdOperatorTask() {
        Optional<TaskOperatorDto> dtoList = TaskOperatorDaoImpl.getInstance().findByIdOperatorTask(227L);
        System.out.println(dtoList);
    }

    @Test
    public void updateStatus() {
        TaskOperatorDaoImpl dao = TaskOperatorDaoImpl.getInstance();
        TaskOperatorDto taskOperatorDto = new TaskOperatorDto(257L,4L);
        dao.updateStatus(taskOperatorDto);
    }

    @Test
    public void updateExecutor() {
        TaskOperatorDaoImpl dao = TaskOperatorDaoImpl.getInstance();
        TaskOperatorDto taskOperatorDto = new TaskOperatorDto();
        taskOperatorDto.setExecutorId(274L);
        taskOperatorDto.setTaskId(257L);
        dao.updateExecutor(taskOperatorDto);
    }

    @Test
    public void update() {
        CategoryDaoImpl dao = CategoryDaoImpl.getInstance();
        Category category = new Category(4L,"77777");
        dao.update(category);
    }

}

