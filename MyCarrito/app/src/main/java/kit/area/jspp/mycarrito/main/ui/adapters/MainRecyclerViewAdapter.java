package kit.area.jspp.mycarrito.main.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.entities.Product;

/**
 * Created by PEPE on 19/09/2016.
 */

public class MainRecyclerViewAdapter
        extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>
{
    private ArrayList<Product> lista;

    public MainRecyclerViewAdapter(ArrayList<Product> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_frag_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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

     static class ViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvModelo)
        TextView tvModelo;
        @BindView(R.id.tvPrecio)
        TextView tvPrecio;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
