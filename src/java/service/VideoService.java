/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.VideoEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.VideoRepository;

/**
 *
 * @author admin
 */
public class VideoService {
    VideoRepository vr = new VideoRepository();
    
    public VideoEntity getVideo(int id) throws SQLException{
        return vr.getVideo(id);
    }
    
    public ArrayList<VideoEntity> getVideoByFilmId(int id) throws SQLException{
        return vr.getVideoByFilmId(id);
    }
    
    public VideoEntity getVideoByFilmIdAndEpisode(int id, int ep) throws SQLException{
        return vr.getVideoByFilmIdAndEpisode(id, ep);
    }
}
