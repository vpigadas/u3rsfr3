package eu.york.u3rsfr3.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CounterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(CounterEntity counter);

    @Delete
    public void delete(CounterEntity counter);

    @Query("SELECT * FROM CounterEntity")
    public List<CounterEntity> read();

    @Query("SELECT * FROM CounterEntity")
    public LiveData<List<CounterEntity>> readAsync();
}
