
package repository;

import model.BorrowRecord;
import java.util.ArrayList;

public class BorrowRepository {

    private final ArrayList<BorrowRecord> records = new ArrayList<>();
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public void addRecord(BorrowRecord record) {
        records.add(record);
    }

    public BorrowRecord findById(int id) {
        for (BorrowRecord record : records) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }

    public ArrayList<BorrowRecord> getAllRecords() {
        return new ArrayList<>(records);
    }

    public ArrayList<BorrowRecord> findByMemberId(int memberId) {
        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : records) {
            if (record.getMemberId() == memberId) {
                result.add(record);
            }
        }

        return result;
    }

    public ArrayList<BorrowRecord> findActiveByMemberId(int memberId) {
        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : records) {
            if (record.getMemberId() == memberId && !record.isReturned()) {
                result.add(record);
            }
        }

        return result;
    }

    public ArrayList<BorrowRecord> findActiveByBookId(int bookId) {
        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : records) {
            if (record.getBookId() == bookId && !record.isReturned()) {
                result.add(record);
            }
        }

        return result;
    }
}
