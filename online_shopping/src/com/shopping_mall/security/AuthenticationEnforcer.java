package com.shopping_mall.security;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationEnforcer {
    public static int checkAuthentication(HttpServletRequest request, String command) {


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("curr_mbr");

        //member
        if (user == null) {
            return AuthorizationEnforcer.checkAuthorisation(request, command);
        }

        if (user.getType() == Params.MEMBER_CODE) {

            if (UserStore.memberList.contains(user)) {
                return AuthorizationEnforcer.checkAuthorisation(request,command);
            }
            else {
                UserStore.memberList.add(user);
                return AuthorizationEnforcer.checkAuthorisation(request, command);
            }
        }

        //admin
        else if (user.getType() == Params.ADMIN_CODE) {
            if (UserStore.adminList.contains(user)) {
                return AuthorizationEnforcer.checkAuthorisation(request,command);
            }else {
                UserStore.adminList.add(user);
                return AuthorizationEnforcer.checkAuthorisation(request,command);
            }

        }

        else {
            return Params.INVALID_CODE;
        }

    }


}
