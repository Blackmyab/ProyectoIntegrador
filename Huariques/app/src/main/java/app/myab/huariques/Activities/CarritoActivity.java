package app.myab.huariques.Activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import app.myab.huariques.Model.Carrito;
import app.myab.huariques.R;
import app.myab.huariques.Util.SharedPrefManager;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class CarritoActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Carrito>>, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Realm realm;
    private RealmResults<Carrito> carritoList;

    private FloatingActionButton fab;

    private MenuItem loginMenuItem;
    private MenuItem signInMenuItem;
    private MenuItem perfilMenuItem;
    private MenuItem salirMenuItem;

    private Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        setToolbar();



        mRecyclerView =findViewById(R.id.recyclerViewCarrito);
        fab = findViewById(R.id.fabCarrito);



        if(SharedPrefManager.getmInstance(CarritoActivity.this).isLoggedIn()){
            fab.setImageResource(R.mipmap.ic_ventas_on);
        }else {
            fab.setImageResource(R.mipmap.ic_venta_off);
        }

        fab.setOnClickListener(this);
        setHideShowFAB();

        realm = Realm.getDefaultInstance();
        carritoList = realm.where(Carrito.class).findAll();
        carritoList.addChangeListener(this);


    }

    private void setHideShowFAB() {
    }

    private void setToolbar() {

        myToolbar =findViewById(R.id.toolbarCarritoMenu);
        setSupportActionBar(myToolbar);
    }
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onChange(RealmResults<Carrito> carritos) {

    }


}
