package itacademy.domain.dao.impl;

import itacademy.domain.dao.interfaces.TaskOperatorDao;
import itacademy.domain.entity.Branch;
import itacademy.domain.entity.Task;
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
}

