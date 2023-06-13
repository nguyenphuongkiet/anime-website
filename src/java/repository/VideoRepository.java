/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConfig;
import entity.VideoEntity;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class VideoRepository {

    public VideoEntity getVideo(int id) throws SQLException {
        VideoEntity entity = new VideoEntity();
        Connection con = DBConfig.getConnection();
        PreparedStatement pstm = con.prepareStatement("select * from video where id = ?");
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getInt("id"));
            entity.setName(rs.getString("name"));
            entity.setThumbnailUrl(rs.getString("thumbnailurl"));
            entity.setVideoUrl(rs.getString("videourl"));
            entity.setReleaseDate(rs.getDate("releaseDate"));
            entity.setLength(rs.getInt("length"));
            entity.setView(rs.getInt("view"));
            entity.setFilmId(rs.getInt("filmId"));
            entity.setEp(rs.getInt("ep"));
        }
        con.close();
        return entity;
    }

    public ArrayList<VideoEntity> getVideoByFilmId(int id) throws SQLException {
        // Prepare the SQL query
        String sql = "SELECT * FROM video WHERE FilmID = ?";
        Connection con = DBConfig.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);

        // Set the anime ID parameter
        statement.setInt(1, id);

        // Execute the query and retrieve the result set
        ResultSet resultSet = statement.executeQuery();

        // Convert the result set to a list of video objects
        ArrayList<VideoEntity> episodeList = new ArrayList<>();
        while (resultSet.next()) {
            VideoEntity video = new VideoEntity();
            video.setId(resultSet.getInt("ID"));
            video.setName(resultSet.getString("Name"));
            video.setThumbnailUrl(resultSet.getString("ThumbnailURL"));
            video.setVideoUrl(resultSet.getString("VideoURL"));
            video.setReleaseDate(resultSet.getDate("ReleaseDate"));
            video.setLength(resultSet.getInt("Length"));
            video.setView(resultSet.getInt("View"));
            video.setFilmId(resultSet.getInt("FilmID"));
            video.setEp(resultSet.getInt("Ep"));
            episodeList.add(video);
        }
        return episodeList;
    }

    public static void main(String[] args) throws SQLException {
        VideoRepository repo = new VideoRepository();

        for(VideoEntity e : repo.getVideoByFilmId(1)){
            System.out.println(e);
        }
    }
}
