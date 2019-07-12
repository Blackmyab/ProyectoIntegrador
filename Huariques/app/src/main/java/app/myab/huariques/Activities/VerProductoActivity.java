package app.myab.huariques.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import app.myab.huariques.Api.Api;
import app.myab.huariques.Model.Carrito;
import app.myab.huariques.R;
import app.myab.huariques.Util.SharedPrefManager;
import io.realm.Realm;
import io.realm.RealmResults;

public class VerProductoActivity extends AppCompatActivity {


    private TextView titulo;
    private TextView descripcion;
    private TextView precio;
    private TextView contenido;

    private ImageView imagen;

    private MenuItem loginMenuItem;
    private MenuItem signInMenuItem;
    private MenuItem carritoMenuItem;
    private MenuItem administrativoMenuItem;
    private MenuItem perfilMenuItem;
    private MenuItem salirMenuItem;


    //variables carrito
    private int Keyid;
    private String Keytitulo;
    private String Keyimagen;
    private double Keycosto;

    //Variables para aregar al carrito
    private Realm realm;
    //LLAMAR INFORMACION CON REALM
    private RealmResults <Carrito> carritoList;





    private Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);
        setToolbar();

        //traemos los items
        Bundle bundle=getIntent().getExtras();
        inicializacion();

        realm=Realm.getDefaultInstance();
        carritoList=realm.where(Carrito.class).findAll();
        Toast.makeText(VerProductoActivity.this,"cuantos productos en el carrito" +carritoList.size(),
                Toast.LENGTH_SHORT).show();


        Keyid=bundle.getInt("id");
        Keytitulo=bundle.getString("titulo");
        Keyimagen=bundle.getString("imagen");
        Keycosto=Double.parseDouble(bundle.getString("precio"));

        titulo.setText(Keytitulo);
        descripcion.setText(bundle.getString("descripcion"));
        precio.setText("precio : " + Keycosto);
        contenido.setText(bundle.getString("contenido"));

        //cargamos la imagen
        Picasso.get().load(Api.GALERIA+Keyimagen).fit().into(imagen);

    }


    private void setToolbar(){
        myToolbar =findViewById(R.id.toolbarProductos);
        setSupportActionBar(myToolbar);
    }


    public void inicializacion(){
        titulo=findViewById(R.id.textViewVerTitulo);
        descripcion=findViewById(R.id.textViewVerDescripcion);
        precio=findViewById(R.id.textViewVerPrecio);
        contenido=findViewById(R.id.textViewVerContenido);

        imagen=findViewById(R.id.imagenViewVerProducto);


    }
    //agregar carrito
    private void agregarProductoCarrito(String producto,String imagen,Double costo){

        realm.beginTransaction();
        Carrito carrito=new Carrito(producto,imagen,costo);
        realm.copyToRealm(carrito);
        realm.commitTransaction();
    }

    //llamando al metodo para el menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu_ver_producto, menu);
        this.loginMenuItem = menu.findItem(R.id.loginActionBar);
        this.signInMenuItem = menu.findItem(R.id.signInActionBar);
        this.carritoMenuItem=menu.findItem(R.id.verProductoActionBar);
        this.perfilMenuItem = menu.findItem(R.id.perfilActionBar);
        this.administrativoMenuItem = menu.findItem(R.id.administrativoActionBar);
        this.salirMenuItem = menu.findItem(R.id.logOutActionBar);

        if(SharedPrefManager.getmInstance(VerProductoActivity.this).isLoggedIn()){

            if(SharedPrefManager.getmInstance(VerProductoActivity.this).getUser().getRole().equals("administrador")){
                this.loginMenuItem.setVisible(false);
                this.signInMenuItem.setVisible(false);
                this.perfilMenuItem.setVisible(false);
                this.administrativoMenuItem.setVisible(true);
                this.salirMenuItem.setVisible(true);
                this.carritoMenuItem.setVisible(false);
            }else{
                this.loginMenuItem.setVisible(false);
                this.signInMenuItem.setVisible(false);
                this.perfilMenuItem.setVisible(true);
                this.administrativoMenuItem.setVisible(false);
                this.salirMenuItem.setVisible(true);
                this.carritoMenuItem.setVisible(true);
            }

        }else{
            this.loginMenuItem.setVisible(true);
            this.signInMenuItem.setVisible(true);
            this.perfilMenuItem.setVisible(false);
            this.administrativoMenuItem.setVisible(false);
            this.salirMenuItem.setVisible(false);
            this.carritoMenuItem.setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.loginActionBar:
                startActivity(new Intent(VerProductoActivity.this, LoginActivity.class));
                return true;

            case R.id.signInActionBar:
                startActivity(new Intent(VerProductoActivity.this, RegistrarseActivity.class));
                return true;

            case R.id.logOutActionBar:
                SharedPrefManager.getmInstance(VerProductoActivity.this).logOut();
                return true;
            case R.id.administrativoActionBar:
                startActivity(new Intent(VerProductoActivity.this, AdministradorActivity.class));
                return true;
            case R.id.perfilActionBar:
                startActivity(new Intent(VerProductoActivity.this, PerfilActivity.class));
                return true;
            case R.id.verProductoActionBar:
                if(SharedPrefManager.getmInstance(VerProductoActivity.this).isLoggedIn()
                    && SharedPrefManager.getmInstance(VerProductoActivity.this).getUser().getRole().equals("cliente")){
                    //codigo del carrito
                    agregarProductoCarrito(Keytitulo,Keyimagen,Keycosto);

                    Toast.makeText(VerProductoActivity.this,"Agregado en el carrito" ,Toast.LENGTH_SHORT).show();


                }else{

                    Toast.makeText(VerProductoActivity.this,"Administrador",Toast.LENGTH_LONG).show();
                }
               return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
