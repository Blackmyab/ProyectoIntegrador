package app.myab.huariques.Util;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import app.myab.huariques.Model.Carrito;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Myapp  extends Application {
    //autoincrementable
    public static AtomicInteger carritoID=new AtomicInteger();

    //variable inicializadas
   @Override
    public void onCreate() {
        setUpRealmConfig();

        Realm realm=Realm.getDefaultInstance();
        carritoID=getidTable(realm, Carrito.class);


        super.onCreate();
    }

    private void setUpRealmConfig(){
        Realm.init(this);
        RealmConfiguration config=new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
    private <T extends RealmObject>AtomicInteger getidTable(Realm realm,Class<T>anyClass){
        RealmResults<T> results=realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }
}
