package app.myab.huariques.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.myab.huariques.Api.Api;
import app.myab.huariques.Api.RequestHandler;
import app.myab.huariques.Model.Ventas;
import app.myab.huariques.R;
import app.myab.huariques.Util.SharedPrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteFragment extends Fragment {

    private View view;

    private TextView perfilNombre;
    private TextView montoTotalProducto;
    private TextView cantidadTotalProducto;

    private List<Ventas> ventasList;

    public ClienteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cliente, container, false);
        inicializaciones();
        ventasList = new ArrayList<>();
        perfilNombre.setText(SharedPrefManager.getmInstance(getContext()).getUser().getUsuario());
        readVentas(SharedPrefManager.getmInstance(getContext()).getUser().getId());
        return view;
    }

    public void inicializaciones(){
        perfilNombre = (TextView)view.findViewById(R.id.textViewPerfilNombre);
        montoTotalProducto = (TextView)view.findViewById(R.id.textViewPerfilMontoProductos);
        cantidadTotalProducto = (TextView)view.findViewById(R.id.textViewPerfilCantidadProductos);
    }

    public String contadorProductosVendidos(List<Ventas> ventas){
        String resultado = (ventas.size() == 1) ? "producto":"productos";
        String texto = ventas.size()+ " " + resultado;
        return texto;
    }

    public String monotoTotal(List<Ventas> ventas){

        double montoTotal = 0;
        for (int i = 0; i < ventas.size(); i++) {
            montoTotal += ventas.get(i).getCosto();
        }

        String resultado = (ventas.size() < 1) ? "0 soles" : montoTotal + " soles";
        return resultado;
    }

    private void readVentas(int id){
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_VENTAS_ESPECIFICAS + id,
                null, Api.CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshContenidoList(JSONArray contenido) throws JSONException {
        //limpiar las noticias anteriores
        ventasList.clear();

        //recorrer todos los elementos de la matriz json
        //del json que recibimos la respuesta

        for(int i = 0; i < contenido.length(); i++){
            //obtener el json de nuestros productos
            JSONObject obj = contenido.getJSONObject(i);

            //aÃ±adiendo los productos de nuestro json a la clase productos
            ventasList.add(new Ventas(
                    obj.getInt("id"),
                    obj.getString("usuario"),
                    obj.getString("producto"),
                    obj.getString("imagen"),
                    obj.getDouble("costo"),
                    obj.getString("fecha")
            ));
        }

        cantidadTotalProducto.setText(contadorProductosVendidos(ventasList));
        montoTotalProducto.setText(monotoTotal(ventasList));
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

        //este metodo darÃ¡ la respuesta de la peticiÃ³n

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if(!object.getBoolean("error")){
                    //refrescar la lista despues de cada operaciÃ³n
                    //para que obtengamos una lista actualizada
                    refreshContenidoList(object.getJSONArray("contenido"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        //la operacion de red se realizarÃ¡ en segundo plano
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

