package student.com.student;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by Damian on 08.05.2018.
 */

public class DodawaniePrzedmiotu extends AppCompatActivity implements  View.OnClickListener{


    private String DZIEN_TYG = "Poniedziałek";
    private SimpleCursorAdapter scAdapter;
    EditText wyborGodzOd;
    EditText wyborGodzDo;
    TimePickerDialog tpGodz;

    private String DNI_TYGODNIA[] = {"Poniedziałek","Wtorek","Środa","Czwartek","Piątek","Sobota","Niedziela"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodawanie_przedmiotu);


        (findViewById(R.id.button_add_przedmiot)).setOnClickListener(this);
        obslugaGodz();
    }

    public void obslugaGodz(){

        wyborGodzOd =  findViewById(R.id.add_godz_od);
        wyborGodzOd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tpGodz = new TimePickerDialog(DodawaniePrzedmiotu.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        wyborGodzOd.setText(String.format("%02d:%02d",i,i1));
                    }
                },7,30,true);

                tpGodz.show();
            }
        });

        wyborGodzDo =  findViewById(R.id.add_godz_do);
        wyborGodzDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tpGodz = new TimePickerDialog(DodawaniePrzedmiotu.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        wyborGodzDo.setText(String.format("%02d:%02d",i,i1));
                    }
                },9,0,true);

                tpGodz.show();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_add_przedmiot:
               // cdbPrzedmiot.addPrzedmiot(              ((EditText)findViewById(R.id.add_nazw_przed)).getText().toString(),
                //        ((EditText)findViewById(R.id.add_godz_od)).getText().toString(),
                 //       ((EditText)findViewById(R.id.add_godz_do)).getText().toString(),
                  //      ((EditText)findViewById(R.id.add_sala)).getText().toString(),this);
                break;
        }
    }
}
