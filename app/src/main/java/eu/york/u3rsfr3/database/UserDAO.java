package eu.york.u3rsfr3.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    public void insert(UserEntity user) throws Exception;

    @Update
    public void update(UserEntity user) throws Exception;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity user);

    @Delete
    public void delete(UserEntity user);

    @Query("SELECT * FROM UserEntity")
    @NonNull
    public List<UserEntity> read();


    @Query("SELECT * FROM UserEntity LIMIT 1")
    @Nullable
    public UserEntity readFirst();


    @Query("SELECT * FROM UserEntity LIMIT 1 OFFSET 2")
    @NonNull
    public List<UserEntity> readRange();

    @Query("SELECT * FROM UserEntity WHERE user_name LIKE :name")
    @NonNull
    public List<UserEntity> read(String name);

}
