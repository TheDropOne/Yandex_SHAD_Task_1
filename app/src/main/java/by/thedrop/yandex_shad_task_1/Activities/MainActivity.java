package by.thedrop.yandex_shad_task_1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import by.thedrop.yandex_shad_task_1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent welcomeIntent = new Intent(this, WelcomePageActivity.class);
        startActivity(welcomeIntent);
    }
}
