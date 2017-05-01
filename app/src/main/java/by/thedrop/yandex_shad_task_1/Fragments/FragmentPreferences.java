package by.thedrop.yandex_shad_task_1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import by.thedrop.yandex_shad_task_1.R;

/**
 * Created by Semen on 01-May-17.
 */

public class FragmentPreferences extends Fragment {


    private Button mButton4x6;
    private Button mButton5x7;
    private Button mButtonStyleRed;
    private Button mButtonStyleBlue;

    private static int tableStyle = 0; // 1 - 4x6, 2 - 5x7
    private static int appStyle = 0; // 1 - red, 2 - blue


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_preferences, container, false);

        this.mButton4x6 = (Button) v.findViewById(R.id.preferences_sells_count_4x6);
        this.mButton5x7 = (Button) v.findViewById(R.id.preferences_sells_count_5x7);
        this.mButtonStyleRed = (Button) v.findViewById(R.id.preferences_sells_color_red);
        this.mButtonStyleBlue = (Button) v.findViewById(R.id.preferences_sells_color_blue);

        mButton4x6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableStyle = 1;
                mButton4x6.setBackgroundColor(getResources().getColor(R.color.yellow));
                mButton5x7.setBackgroundColor(getResources().getColor(R.color.light_grey));
            }
        });
        mButton5x7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableStyle = 2;
                mButton4x6.setBackgroundColor(getResources().getColor(R.color.light_grey));
                mButton5x7.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
        });
        mButtonStyleRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appStyle = 1;
                mButtonStyleRed.setAlpha(1f);
                mButtonStyleBlue.setAlpha(0.2f);
            }
        });
        mButtonStyleBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appStyle = 2;
                mButtonStyleRed.setAlpha(0.2f);
                mButtonStyleBlue.setAlpha(1f);
            }
        });
        return v;
    }
}
