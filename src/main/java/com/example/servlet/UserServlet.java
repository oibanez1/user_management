package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet blah blah.
 */

import com.example.dao.UserDAO;
import com.example.model.User;

@WebServlet(description = "servlet one", urlPatterns = { "/app" })
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
     /**
      * new obj to have for the db connection.
      */
     public void init(){
         userDAO = new UserDAO();
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        String path = request.getServletPath();
        try{
            if(path.equals("/new")){
                newForm(request, response);
            }
            else if(path.equals("/add")){
                addUser(request, response);
            }
            else if(path.equals("/delete")){
                deleteUser(request, response);
            }
            else if(path.equals("/edit")){
                editForm(request, response);
            }
            else if(path.equals("/update")){
                updateUser(request, response);
            }
            else {
                allUsers(request, response);
            }
        }catch (ServletException ex){
            System.out.println(ex);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        doGet(request, response);
    }

    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User selectedUser = userDAO.get(id);
        request.setAttribute("selectedUser", selectedUser);
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }

    private void allUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<User> userList = userDAO.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/all_users.jsp").forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));
        User newUser = new User(name, email, country, age);
        userDAO.add(newUser);
        response.sendRedirect("list");
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name  = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(id, name, email, country, age);
        userDAO.update(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        response.sendRedirect("list");
    }

}
