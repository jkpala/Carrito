package kit.area.jspp.mycarrito.productdetail;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.BaseActivity;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.Utils;
import kit.area.jspp.mycarrito.entities.FragmentScreen;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.modelo.logics.LProduct;
import kit.area.jspp.mycarrito.productdetail.ui.adapters.DeseadoRecyclerViewAdapter;
import kit.area.jspp.mycarrito.productdetail.ui.adapters.ProductDetailAdapter;
import kit.area.jspp.mycarrito.productdetail.ui.fragments.ProductDeseadoFragment;
import kit.area.jspp.mycarrito.productdetail.ui.fragments.ProductDetailFragment;

import static kit.area.jspp.mycarrito.aplicacion.Configuracion.ID;
import static kit.area.jspp.mycarrito.aplicacion.Configuracion.IDPROD;

public class ProductoDetailActivity extends BaseActivity {

    @BindView(R.id.vpDetail)
    ViewPager vpDetail;
    @BindView(R.id.tabHome)
    TabLayout tabHome;
    @BindView(R.id.activity_producto_detail)
    CoordinatorLayout activityProductoDetail;

    private ProductDetailAdapter mProductDetailAdapter;

    long mIdproducto = 0;

    ProductDeseadoFragment productDeseadoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        init();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_favority:

                registraFavorito();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void registraFavorito() {
        LProduct lproduct = new LProduct();
        boolean bolResult;
        Product objProduct = null;

        objProduct = lproduct.toID(mIdproducto);
        bolResult = lproduct.setProductDeseado(objProduct);
        //Toast.makeText(ProductoDetailActivity.this, "Se agrego a Favoritos : " + String.valueOf(mIdproducto), Toast.LENGTH_SHORT).show();

        if (bolResult) {
            //Snackbar snackbar = Snackbar.make(activityProductoDetail, "Se agrego a Favoritos",Snackbar.LENGTH_SHORT );
            //snackbar.show();

            productDeseadoFragment.actualizarAdapterListDeseado();

            Toast.makeText(ProductoDetailActivity.this, "Se agrego a Favoritos", Toast.LENGTH_SHORT).show();

        }

        //Esto se llama desde tu boton del menu
        //Fragment Fragment  =  getSupportFragmentManager().findFragmentByTag("nombreFragment")

        //Transaccion que realiza al momento que llamas una nueva pantalla
        //FragmentTransaction ft = getSupportFragmentManager()
                                   //.beginTransaction()
                                   //.replace(R.id.contenedor,fragment,"tagframente");
                                   //.commit();
    }

    private void init() {

        activityProductoDetail = (CoordinatorLayout) findViewById(R.id.activity_producto_detail);

        if (getIntent().hasExtra(ID)) {
            mIdproducto = getIntent().getLongExtra(ID, 0);
        }
        initTab();
    }

    private void initTab() {
        ProductDetailAdapter adapter;
        adapter = new ProductDetailAdapter(getSupportFragmentManager());

        productDeseadoFragment = new ProductDeseadoFragment();

        ProductDetailFragment productDetailFragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(IDPROD, mIdproducto);
        productDetailFragment.setArguments(bundle);


        adapter.agregarPantalla(new FragmentScreen(productDetailFragment, "Detalle"));
        adapter.agregarPantalla(new FragmentScreen(productDeseadoFragment, "Deseado"));
        vpDetail.setAdapter(adapter);
        tabHome.setupWithViewPager(vpDetail);
    }


}
