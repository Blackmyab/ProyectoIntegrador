package app.myab.huariques.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.myab.huariques.Adapter.ProductosAdapter;
import app.myab.huariques.Api.Api;
import app.myab.huariques.Api.RequestHandler;
import app.myab.huariques.Model.Productos;
import app.myab.huariques.R;
import app.myab.huariques.Util.SharedPrefManager;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Productos> productosList;

    private MenuItem loginMenuItem;
    private MenuItem signInMenuItem;
    private MenuItem administrativoMenuItem;
    private MenuItem perfilMenuItem;
    private MenuItem salirMenuItem;

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewProductos);
        productosList = new ArrayList<>();
        readProductos();

    }
    private void setToolbar(){
        myToolbar=findViewById(R.id.toolbarProductos);
        setSupportActionBar(myToolbar);
    }

    private void readProductos(){
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_PRODUCTOS, null, Api.CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshContenidoList(JSONArray contenido) throws JSONException {
        //limpiar las noticias anteriores
        productosList.clear();

        //recorrer todos los elementos de la matriz json
        //del json que recibimos la respuesta

        for(int i = 0; i < contenido.length(); i++){
            //obtener el json de nuestros productos
            JSONObject obj = contenido.getJSONObject(i);

            //añadiendo los productos ala lista
            productosList.add(new Productos(
                    obj.getInt("id"),
                    obj.getString("titulo"),
                    obj.getString("descripcion"),
                    obj.getString("contenido"),
                    obj.getString("imagen"),
                    obj.getDouble("precio"),
                    obj.getDouble("calificacion"),
                    obj.getInt("categoria")
            ));
        }

        //crear el adaptador y configurar en la vista nuestra lista de informacion que llega en el formato json
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new ProductosAdapter(productosList, R.layout.card_view_productos, new ProductosAdapter.OnClickListener() {
            @Override
            public void onItemClick(Productos productos, int position) {
                //Ver Productos
                String precio =String.valueOf(productos.getPrecio());
                Intent intent=new Intent(MainActivity.this,VerProductoActivity.class);
                intent.putExtra("id",productos.getId());
                intent.putExtra("titulo",productos.getTitulo());
                intent.putExtra("descripcion",productos.getDescripcion());
                intent.putExtra("precio",precio);
                intent.putExtra("contenido",productos.getContenido());
                intent.putExtra("imagen",productos.getImagen());
                startActivity(intent);

            }
        }, new ProductosAdapter.OnLongClickListener() {
            @Override
            public void onItemClick(Productos productos, int position) {
                Toast.makeText(MainActivity.this, "Click Largo", Toast.LENGTH_SHORT).show();
            //Eliminar Productos administrador,agregar productos como cliente
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        this.loginMenuItem = menu.findItem(R.id.loginActionBar);
        this.signInMenuItem = menu.findItem(R.id.signInActionBar);
        this.perfilMenuItem = menu.findItem(R.id.perfilActionBar);
        this.administrativoMenuItem = menu.findItem(R.id.administrativoActionBar);
        this.salirMenuItem = menu.findItem(R.id.logOutActionBar);

        if(SharedPrefManager.getmInstance(MainActivity.this).isLoggedIn()){

            if(SharedPrefManager.getmInstance(MainActivity.this).getUser().getRole().equals("administrador")){
                this.loginMenuItem.setVisible(false);
                this.signInMenuItem.setVisible(false);
                this.perfilMenuItem.setVisible(false);
                this.administrativoMenuItem.setVisible(true);
                this.salirMenuItem.setVisible(true);
            }else{
                this.loginMenuItem.setVisible(false);
                this.signInMenuItem.setVisible(false);
                this.perfilMenuItem.setVisible(true);
                this.administrativoMenuItem.setVisible(false);
                this.salirMenuItem.setVisible(true);
            }

        }else{
            this.loginMenuItem.setVisible(true);
            this.signInMenuItem.setVisible(true);
            this.perfilMenuItem.setVisible(false);
            this.administrativoMenuItem.setVisible(false);
            this.salirMenuItem.setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.loginActionBar:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;

            case R.id.signInActionBar:
                startActivity(new Intent(MainActivity.this, RegistrarseActivity.class));
                return true;

            case R.id.logOutActionBar:
                SharedPrefManager.getmInstance(MainActivity.this).logOut();
                return true;
            case R.id.administrativoActionBar:
                startActivity(new Intent(MainActivity.this, AdministradorActivity.class));
                return true;
            case R.id.perfilActionBar:
                startActivity(new Intent(MainActivity.this, PerfilActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //clase interna para realizar la solicitud de red extendiendo un AsyncTask
    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {

        //la url donde nececitamos enviar la solicitud
        String url;

        //parametros
        HashMap<String, String> params;

        //el codigo de solicitud para definir si se trata de un GET o POST
        int requestCode;

        //contructor para inicializar los valores
        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode){
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        //Este metodo dara repuesta ala peticion

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if(!object.getBoolean("error")){
                    //refrescar la lista despues de la operacion
                    //para que obtengamos una lista actualizada
                    refreshContenidoList(object.getJSONArray("contenido"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        //La oprecions e realizara en segundo plano
        @Override
        protected String doInBackground(Void... voids) {

            RequestHandler requestHandler = new RequestHandler();

            if(requestCode == Api.CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);

            if ((requestCode == Api.CODE_GET_REQUEST))
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }
}
