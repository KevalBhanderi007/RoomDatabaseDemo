package com.demo.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract class DbHelper extends RoomDatabase {

      private static  final String DB_NAME ="expensedb";

      private  static  DbHelper instance;
      public  static  synchronized  DbHelper getDB(Context context){
          if (instance==null){

              instance = Room.databaseBuilder(context,DbHelper.class,DB_NAME)
                      .fallbackToDestructiveMigration()
                      .allowMainThreadQueries().build();
          }
          return instance;
      }


      public abstract  ExpenseDao expenseDao();
}
