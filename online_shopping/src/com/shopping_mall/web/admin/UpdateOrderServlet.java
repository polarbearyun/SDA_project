package com.shopping_mall.web.admin;

        import com.shopping_mall.common.Params;
        import com.shopping_mall.entity.Order;
        import com.shopping_mall.entity.Price;
        import com.shopping_mall.entity.Product;
        import com.shopping_mall.security.AuthenticationEnforcer;
        import com.shopping_mall.service.OrderService;
        import com.shopping_mall.service.ProductService;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet("/admin/editOrder")
public class UpdateOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"editOrder")== Params.HAS_RIGHT) {

            Integer id = Integer.valueOf(request.getParameter("id"));
            Integer status = Integer.valueOf(request.getParameter("status"));
            String number = request.getParameter("number");
            Integer userId = Integer.valueOf(request.getParameter("user_id"));
            Integer total_price = Integer.valueOf(request.getParameter("total_price"));
            String remark = request.getParameter("remark");


            Order newOrder = new Order();

            newOrder.setId(id);
            newOrder.setStatus(status);
            newOrder.setRemark(remark);
            newOrder.setTotal_price(total_price);
            newOrder.setUser_id(userId);
            newOrder.setNumber(number);


            OrderService service = new OrderService();
            service.updateOrder(newOrder);

            response.sendRedirect(request.getContextPath() + "/admin/order_list");
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }
    }
}

