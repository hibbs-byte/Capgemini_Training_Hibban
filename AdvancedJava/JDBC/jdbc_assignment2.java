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


package com.capg1.dao;

import com.capg1.entity.jdbc;
import com.capg1.repository.jdbcrepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class jdbcdaoimp implements jdbcdao {
    public void insertBatch(List<jdbc> players) throws SQLException {
        Connection connection = jdbcrepository.getConnection();
        String insertQuery = "INSERT INTO empp (id, name, country) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(insertQuery);

        for (jdbc p : players) {
            pst.setInt(1, p.getPlayerid());
            pst.setString(2, p.getPlayername());
            pst.setString(3, p.getPlayerCountry());
            pst.addBatch();
        }

        int[] result = pst.executeBatch();
        System.out.println("Inserted rows: " + result.length);
    }
    public void updateBatch(List<jdbc> players) throws SQLException {

        Connection connection = jdbcrepository.getConnection();
        String updateQuery = "UPDATE empp SET name = ?, country = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(updateQuery);

        for (jdbc p : players) {
            pst.setString(1, p.getPlayername());
            pst.setString(2, p.getPlayerCountry());
            pst.setInt(3, p.getPlayerid()); // condition for WHERE clause
            pst.addBatch();
        }

        int[] result = pst.executeBatch();
        System.out.println("Updated rows: " + result.length);
    }
    public void deleteBatch(List<Integer> playerids) throws SQLException {
        Connection connection = jdbcrepository.getConnection();
        String deleteQuery = "DELETE FROM empp WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(deleteQuery);

        for (Integer id : playerids) {
            pst.setInt(1, id);
            pst.addBatch();
        }

        int[] result = pst.executeBatch();
        System.out.println("Deleted rows: " + result.length);
    }
}
