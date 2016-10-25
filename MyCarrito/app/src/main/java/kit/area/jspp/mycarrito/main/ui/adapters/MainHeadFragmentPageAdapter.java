package kit.area.jspp.mycarrito.main.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import kit.area.jspp.mycarrito.entities.FragmentScreen;

/**
 * Created by PEPE on 19/09/2016.
 */
/*Cambiar FragmentStatePAger*/
public class MainHeadFragmentPageAdapter extends FragmentPagerAdapter {

    private ArrayList<FragmentScreen> lista = new ArrayList<>();

    public MainHeadFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public  void agregarPantalla(FragmentScreen fragmentScreen){
        lista.add(fragmentScreen);
    }

    @Override
    public Fragment getItem(int position) {
        return lista.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lista.get(position).getTitulo();
    }
}
