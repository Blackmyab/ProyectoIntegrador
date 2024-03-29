package app.myab.huariques.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.myab.huariques.Adapter.PageAdministradorAdapter;
import app.myab.huariques.R;

public class AdministradorActivity extends AppCompatActivity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        setToolbar();




        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayoutAdministracion);
        tabLayout.addTab(tabLayout.newTab().setText("Usuarios"));
        tabLayout.addTab(tabLayout.newTab().setText("Categorias"));
        tabLayout.addTab(tabLayout.newTab().setText("Ventas"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPagerAdministracion);
        PagerAdapter adapter = new PageAdministradorAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setToolbar(){
        myToolbar=findViewById(R.id.toolbarProductos);
        setSupportActionBar(myToolbar);
    }

}
