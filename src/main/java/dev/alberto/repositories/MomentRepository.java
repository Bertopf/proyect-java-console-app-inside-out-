package dev.alberto.repositories;

import dev.alberto.models.Moment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dev.alberto.contracts.InterfaceDatabase;
import dev.alberto.db.DiaryDatabase;
import dev.alberto.models.EmotionEnum;

public class MomentRepository {
    private InterfaceDatabase<Moment> db;
    public MomentRepository() {
        this.db = new DiaryDatabase();
    }
    public void setDb(String dbType) {
        if (dbType.equalsIgnoreCase("diary")) {
            this.db = new DiaryDatabase();
        }
    }
    public void storeMoment(Moment moment) {
        db.store(moment);
    }
    public List<Moment> getAllMoments() {
        return db.getAll();
    }
    public boolean deleteMoment(int index) {
        return db.delete(index);
    }
    public List<Moment> getMomentsByEmotion(EmotionEnum emotion) {
        return db.getAll().stream()
                .filter(m -> m.getEmotionEnum() == emotion)
                .toList();
    }
    public List<Moment> getMomentsByDate(LocalDate date) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment moment : db.getAll()) {
            if (moment.getDate().isEqual(date)) {
                filtered.add(moment);
            }
        }
        return filtered;
    }
}
