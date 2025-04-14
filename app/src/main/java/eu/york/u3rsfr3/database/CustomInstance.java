package eu.york.u3rsfr3.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class CustomInstance extends RoomDatabase {

    public abstract UserDAO getUserDAO();
}
