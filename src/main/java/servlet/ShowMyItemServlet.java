package servlet;

import manager.ItemManager;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/get/myItem")
public class ShowMyItemServlet extends HttpServlet {


    ItemManager itemManager = new ItemManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Item> myItem = itemManager.getMyItemById(user.getId());
        req.setAttribute("myItem", myItem);
        req.getRequestDispatcher("/WEB-INF/showMyItem.jsp").forward(req, resp);
    }
}
