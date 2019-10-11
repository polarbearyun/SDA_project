package com.shopping_mall.web.admin;

        import com.shopping_mall.entity.Order;
        import com.shopping_mall.entity.Product;
        import com.shopping_mall.mapper.ProductMapper;
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
        String order_id = request.getParameter("id");
        int id = Integer.parseInt(order_id);

        Order order = new Order();
        order.setId(id);

        OrderService service = new OrderService();
        service.deleteOrder(order);

        response.sendRedirect(request.getContextPath() + "/admin/order_list");

    }
}