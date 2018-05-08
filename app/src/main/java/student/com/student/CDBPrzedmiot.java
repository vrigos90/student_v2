package student.com.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import student.com.student.CDBHelper;

/**
 * Created by Damian on 01.05.2018.
 */

public class CDBPrzedmiot {

    private CDBHelper cdbHelper;
    private String[] PRZEDMIOTY_RECORD = {CDBHelper.PRZ_ID,CDBHelper.PRZ_NAZWA,CDBHelper.PRZ_GODZINA_OD,CDBHelper.PRZ_GODZINA_D0,CDBHelper.PRZ_SALA};

    private SQLiteDatabase sqLiteDatabase;

    public CDBPrzedmiot(Context context){
        cdbHelper = new CDBHelper(context);
    }

    public void open() throws SQLException {

        sqLiteDatabase = cdbHelper.getWritableDatabase();
    }

    public void close(){sqLiteDatabase.close();}

    public void addPrzedmiot(String nazwa, String godz_od, String godz_do, String sala){
        ContentValues cv = new ContentValues();
        cv.put(CDBHelper.PRZ_NAZWA,nazwa);
        cv.put(CDBHelper.PRZ_GODZINA_OD,godz_od);
        cv.put(CDBHelper.PRZ_GODZINA_D0,godz_do);
        cv.put(CDBHelper.PRZ_SALA,sala);
        sqLiteDatabase.insert(CDBHelper.NAZW_TAB,null,cv);
    }

    public Cursor getPrzedmiot(){
        return sqLiteDatabase.query(CDBHelper.NAZW_TAB,
                PRZEDMIOTY_RECORD,null,null,null,null,CDBHelper.PRZ_GODZINA_OD);
    }

    public void deletePrzedmiot(int id){
        sqLiteDatabase.delete(CDBHelper.NAZW_TAB, CDBHelper.PRZ_ID + " = " + id, null);
    }
}
