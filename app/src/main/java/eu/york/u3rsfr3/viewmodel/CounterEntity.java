package eu.york.u3rsfr3.viewmodel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class CounterEntity {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        CounterEntity that = (CounterEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CounterEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
