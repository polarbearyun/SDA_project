package com.shopping_mall.security;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AuthorizationEnforcer {
    public static int checkAuthorisation(HttpServletRequest request, String command) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("curr_mbr");

            return AuthorizationProvider.checkAuthorisation(command, user);

        }
}
