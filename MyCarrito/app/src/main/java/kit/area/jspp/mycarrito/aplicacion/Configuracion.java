package kit.area.jspp.mycarrito.aplicacion;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by PEPE on 07/09/2016.
 */
public class Configuracion extends Application {

    public static String   ID = "id";
    public static String  IDPROD = "idprod";

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        Fresco.initialize(this);

        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder(this)
                        .name("jspp.realm")
                        .schemaVersion(1)
                        .build();

        //Añadimos la configuración a nuestro proyecto
        Realm.setDefaultConfiguration(realmConfiguration);
    }


}
