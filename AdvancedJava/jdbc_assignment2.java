package org;

import com.capg1.dao.jdbcdao;
import com.capg1.dao.jdbcdaoimp;
import com.capg1.entity.jdbc;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        jdbcdao dao = new jdbcdaoimp();
        List<jdbc> players = Arrays.asList(new jdbc(19, "Hibban", "USA"));
        players = Arrays.asList(
                new jdbc(1, "AliceUpdated", "Canada"),
                new jdbc(2, "BobUpdated", "Germany")
        );
        try {
            dao.insertBatch(players);
            dao.updateBatch(players);
            dao.deleteBatch(Arrays.asList(1, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
