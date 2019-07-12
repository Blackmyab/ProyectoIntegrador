package app.myab.huariques.Api;

public class Api {

   // http://localhost/huariques/views/huariques.api/Api.php
    //http://192.168.0.12/huariques/views/huariques.api/Api.php?apicall=readproductos

    private static final String URL_BASE = "http://192.168.0.3/huariques-a/";
    private static final String ROOT_URL = URL_BASE + "views/huariques.api/Api.php?apicall=";

    //usuarios
    public static final String URL_CREATE_USUARIO = ROOT_URL + "createusuario";
    public static final String URL_LOGIN_USUARIO = ROOT_URL + "loginusuario";
    public static final String URL_READ_USUARIOS = ROOT_URL + "readusuarios";

    //productos
    public static final String URL_READ_PRODUCTOS = ROOT_URL + "readproductos";

    //ventas
    public static final String URL_READ_VENTAS= ROOT_URL + "readventas";
    public static final String URL_READ_VENTAS_ESPECIFICAS = ROOT_URL + "readventasespecificas&usuario=";
    //categoria
    public static final String URL_CREATE_CATEGORIA = ROOT_URL + "createcategoria";
    public static final String URL_READ_CATEGORIA = ROOT_URL + "readcategorias";
    public static final String URL_UPDATE_CATEGORIA = ROOT_URL + "updatecategoria";
    public static final String URL_DELETE_CATEGORIA = ROOT_URL + "deletecategoria&id=";



    //galeria
    public static  final String GALERIA = URL_BASE + "backend/";

    //request codes
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;

}
