package student.com.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Damian on 28.04.2018.
 */

public class Oceny extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oceny);
    }

    public void oceny(View v) {
        Intent i = new Intent(this, Oceny.class);
        startActivity(i);
    }
}
