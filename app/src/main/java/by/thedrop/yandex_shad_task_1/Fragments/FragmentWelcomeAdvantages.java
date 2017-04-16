package by.thedrop.yandex_shad_task_1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.thedrop.yandex_shad_task_1.Activities.MainActivity;
import by.thedrop.yandex_shad_task_1.R;

public class FragmentWelcomeAdvantages extends Fragment {

    private int imageResource;
    private int stringResource;

    private ImageView mImageView;
    private TextView mTextView;

    public FragmentWelcomeAdvantages() {
        // Required empty public constructor
    }

    public FragmentWelcomeAdvantages(int imageResource, int stringResource) {
        this.imageResource = imageResource;
        this.stringResource = stringResource;
    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_welcome_advantages, container, false);

        this.mImageView = (ImageView) v.findViewById(R.id.wa_image_view);
        this.mTextView = (TextView) v.findViewById(R.id.wa_textView);
        mImageView.setImageResource(imageResource);
        mTextView.setText(stringResource);
        mTextView.setTypeface(MainActivity.fontFutura);

        return v;
    }


}
