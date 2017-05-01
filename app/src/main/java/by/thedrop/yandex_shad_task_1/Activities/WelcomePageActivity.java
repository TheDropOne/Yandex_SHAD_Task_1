package by.thedrop.yandex_shad_task_1.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import by.thedrop.yandex_shad_task_1.Fragments.FragmentPreferences;
import by.thedrop.yandex_shad_task_1.Fragments.FragmentWelcomeAdvantages;
import by.thedrop.yandex_shad_task_1.R;
import by.thedrop.yandex_shad_task_1.Views.NonSwipeableViewPager;

public class WelcomePageActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 5;
    private static int CURRENT_ITEM = 0;

    private NonSwipeableViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout tabLayout;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager = (NonSwipeableViewPager) findViewById(R.id.wa_view_pager);
        mViewPager.setAdapter(mPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager, true);

        mStartButton = (Button) findViewById(R.id.wa_button_start);
        mStartButton.setText(R.string.next);
        mStartButton.setTypeface(MainActivity.fontFutura);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() == PAGE_COUNT - 1) {
                    finish();
                } else {
                    notifyNextButtonPressed();
                }
            }
        });
    }

    private void notifyNextButtonPressed() {
        CURRENT_ITEM++;
        if (CURRENT_ITEM == PAGE_COUNT - 1) {
            mStartButton.setText(R.string.start_usage);
            mViewPager.setCurrentItem(CURRENT_ITEM);
        } else {
            mStartButton.setText(R.string.next);
            mViewPager.setCurrentItem(CURRENT_ITEM);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentWelcomeAdvantages(R.mipmap.ic_launcher, R.string.app_name,R.string.welcome_text);
                case 1:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_design, R.string.perfect_design);
                case 2:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_silly, R.string.to_simple);
                case 3:
                    return new FragmentWelcomeAdvantages(R.drawable.fragment_need, R.string.you_need_it);
                case 4:
                    return new FragmentPreferences();
            }
            return new FragmentWelcomeAdvantages(R.drawable.fragment_need, R.string.app_name);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
