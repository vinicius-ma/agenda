package br.com.vinma.agenda.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.vinma.agenda.model.Student;
import br.com.vinma.agenda.room.dao.StudentDAO;

@Database(entities={Student.class}, version=1, exportSchema=false)
public abstract class AgendaDataBase extends RoomDatabase {

    private static final String NAME = "agenda.db";
    private static AgendaDataBase instance;

    public abstract StudentDAO getRoomStudentDao();

    public synchronized static AgendaDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, AgendaDataBase.class, NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
