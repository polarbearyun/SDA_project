package com.shopping_mall.security;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.User;

import java.util.HashMap;
import java.util.Map;

public class AuthorizationProvider {

    public static Map<String, int[]> permissionCollection = new HashMap<String, int[]>();
    static {
        int[] submitOrder = {Params.MEMBER_CODE};
        permissionCollection.put("submitOrder", submitOrder);
        int[] addProduct = {Params.ADMIN_CODE};
        permissionCollection.put("addProduct", addProduct);
        int[] editProduct = {Params.ADMIN_CODE};
        permissionCollection.put("editProduct", editProduct);
        int[] deleteProduct = {Params.ADMIN_CODE};
        permissionCollection.put("deleteProduct", deleteProduct);
        int[] addUser = null;
        permissionCollection.put("addUser", addUser);
        int[] editUser = {Params.ADMIN_CODE,Params.MEMBER_CODE};
        permissionCollection.put("editUser", editUser);
        int[] deleteUser = {Params.ADMIN_CODE};
        permissionCollection.put("deleteUser", deleteUser);
        int[] editOrder = {Params.ADMIN_CODE};
        permissionCollection.put("editOrder", editOrder);
        int[] deleteOrder = {Params.ADMIN_CODE};
        permissionCollection.put("deleteOrder", deleteOrder);

        int[] viewOrders = {Params.ADMIN_CODE};
        permissionCollection.put("viewAllOrders", viewOrders);
        int[] viewUsers = {Params.ADMIN_CODE};
        permissionCollection.put("viewAllUsers", viewUsers);




        int[] login = null;
        permissionCollection.put("login", login);

    }


    public static int checkAuthorisation(String command, User user) {
        int res = Params.NO_RIGHT;
        int user_id;
        //int count = 0;
//        if (user != null){
//            user_id = user.getId();
//        }


        // if the command is invalid
        if (!permissionCollection.containsKey(command)) {
            res = Params.NO_SUCH_COMMAND;
        }else {
            //res = Params.NO_RIGHT;
            int[] permissionList = permissionCollection.get(command);
            // no authentication necessary
            if (permissionList == null) {
                res = Params.HAS_RIGHT;
            } else {
                if(user != null){
                    user_id = user.getType();
                    for (int i = 0; i < permissionList.length; i++) {
                        // if user is authenticated
                        if (permissionList[i] == user_id) {
                            res = Params.HAS_RIGHT;
                        }
                    }
                }else {
                    res = Params.NEED_TO_LOGIN;
                }
            }
        }
        return res;
    }
}
