package CLIENT;


public class Application {

 
    public static void main(String[] args) {

        CLIENT.presentation.clave.Model modelClave = new CLIENT.presentation.clave.Model();
        CLIENT.presentation.clave.View viewClave = new CLIENT.presentation.clave.View();
        CLIENT.presentation.clave.Controller controllerClave = new CLIENT.presentation.clave.Controller(modelClave, viewClave);
        CLAVE = controllerClave;

        CLIENT.presentation.navegación.Model modelNavegacion = new CLIENT.presentation.navegación.Model();
        CLIENT.presentation.navegación.View viewNavegacion = new CLIENT.presentation.navegación.View();
        CLIENT.presentation.navegación.Controller controllerNavegacion = new CLIENT.presentation.navegación.Controller(modelNavegacion, viewNavegacion);
        NAVEGACION = controllerNavegacion;

        CLIENT.presentation.login.Model modelLogin = new CLIENT.presentation.login.Model();
        CLIENT.presentation.login.View viewLogin = new CLIENT.presentation.login.View();
        CLIENT.presentation.login.Controller controllerLogin = new CLIENT.presentation.login.Controller(modelLogin, viewLogin);
        LOGIN = controllerLogin;

        CLIENT.presentation.retiro.Model modelRetiro = new CLIENT.presentation.retiro.Model();
        CLIENT.presentation.retiro.View viewRetiro = new CLIENT.presentation.retiro.View();
        CLIENT.presentation.retiro.Controller controllerRetiro = new CLIENT.presentation.retiro.Controller(modelRetiro, viewRetiro);
        RETIRO = controllerRetiro;

        LOGIN.show();
    }

    public static CLIENT.presentation.clave.Controller CLAVE;
    public static CLIENT.presentation.navegación.Controller NAVEGACION;
    public static CLIENT.presentation.retiro.Controller RETIRO;
    public static CLIENT.presentation.login.Controller LOGIN;

}
