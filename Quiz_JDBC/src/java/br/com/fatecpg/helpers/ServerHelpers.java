/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.helpers;

import com.fatecpg.data.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jeffersoncn
 */
public class ServerHelpers {
    public static String getRootPath(HttpServletRequest request) {
        return String.format("http://%s:%d%s", request.getServerName(), request.getServerPort(), request.getContextPath());
    }
    
    public static boolean isLogged(Usuario usuario){
        if (usuario == null){
            return false;
        } else{
            return true;
        }
    }
    
    public static boolean isAdminLogged(Usuario usuario){
        if (usuario != null && usuario.isAdmin()){
            return true;
        } else{
            return false;
        }
    }
}
