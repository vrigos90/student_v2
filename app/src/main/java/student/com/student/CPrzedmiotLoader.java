package student.com.student;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

/**
 * Created by Damian on 01.05.2018.
 */

public class CPrzedmiotLoader extends CursorLoader {

    CDBPrzedmiot dbase;

    public CPrzedmiotLoader(Context context, CDBPrzedmiot db) {
        super(context);
        this.dbase = db;
    }

    public Cursor loadInBackground(){
        return dbase.getPrzedmiot();
    }
}
