package servlets.adminpage.handbookservlet;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;

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
}