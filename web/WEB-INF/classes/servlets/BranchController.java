package servlets;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.dto.TaskDto;
import itacademy.services.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/branchSave")

public class BranchController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BranchDaoImpl.getInstance().save(getReqForCreateBranch(req));
        resp.sendRedirect("/adminFillPage");
    }

    private Branch getReqForCreateBranch(HttpServletRequest request) {
        return new Branch(Branch.builder()
                .name(request.getParameter("nameBranch"))
                .address(request.getParameter("addressBranch"))
                .build());
    }


//    private TaskDto getReqForCreateTaskDto(HttpServletRequest request) {
//        return new TaskDto(TaskDto.builder()
//                .name(request.getParameter("nameTask"))
//                .text(request.getParameter("textUser"))
//                .build());
//    }
}