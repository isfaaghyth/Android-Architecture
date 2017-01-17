package app.daeng.ingetin.Models;

/**
 * Created by isfaaghyth on 15/1/17.
 */

public class DataItemModel {
    private int id;
    private String name;

    public DataItemModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
