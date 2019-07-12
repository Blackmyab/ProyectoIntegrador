package app.myab.huariques.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.myab.huariques.Fragments.ClienteFragment;
import app.myab.huariques.Fragments.DeseosFragment;
import app.myab.huariques.Fragments.MisComprasFragment;

public class PagePerfilAdapter  extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public PagePerfilAdapter(FragmentManager fm,int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ClienteFragment();
            case 1:
                return new MisComprasFragment();
            case 2:
                return new DeseosFragment();

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
