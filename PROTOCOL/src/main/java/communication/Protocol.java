package communication;

public class Protocol {
    public static final String SERVER = "localhost";
    public static final int PORT = 1234;
    
    /**
     *
     */
    public static final int LOGIN=2;
    public static final int LOGOUT =5 ;
    public static final int RETIRO=3;
    public static final int PASSWORD=4;
    public static final int SALDO=6;
    public static final int STATUS_OK=0;
    public static final int STATUS_ERROR=1;
}
