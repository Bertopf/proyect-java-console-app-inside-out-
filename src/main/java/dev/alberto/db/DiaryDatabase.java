package dev.alberto.db;

import dev.alberto.models.Moment;
import java.util.List;
import java.util.ArrayList;


public class DiaryDatabase {

    private List<Moment> moments;

    public DiaryDatabase() {
        this.moments = new ArrayList<>();
    }

    public void store(Moment moment) {
        moments.add(moment);
    }

}
