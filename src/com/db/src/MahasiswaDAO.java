/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.db.src;


import java.sql.*;

/**
 *
 * @author Administrator
 */
public class MahasiswaDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/universitas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private Connection conn;

    public MahasiswaDAO() {
        try {
            if (conn == null) {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void ReadRecords(){
        try {
            String sql = "SELECT * FROM mahasiswa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String nim = rs.getString("nim");
                int semester = rs.getInt("semester");
                float ipk = rs.getFloat("ipk");
                System.out.println(id + " " + nama + " " + nim + " " + semester+ " "+ipk);
            }
            rs.close();
            
        } catch (Exception e) {
        }
    }
    
    public void InsertRecords(String nim, String nama, int semester, float ipk){
        try {
            String sql = "INSERT INTO mahasiswa(nim,nama,semester,ipk) VALUES(?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, nim);
            prepStmt.setString(2, nama);
            prepStmt.setInt(3, semester);
            prepStmt.setFloat(4, ipk);
            prepStmt.executeUpdate();
            System.out.println("Record Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateReocrds(int id, String nim, String nama, int semester, float ipk){
        try {
            String sql = "UPDATE mahasiswa SET nim=?, nama=?, semester=?, ipk=? WHERE id=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, nim);
            prepStmt.setString(2, nama);
            prepStmt.setInt(3, semester);
            prepStmt.setFloat(4, ipk);
            prepStmt.setInt(5, id);
            prepStmt.executeUpdate();
            System.out.println("Record Updated");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void DeleteRecord (int id){
        try {
            String sql = "DELETE FROM mahasiswa WHERE id = ?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
            System.out.println("Record deleted at id = "+id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        MahasiswaDAO mDao = new MahasiswaDAO();
        //mDao.InsertRecords("A112", "Rudy", 4, 4);
        mDao.UpdateReocrds(2, "AAA", "Johny", 2, 3);
        mDao.ReadRecords();
        mDao.DeleteRecord(2);
        mDao.ReadRecords();
    }
}
