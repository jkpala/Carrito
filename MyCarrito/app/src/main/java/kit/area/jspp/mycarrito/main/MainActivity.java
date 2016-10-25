package kit.area.jspp.mycarrito.main;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;
import kit.area.jspp.mycarrito.BaseActivity;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.Utils;
import kit.area.jspp.mycarrito.entities.Category;
import kit.area.jspp.mycarrito.entities.FragmentScreen;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.main.ui.adapters.MainHeadFragmentPageAdapter;
import kit.area.jspp.mycarrito.main.ui.adapters.MainRecyclerViewAdapter;
import kit.area.jspp.mycarrito.main.ui.fragments.MainFragment;
import kit.area.jspp.mycarrito.modelo.logics.LProduct;


public class MainActivity extends BaseActivity {

    @BindView(R.id.tabHome)
    TabLayout mTabHome;
    @BindView(R.id.vpOferta)
    ViewPager mVpOferta;
    Realm realm;
    private MainHeadFragmentPageAdapter mMainHeadFragmentPageAdapter;
    private MainRecyclerViewAdapter mMainRecyclerViewAdapter;



    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recodar Activity.overridePendingTransition()
        //Gone, Visible
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        realm = Realm.getDefaultInstance();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.action_shopping);

        // Obtener drawable del item
        LayerDrawable icon = (LayerDrawable) item.getIcon();
        // EventBus
        // Actualizar el contador
        Utils.setCarritoCantidad(this, icon, 1);

        return true;
    }
    private void initTabs(){
        MainHeadFragmentPageAdapter  adapter;
        adapter = new MainHeadFragmentPageAdapter(getSupportFragmentManager());

        //FragmentStatePagerAdapter

        MainFragment videoFragment = new  MainFragment();
        MainFragment audioFragment = new  MainFragment();
        MainFragment electroFragment = new  MainFragment();
        MainFragment camaraFragment = new  MainFragment();

        Bundle  bundle = new Bundle();
        bundle.putString("categoria","Video");//Video
        videoFragment.setArguments(bundle);
        bundle = null;
        bundle = new Bundle();
        bundle.putString("categoria","Audio");//Audio
        audioFragment.setArguments(bundle);
        bundle = null;
        bundle = new Bundle();
        bundle.putString("categoria","Electro");//Electro
        electroFragment.setArguments(bundle);
        bundle = null;
        bundle = new Bundle();
        bundle.putString("categoria","Camara");//Camara
        camaraFragment.setArguments(bundle);

        adapter.agregarPantalla(new FragmentScreen(videoFragment,"Video"));
        adapter.agregarPantalla(new FragmentScreen(audioFragment,"Audio"));
        adapter.agregarPantalla(new FragmentScreen(electroFragment,"Electro"));
        adapter.agregarPantalla(new FragmentScreen(camaraFragment,"Camara"));
        mVpOferta.setAdapter(adapter);
        mTabHome.setupWithViewPager(mVpOferta);
    }
    private void initProducty(Realm realm) {

        LProduct lProduct = new LProduct();

        Category catCamara = realm.where(Category.class)
                .equalTo("categoryname", "Camara")
                .findFirst();
        Category catElectro = realm.where(Category.class)
                .equalTo("categoryname", "Electro")
                .findFirst();
        Category catVideo = realm.where(Category.class)
                .equalTo("categoryname", "Video")
                .findFirst();
        Category catAudio = realm.where(Category.class)
                .equalTo("categoryname", "Audio")
                .findFirst();

        Product product = new Product();
        product.setIdproduct(Integer.parseInt("1"));
        product.setCodebar("P00001");
        product.setProductname("UHD Smart LED TV SAMSUNG 40");
        product.setProductmodel("UN40JU6000GXPE");
        product.setProductdetail("UHD Smart LED TV SAMSUNG 40");
        product.setNumberview(1);
        product.setPrice(1525.00);
        product.setStock(25);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/8587d4a1fff24d56bff45af4967c455b.jpg");
        product.setCategory(catVideo);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00002");
        product.setProductname("Reproductor Blu-Ray Philips");
        product.setProductmodel("BDP5650/55");
        product.setProductdetail("Reproductor Blu-Ray Philips BDP5650/55-Negro");
        product.setNumberview(1);
        product.setPrice(325.00);
        product.setStock(10);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/35e5e5d72c5d52b17abc41f6195cf40e.png");
        product.setCategory(catVideo);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00003");
        product.setProductname("TELEVISOR LED UN46F8000 SMARTV 3D");
        product.setProductmodel("UN46F8000");
        product.setProductdetail("TELEVISOR LED UN46F8000 SMARTV 3D");
        product.setNumberview(1);
        product.setPrice(5379.00);
        product.setStock(15);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/81c1e49026fe8a247fb4b7ce2d6461ad.jpg");
        product.setCategory(catVideo);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00040");
        product.setProductname("Televisor LG 32LW300C, 32\" LED, HD, 1366 x 768.");
        product.setProductmodel("32LW300C");
        product.setProductdetail("Televisor LG 32LW300C, 32\" LED, HD, 1366 x 768.");
        product.setNumberview(1);
        product.setPrice(690.00);
        product.setStock(600);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/1cf5d7f61e875db795bbc4164fde4afb.png");
        product.setCategory(catVideo);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00004");
        product.setProductname("LG MINICOMPONENTE CM8460 2750W - NEGRO");
        product.setProductmodel("CM8460");
        product.setProductdetail("LG MINICOMPONENTE CM8460 2750W - NEGRO");
        product.setNumberview(1);
        product.setPrice(1318.00);
        product.setStock(10);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/06f6cbaaf3c38dd64ceaf5b448899164.jpg");
        product.setCategory(catAudio);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00005");
        product.setProductname("Sistema de audio");
        product.setProductmodel("FST-GTK37IP");
        product.setProductdetail("Sistema de audio - FST-GTK37IP");
        product.setNumberview(1);
        product.setPrice(679);
        product.setStock(2);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/67e3fccde0e23b869ec2611f26efd3cd.jpg");
        product.setCategory(catAudio);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00006");
        product.setProductname("Samsung - Home Theater Blu Ray Smart 500W");
        product.setProductmodel("HT-J4500K");
        product.setProductdetail("Samsung - Home Theater Blu Ray Smart 500W HT-J4500K");
        product.setNumberview(1);
        product.setPrice(700);
        product.setStock(7);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/55f6af855ad4e46d4eae10ec948652ea.jpg");
        product.setCategory(catAudio);
        lProduct.create(product);
        product =  null;
        product = new Product();
        product.setCodebar("P00007");
        product.setProductname("Refrigeradora LG 356 Litros");
        product.setProductmodel("GT42WGP");
        product.setProductdetail("Refrigeradora LG 356 Litros - GT42WGP");
        product.setNumberview(1);
        product.setPrice(1809);
        product.setStock(3);
        product.setRanking(1);
        product.setUrlimage("http://www.qcompro.pe/uploads/images/full/41a3f2a60ae57a2149d0a322d4eacf73.jpg");
        product.setCategory(catElectro);
        product =  null;
        product = new Product();
        Product product7 = new Product();
        product7.setCodebar("P00008");
        product7.setProductname("Cocina Sole A Gas Dubai - 4 hornillas");
        product7.setProductmodel("COSOL018 Dubai");
        product7.setProductdetail("Cocina Sole A Gas Dubai - 4 hornillas Cosol018");
        product7.setNumberview(1);
        product7.setPrice(1523);
        product7.setStock(3);
        product7.setRanking(1);
        product7.setUrlimage("http://www.qcompro.pe/uploads/images/full/9bbb48c9b9cae0b6659f1a4f83a8d1fa.png");
        product7.setCategory(catElectro);
        lProduct.create(product7);

        Product product8 = new Product();
        product8.setCodebar("P00009");
        product8.setProductname("RAPIDUCHA PERFECT SOLE");
        product8.setProductmodel("SILRD5500C");
        product8.setProductdetail("RAPIDUCHA PERFECT SOLE - SILRD5500C");
        product8.setNumberview(1);
        product8.setPrice(229);
        product8.setStock(14);
        product8.setRanking(1);
        product8.setUrlimage("http://www.qcompro.pe/uploads/images/full/194c6ad27f7705cc6826262cc5f1fd04.jpg");
        product8.setCategory(catElectro);
        lProduct.create(product8);

        Product product9 = new Product();
        product9.setCodebar("P00010");
        product9.setProductname("PowerShot");
        product9.setProductmodel("SX710 HS BLACK");
        product9.setProductdetail("PowerShot SX710 HS");
        product9.setNumberview(1);
        product9.setPrice(789);
        product9.setStock(25);
        product9.setRanking(1);
        product9.setUrlimage("http://www.qcompro.pe/uploads/images/full/194c6ad27f7705cc6826262cc5f1fd04.jpg");
        product9.setCategory(catCamara);
        lProduct.create(product9);

        Product product10 = new Product();
        product10.setCodebar("P00011");
        product10.setProductname("Cámara Canon Reflex EOS T5I KIT 18-55mm");
        product10.setProductmodel("T5I C/ EF-S 18-55MM I");
        product10.setProductdetail("Cámara Fotográfica Reflex EOS T5I KIT 18-55 mm Canon");
        product10.setNumberview(1);
        product10.setPrice(2449);
        product10.setStock(3);
        product10.setRanking(1);
        product10.setUrlimage("http://www.qcompro.pe/uploads/images/full/76af8cf51f3af6934b3f0f3370f75057.jpg");
        product10.setCategory(catCamara);
        lProduct.create(product10);

        Product product11 = new Product();
        product11.setCodebar("P00012");
        product11.setProductname("Cámara Canon Reflex EOS T5I KIT 18-55 mm");
        product11.setProductmodel("T5I C/ EF-S 18-55MM I");
        product11.setProductdetail("Cámara Fotográfica Reflex EOS T5I KIT 18-55 mmCanon");
        product11.setNumberview(1);
        product11.setPrice(2449);
        product11.setStock(3);
        product11.setRanking(1);
        product11.setUrlimage("http://www.qcompro.pe/uploads/images/full/76af8cf51f3af6934b3f0f3370f75057.jpg");
        product11.setCategory(catCamara);
        lProduct.create(product11);
    }
    private void initCategory(Realm realm) {

        realm.beginTransaction();
        Category categoria = realm.createObject(Category.class);
        categoria.setId(Integer.parseInt("1"));
        categoria.setCategoryname("Video");
        realm.commitTransaction();

        realm.beginTransaction();
        Category categoria1 = realm.createObject(Category.class);
        categoria1.setId(Integer.parseInt("2"));
        categoria1.setCategoryname("Audio");
        realm.commitTransaction();

        realm.beginTransaction();
        Category categoria2 = realm.createObject(Category.class);
        categoria2.setId(Integer.parseInt("3"));
        categoria2.setCategoryname("Electro");
        realm.commitTransaction();

        realm.beginTransaction();
        Category categoria3 = realm.createObject(Category.class);
        categoria3.setId(Integer.parseInt("4"));
        categoria3.setCategoryname("Camara");
        realm.commitTransaction();
    }
    private void init() {
        RealmResults<Category> results = realm.where(Category.class).findAll();
        if (results.size() == 0) {
            initCategory(realm);
        }

        RealmResults<Product> resultsProduct = realm.where(Product.class).findAll();
        if (resultsProduct.size() == 0) {
            initProducty(realm);
        }

        initTabs();

    }

}
