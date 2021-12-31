package com.big_d_software.dieroller6000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.big_d_software.dieroller6000.DieRoller6000DatabaseContract.CharacterInfoEntry;


public class DieRoller6000OpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DieRoller3000_dschreiber4.db";
    public static final int DATABASE_VERSION = 1;

    public DieRoller6000OpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CharacterInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(CharacterInfoEntry.SQL_CREATE_INDEX1);

        DieRoller6000DataWorker worker = new DieRoller6000DataWorker(db);
        worker.insertCharacter();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

