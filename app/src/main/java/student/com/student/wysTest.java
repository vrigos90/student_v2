package student.com.student;

import android.app.ActionBar;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

public class wysTest extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter scAdapter;
    public CDBPrzedmiot cdbPrzedmiot;
    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wys_test);
        cdbPrzedmiot = new CDBPrzedmiot(this);
        cdbPrzedmiot.open();


        mContext = getApplicationContext();

        mActivity = wysTest.this;


        mRelativeLayout = (RelativeLayout) findViewById(R.id.r1);
        mButton = (Button) findViewById(R.id.b_dodaw_przed);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                View customView = inflater.inflate(R.layout.activity_dodawanie_przedmiotu,null);

                mPopupWindow = new PopupWindow(
                        customView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );


                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });


        scAdapter = new SimpleCursorAdapter(this, R.layout.list_item, null,
                new String[]{CDBHelper.PRZ_NAZWA, CDBHelper.PRZ_GODZINA_OD, CDBHelper.PRZ_GODZINA_D0, CDBHelper.PRZ_SALA},
                new int[]{R.id.przNazwa, R.id.przGodzinaOd, R.id.przGodzDo, R.id.przSala}, 0);

        ((ListView) findViewById(R.id.lv_fr_przed)).setAdapter(scAdapter);
        getLoaderManager().initLoader(1, null, this);
    }


    public void dodawanie(final Context context) {

        String DNI_TYGODNIA[] = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};


        Button btnDodaj = (Button) findViewById(R.id.b_dodaw_przed);
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                View v = layoutInflater.inflate(R.layout.activity_dodawanie_przedmiotu, null);

                final PopupWindow popupWindow = new PopupWindow(
                        v, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

                Toast.makeText(context, "loading...", Toast.LENGTH_LONG).show();
/*              Button addPrz = (Button) findViewById(R.id.button_add_przedmiot);
                addPrz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cdbPrzedmiot.addPrzedmiot(((EditText) findViewById(R.id.add_nazw_przed)).getText().toString(),
                                ((EditText) findViewById(R.id.add_godz_od)).getText().toString(),
                                ((EditText) findViewById(R.id.add_godz_do)).getText().toString(),
                                ((EditText) findViewById(R.id.add_sala)).getText().toString());

                        Toast.makeText(wysTest.this, "Dodano", Toast.LENGTH_LONG).show();
                        popupWindow.dismiss();
                    }
                });
*/
            }
        });


    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CPrzedmiotLoader(this, cdbPrzedmiot);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        scAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        scAdapter.swapCursor(null);
    }
}

