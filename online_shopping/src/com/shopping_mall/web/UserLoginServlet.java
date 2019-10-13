package com.shopping_mall.web;

import com.shopping_mall.common.Params;
import com.shopping_mall.common.Session;
import com.shopping_mall.entity.Address;
import com.shopping_mall.entity.User;
import com.shopping_mall.entity.Order;
import com.shopping_mall.security.AuthenticationEnforcer;
import com.shopping_mall.service.AddressService;
import com.shopping_mall.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * User Login Servlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the committed data from web page
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // deal with business logic
        UserService userService = new UserService();
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // GOTO
        if(user != null){
            if(user.getPassword().equals(password)) {
                //login success
                if (user.getType() == 0){

                    Session.getInstance().createSession(request.getSession(),0,user.getId());
                    //record user data in this session
                    request.getSession().setAttribute("curr_mbr", user);

                // If the user login when commit order, then goto /order.jsp
                // If not, goto the user profile page after login
                Order order = (Order) request.getSession().getAttribute("current_order");
                    if (order != null) {
                    AddressService addressService = new AddressService();
                    List<Address> addressList = null;
                    addressList = addressService.viewAllAddressOfUser(user.getId());

                    request.setAttribute("addressList", addressList);

                    request.getRequestDispatcher("/orderConfirm.jsp").forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/user/orders");
                    }
                }else {
                    Session.getInstance().createSession(request.getSession(),2,user.getId());
                    request.getSession().setAttribute("curr_mbr", user);
                    response.sendRedirect(request.getContextPath() + "/admin/product");
                }

            }else{
                // Wrong password
                request.setAttribute("msg", "Email not exist or Password wrong！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else{ // Email does not exist
            request.setAttribute("msg", "Email not exist or Password wrong！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}


