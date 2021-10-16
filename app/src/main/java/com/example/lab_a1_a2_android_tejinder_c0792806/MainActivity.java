package com.example.lab_a1_a2_android_tejinder_c0792806;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.lab_a1_a2_android_tejinder_c0792806.model.Product;
import com.example.lab_a1_a2_android_tejinder_c0792806.model.Provider;
import com.example.lab_a1_a2_android_tejinder_c0792806.viewmodel.ProductViewModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem product, provider;

    ViewPager viewPager;


    PagerAdapter pagerAdapter;
    SectionsPagerAdapter sectionsPagerAdapter;

    List<Product> productList = new ArrayList<>();
    List<Provider> providerList = new ArrayList<>();
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        product = findViewById(R.id.productTab);
        provider = findViewById(R.id.providerTab);
        viewPager = findViewById(R.id.fragmentcontainer);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        productViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(ProductViewModel.class);

        productViewModel.getAllProviders().observe(this,providers -> {
            if(providers.isEmpty()){
                productViewModel.insertProvider(new Provider("123","Ram","987654321","ram@gmail.com",79.12346,78.2135));
                productViewModel.insertProvider(new Provider("124","Sam","987654321","ram@gmail.com",75.12346,80.2135));
                productViewModel.insertProvider(new Provider("125","Tam","987654321","ram@gmail.com",79.12346,60.2135));
                productViewModel.insertProvider(new Provider("126","Ham","987654321","ram@gmail.com",68.12346,78.2135));
            }
            productViewModel.getAllProducts().observe(this,products -> {
                if(products.isEmpty()){

                }
            });
        });

    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new Product();
                    break;
                case 1:
                    fragment = new Provider();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Fragment 1";
                case 1:
                    return "Fragment 2";
            }
            return null;
        }
    }
}

