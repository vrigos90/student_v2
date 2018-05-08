package student.com.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uwagi(View v) {
        Intent i = new Intent(this,Uwagi.class);
        startActivity(i);
    }

    public void oceny(View v) {
        Intent i = new Intent(this,Oceny.class);
        startActivity(i);
    }

    public void przedmioty(View v) {
        Intent i = new Intent(this,wysTest.class);
        startActivity(i);
    }

}
