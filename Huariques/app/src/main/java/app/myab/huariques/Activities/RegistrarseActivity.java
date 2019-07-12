package app.myab.huariques.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import app.myab.huariques.Api.Api;
import app.myab.huariques.Api.RequestHandler;
import app.myab.huariques.R;

public class RegistrarseActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText usuario;
    private EditText password;
    private EditText mail;

    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuario = (EditText)findViewById(R.id.editTextUsuarioRegistro);
        password = (EditText)findViewById(R.id.editTextPasswordLogin);
        mail = (EditText)findViewById(R.id.editTextMailLogin);
        registrarse = (Button)findViewById(R.id.buttonLogin);

        registrarse.setOnClickListener(this);
    }

    private void createUsuario(){
        String usu = usuario.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String email = mail.getText().toString().trim();

        if(TextUtils.isEmpty(usu)){
            usuario.setError(getString(R.string.escribe_tu_nombre_label));
            usuario.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(email)){
            mail.setError(getString(R.string.escribe_tu_correo_electronico_label));
            mail.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            password.setError(getString(R.string.escribe_una_contraseña_label));
            password.requestFocus();
            return;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("usuario", usu);
        params.put("password", pass);
        params.put("role", "cliente");
        params.put("mail", email);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_USUARIO, params, Api.CODE_POST_REQUEST);
        request.execute();

        Toast.makeText(RegistrarseActivity.this, getString(R.string.usuario_registrado_label), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        createUsuario();
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
