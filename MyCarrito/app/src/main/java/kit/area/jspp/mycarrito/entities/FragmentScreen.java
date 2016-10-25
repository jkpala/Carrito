package kit.area.jspp.mycarrito.entities;

import android.support.v4.app.Fragment;

/**
 * Created by PEPE on 19/09/2016.
 */

public class FragmentScreen {
    private Fragment fragment;
    private String titulo;

    public FragmentScreen(Fragment fragment, String titulo) {
        this.fragment = fragment;
        this.titulo = titulo;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
