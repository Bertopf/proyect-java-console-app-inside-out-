package dev.alberto.repositories;

import dev.alberto.models.Moment;

import java.util.List;

import dev.alberto.db.DiaryDatabase;
import dev.alberto.models.EmotionEnum;


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

    public boolean deleteMoment(int index) {
        return db.deleteMoment(index);
    }
    
    public List<Moment> getMomentsByEmotion(EmotionEnum emotion) {
    return db.getAll().stream()
        .filter(m -> m.getEmotionEnum() == emotion)
        .toList();
}




}
