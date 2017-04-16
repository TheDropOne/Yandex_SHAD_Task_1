package by.thedrop.yandex_shad_task_1.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import by.thedrop.yandex_shad_task_1.Fragments.FragmentWelcomeAdvantages;
import by.thedrop.yandex_shad_task_1.R;

public class WelcomePageActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 3;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.wa_view_pager);
        mViewPager.setAdapter(mPagerAdapter);

        mStartButton = (Button) findViewById(R.id.wa_button_start);
        mStartButton.setTypeface(MainActivity.fontFutura);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
