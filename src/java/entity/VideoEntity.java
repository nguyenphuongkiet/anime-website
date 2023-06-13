/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class VideoEntity {
    private int id;
    private String name;
    private String thumbnailUrl;
    private String videoUrl;
    private Date releaseDate;
    private int length;
    private int view;
    private int filmId;
    private int ep;

    public VideoEntity() {
    }

    public VideoEntity(int id, String name, String thumbnailUrl, String videoUrl, Date releaseDate, int length, int view, int filmId, int ep) {
        this.id = id;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
        this.releaseDate = releaseDate;
        this.length = length;
        this.view = view;
        this.filmId = filmId;
        this.ep = ep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    @Override
    public String toString() {
        return "VideoEntity{" + "id=" + id + ", name=" + name + ", thumbnailUrl=" + thumbnailUrl + ", videoUrl=" + videoUrl + ", releaseDate=" + releaseDate + ", length=" + length + ", view=" + view + ", filmId=" + filmId + ", ep=" + ep + '}';
    }

    
}
