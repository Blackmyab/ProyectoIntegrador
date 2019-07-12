package app.myab.huariques.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.myab.huariques.Fragments.CategoriasFragment;
import app.myab.huariques.Fragments.UsuariosFragment;
import app.myab.huariques.Fragments.VentasFragment;

public class PageAdministradorAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PageAdministradorAdapter(FragmentManager fm,int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UsuariosFragment();
            case 1:
                return new CategoriasFragment();
            case 2:
                return new VentasFragment();

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
