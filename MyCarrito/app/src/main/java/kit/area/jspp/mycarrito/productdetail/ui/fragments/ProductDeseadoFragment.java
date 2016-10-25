package kit.area.jspp.mycarrito.productdetail.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.modelo.logics.LProduct;
import kit.area.jspp.mycarrito.productdetail.ui.adapters.DeseadoRecyclerViewAdapter;

public class ProductDeseadoFragment extends Fragment {

    ArrayList<Product> lstProduct = new ArrayList<>();
    DeseadoRecyclerViewAdapter deseadoRecyclerViewAdapter;
    View view;
    public ProductDeseadoFragment() {
        this.lstProduct = getListDeseado();
    }
    ViewHolder viewHolder=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_deseado, container, false);

        viewHolder = new ViewHolder(view);
        deseadoRecyclerViewAdapter = new DeseadoRecyclerViewAdapter(lstProduct);
        viewHolder.rvDeseado.setAdapter(deseadoRecyclerViewAdapter);
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        viewHolder.rvDeseado.setLayoutManager(ll);

        if(lstProduct!=null && lstProduct.size()>0) {
            viewHolder.flempty.setVisibility(View.GONE);
            viewHolder.llDatos.setVisibility(View.VISIBLE);
        }else{
            viewHolder.flempty.setVisibility(View.VISIBLE);
            viewHolder.llDatos.setVisibility(View.GONE);
        }
        view.setTag(viewHolder);

        return view;
    }

    public ArrayList<Product> getListDeseado() {
        LProduct lProduct = new LProduct();
        for (Product p : lProduct.toListDeseado()) {
            lstProduct.add(p);
        }
        return lstProduct;
    }

    static class ViewHolder {
        @BindView(R.id.rvDeseado)
        RecyclerView rvDeseado;
        @BindView(R.id.flempty)
        FrameLayout flempty;
        @BindView(R.id.llDatos)
        LinearLayout llDatos;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void actualizarAdapterListDeseado() {
        lstProduct.clear();
        lstProduct = getListDeseado();
        deseadoRecyclerViewAdapter = new DeseadoRecyclerViewAdapter(lstProduct);
        if (viewHolder.rvDeseado != null) {
            viewHolder.rvDeseado.setAdapter(deseadoRecyclerViewAdapter);
        }else{
            viewHolder = new ViewHolder(view);
            viewHolder.rvDeseado.setAdapter(deseadoRecyclerViewAdapter);
        }
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        viewHolder.rvDeseado.setLayoutManager(ll);
    }
}
