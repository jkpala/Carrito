package kit.area.jspp.mycarrito.main.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.Utils;
import kit.area.jspp.mycarrito.entities.Category;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.main.ui.adapters.MainRecyclerViewAdapter;
import kit.area.jspp.mycarrito.main.ui.listeners.ClickListener;
import kit.area.jspp.mycarrito.main.ui.listeners.RecyclerTouchListener;
import kit.area.jspp.mycarrito.modelo.logics.LCategory;
import kit.area.jspp.mycarrito.modelo.logics.LProduct;
import kit.area.jspp.mycarrito.productdetail.ProductoDetailActivity;

import static kit.area.jspp.mycarrito.aplicacion.Configuracion.ID;

/**
 * Created by PEPE on 19/09/2016.
 */

public class MainFragment extends Fragment {
    ArrayList<Product> mProductList = new ArrayList<>();
    MainRecyclerViewAdapter mMainRecyclerViewAdapter;
    Context context;
    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null){
            Bundle bundle = getArguments();
            if(bundle.containsKey("categoria")){
                mProductList = getProductList(bundle.getString("categoria"));
            }
        }

        final View rootView = inflater
                .inflate(R.layout.fragment_main, container, false);
        context = rootView.getContext();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rvListado);
        mMainRecyclerViewAdapter = new MainRecyclerViewAdapter(mProductList);
        rv.setAdapter(mMainRecyclerViewAdapter);
        rv.addOnItemTouchListener(new RecyclerTouchListener(rootView.getContext(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
                Product product;
                Intent intent = new Intent(rootView.getContext(), ProductoDetailActivity.class);

                product =  mProductList.get(position);
                if (product != null){
                    intent.putExtra(ID, product.getIdproduct());
                    Log.i("MainFragment: ID ",String.valueOf(product.getIdproduct()));
                }
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(context, "LongClick", Toast.LENGTH_SHORT).show();
            }
        }));
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(ll);
        return rootView;
    }

    public ArrayList<Product> getProductList(String mCategoria){
        LProduct lProduct;
        lProduct= new LProduct();

        ArrayList<Product> arrayList= new ArrayList<>();
        for (Product p: lProduct.toCategory(mCategoria)) {
                         arrayList.add(p);
        }
        return  arrayList;
    }





}
