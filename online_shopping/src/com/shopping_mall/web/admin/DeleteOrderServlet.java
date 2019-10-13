package com.shopping_mall.web.admin;

        import com.shopping_mall.common.Params;
        import com.shopping_mall.entity.Order;
        import com.shopping_mall.entity.Product;
        import com.shopping_mall.mapper.ProductMapper;
        import com.shopping_mall.security.AuthenticationEnforcer;
        import com.shopping_mall.service.OrderService;
        import com.shopping_mall.service.ProductService;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet("/admin/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"deleteOrder") == Params.HAS_RIGHT) {

            String order_id = request.getParameter("id");
            int id = Integer.parseInt(order_id);
            OrderService service = new OrderService();
            Order order = service.findById(id);
            order.setStatus(8);


            service.updateOrder(order);

            response.sendRedirect(request.getContextPath() + "/admin/order_list");
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }

    }
}
