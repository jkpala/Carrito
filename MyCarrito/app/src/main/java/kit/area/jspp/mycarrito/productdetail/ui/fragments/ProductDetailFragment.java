package kit.area.jspp.mycarrito.productdetail.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.BaseActivity;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.modelo.logics.LProduct;

import static kit.area.jspp.mycarrito.aplicacion.Configuracion.IDPROD;

public class ProductDetailFragment extends Fragment {

    Product product;
    Context context;
    ViewHolder viewHolder;
    public ProductDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            if (bundle.containsKey(IDPROD)) {

                product = getProductID(bundle.getLong(IDPROD));
            }
        }

        View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);
        context = rootView.getContext();
        viewHolder = new ViewHolder(rootView);
        if (product != null) {
            viewHolder.tvStock.setText("(" + product.getStock() + ") en Stock");
            viewHolder.tvPrecio.setText("PRECIO: S/ " + product.getPrice());
            viewHolder.tvTitulo.setText(product.getProductname().toUpperCase().toString());
            viewHolder.sdvProducto.setImageURI(product.getUrlimage().toString());

            viewHolder.btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            viewHolder.btnComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        rootView.setTag(viewHolder);

        return rootView;
    }

    public Product getProductID(Long id) {
        LProduct lProduct;
        lProduct = new LProduct();
        Product product = null;
        product = lProduct.toID(id);
        return product;
    }

     static class ViewHolder {
        @BindView(R.id.tvStock)
        TextView tvStock;
        @BindView(R.id.sdvProducto)
        SimpleDraweeView sdvProducto;
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;
        @BindView(R.id.tvPrecio)
        TextView tvPrecio;
        @BindView(R.id.btnComprar)
        Button btnComprar;
        @BindView(R.id.btnAgregar)
        Button btnAgregar;


         ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
