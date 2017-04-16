package by.thedrop.yandex_shad_task_1.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import by.thedrop.yandex_shad_task_1.Fragments.FragmentWelcomeAdvantages;
import by.thedrop.yandex_shad_task_1.R;

public class WelcomePageActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 3;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        mViewPager = (ViewPager) findViewById(R.id.wa_view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPagerAdapter);
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_design,R.string.perfect_design);
                case 1:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_silly,R.string.to_simple);
                case 2:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_need,R.string.you_need_it);
            }
            return new FragmentWelcomeAdvantages(R.drawable.fragment_need,R.string.app_name);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
