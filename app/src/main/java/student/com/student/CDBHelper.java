package student.com.student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Damian on 01.05.2018.
 */

public class CDBHelper extends SQLiteOpenHelper {

    public static String NAZW_TAB       =   "PON";
    public static String PRZ_ID         =   "_id";
    public static String PRZ_NAZWA      =   "NAZWA";
    public static String PRZ_GODZINA_OD =   "GODZINA_OD";
    public static String PRZ_GODZINA_D0 =   "GODZINA_DO";
    public static String PRZ_SALA       =   "SALA";

    private static String    DB_NAZWA       =   "Przedmioty.db";
    private static int       DB_WERSJA      =   1;

    private static String CREATE_TABLE_PRZ  =   "CREATE TABLE "  +
                                                NAZW_TAB + "("   +
                                                PRZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                PRZ_NAZWA       + " TEXT," +
                                                PRZ_GODZINA_OD  + " TEXT," +
                                                PRZ_GODZINA_D0  + " TEXT," +
                                                PRZ_SALA        + " TEXT" + ")";



    public CDBHelper(Context context) {
        super(context, DB_NAZWA, null, DB_WERSJA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PRZ);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NAZW_TAB);
        onCreate(sqLiteDatabase);
    }
}
