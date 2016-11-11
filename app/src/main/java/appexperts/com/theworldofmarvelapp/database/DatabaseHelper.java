package appexperts.com.theworldofmarvelapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import appexperts.com.theworldofmarvelapp.character.CharacterPresenter;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by TheAppExperts on 03/11/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "marvel.db";
    private static DatabaseHelper databaseHelper;

    private DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context){
        if (databaseHelper == null){
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    static {

        cupboard().register(CharacterPresenter.ComicDatabaseEntry.class);
        //cupboard().register(ProductsByCategoryPresenter.ProductsByCategoryDatabaseEntry.class);
        //cupboard().register(ProductDetailsPresenter.ProductDetailsDatabaseEntry.class);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        cupboard().withDatabase(sqLiteDatabase).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        cupboard().withDatabase(sqLiteDatabase).upgradeTables();

    }
}