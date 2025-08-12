package dev.alberto.repositories;

import dev.alberto.models.Moment;

import java.util.List;

import dev.alberto.db.DiaryDatabase;


public class MomentRepository {

    private DiaryDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }

    public void StoreMoment(Moment moment) {
        db.store(moment);
    }

    public List<Moment> getAllMoments() {
        return db.getAll();
    }

}
