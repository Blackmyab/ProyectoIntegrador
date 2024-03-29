package app.myab.huariques.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.myab.huariques.Adapter.VentasAdapter;
import app.myab.huariques.Api.Api;
import app.myab.huariques.Api.RequestHandler;
import app.myab.huariques.Model.Ventas;
import app.myab.huariques.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VentasFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Ventas> ventasList;

    public VentasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ventas, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewVentas);
        ventasList = new ArrayList<>();
        readVentas();
        //renderiza la info y muestra en una lista en el cardview
        return view;
    }

    private void readVentas(){
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_VENTAS, null, Api.CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshContenidoList(JSONArray contenido) throws JSONException{
        //limpiar las noticias anteriores
        ventasList.clear();

        //recorrer todos los elementos de la matriz json
        //del json que recibimos la respuesta

        for(int i = 0; i < contenido.length(); i++){
            //obtener el json de nuestros productos
            JSONObject obj = contenido.getJSONObject(i);

            //añadiendo los productos de nuestro json a la clase ventas
            ventasList.add(new Ventas(
                    obj.getInt("id"),
                    obj.getString("usuario"),
                    obj.getString("producto"),
                    obj.getString("imagen"),
                    obj.getDouble("costo"),
                    obj.getString("fecha")
            ));
        }

        //crear el adaptador y configurar en la vista nuestra lista de informacion que llega en el formato json
        mLayoutManager = new LinearLayoutManager(getActivity());
        //CardView
        mAdapter = new VentasAdapter(ventasList, R.layout.card_view_ventas);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

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

        //este metodo dara la respuesta de la peticion

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if(!object.getBoolean("error")){
                    //refrescar la lista despues de cada operacion
                    //para que obtengamos una lista actualizada
                    refreshContenidoList(object.getJSONArray("contenido"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        //la operacion de red se realizara en segundo plano
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




