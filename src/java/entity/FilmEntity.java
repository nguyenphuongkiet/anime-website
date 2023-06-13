/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class FilmEntity {
    private int id;
    private String name;
    private String description;
    private String thumbnailurl;

    public FilmEntity() {
    }

    public FilmEntity(int id, String name, String description, String thumbnailurl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailurl = thumbnailurl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    @Override
    public String toString() {
        return "FilmEntity{" + "id=" + id + ", name=" + name + ", description=" + description + ", thumbnailurl=" + thumbnailurl + '}';
    }
}
