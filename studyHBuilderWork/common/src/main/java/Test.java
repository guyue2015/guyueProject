
public class Test {    
    public static void main(String[] args) {    
        String nm = (String) java.security.AccessController.doPrivileged    
        (new sun.security.action.GetPropertyAction    
         ("java.awt.graphicsenv", null));    
        System.out.println(nm);    
        try {    
            Class.forName(nm).newInstance();    
        } catch (Throwable e) {    
            System.out.println("error=" + e.getClass().getName());    
                
            e.printStackTrace();    
        }     
    }    
}   