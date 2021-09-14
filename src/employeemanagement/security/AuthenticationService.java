package employeemanagement.security;

import java.util.Base64;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public class AuthenticationService {

	
	
	private static Map http_headers;
	
	public static void authentication(WebServiceContext wsctx) {
        MessageContext mctx = wsctx.getMessageContext();
       http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        
        

 
        LinkedList list = (LinkedList) http_headers.get("Authorization");
        if (list == null || list.size() == 0) {
            throw new RuntimeException("Authentication failed! This WS needs BASIC Authentication!");
        }
        
    	System.out.println("====== "+http_headers.get("CONSUMER_ID"));
    	System.out.println("====== "+http_headers.get("CONTEXT_ID"));
    	System.out.println("//////// "+http_headers.get("DP_AUTH_TYPE"));
 
        String userpass = (String) list.get(0);
        userpass = userpass.substring(5);
        validateUserPwd(userpass);
    }
 
    private static void validateUserPwd(String userpass) {
        String credentials = new String(Base64.getMimeDecoder().decode(userpass.getBytes()));
 
        String username = null;
        String password = null;
        int colonPos = credentials.indexOf(":");
        if (colonPos > -1) {
            username = credentials.substring(0, colonPos);
            password = credentials.substring(colonPos + 1);
            
            
             
            if (!(username.equalsIgnoreCase("JDE") && password.equals("jde"))) {
            


                
                throw new RuntimeException("Not Authentication for " + username + ":" + password);
            }
        } else {
            throw new RuntimeException("There was an error while decoding the Authentication!");
        }
    }
}
