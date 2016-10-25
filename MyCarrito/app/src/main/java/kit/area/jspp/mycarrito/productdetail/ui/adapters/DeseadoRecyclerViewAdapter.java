package kit.area.jspp.mycarrito.productdetail.ui.adapters;

import android.support.annotation.BinderThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.entities.Product;

/**
 * Created by PEPE on 10/10/2016.
 */

public class DeseadoRecyclerViewAdapter
        extends RecyclerView.Adapter<DeseadoRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Product> lista;

    public DeseadoRecyclerViewAdapter(ArrayList<Product> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_frag_deseado, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

     //   if ( lista == null || lista.size() == 0 ){
     //       holder.cvDeseado.setVisibility(View.GONE);
     //   }

        Product mProduct = lista.get(position);
        holder.tvNombre.setText(mProduct.getProductname());
        holder.tvModelo.setText(mProduct.getProductmodel());
        holder.tvPrecio.setText(String.valueOf(mProduct.getPrice()));
        holder.sdvImagen.setImageURI(mProduct.getUrlimage());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvModelo)
        TextView tvModelo;
        @BindView(R.id.tvPrecio)
        TextView tvPrecio;
        @BindView(R.id.cvDeseado)
        CardView cvDeseado;



         public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
