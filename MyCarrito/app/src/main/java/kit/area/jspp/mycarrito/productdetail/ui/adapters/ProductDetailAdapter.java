package kit.area.jspp.mycarrito.productdetail.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import kit.area.jspp.mycarrito.entities.FragmentScreen;


public class ProductDetailAdapter extends FragmentPagerAdapter {

    private ArrayList<FragmentScreen> lista = new ArrayList<>();

    public ProductDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    public void agregarPantalla(FragmentScreen fragmentScreen){
        lista.add(fragmentScreen);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lista.get(position).getTitulo();
    }

    @Override
    public Fragment getItem(int position) {
        return lista.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
