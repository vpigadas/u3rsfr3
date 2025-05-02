package eu.york.u3rsfr3.viewmodel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CounterEntity.class}, version = 1)
public abstract class CounterDBINstance extends RoomDatabase {

    abstract public CounterDAO getCounterDAO();
}
