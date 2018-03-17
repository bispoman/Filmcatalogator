package com.bisponet.filmcatalogator.Model;

import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;

    private String title;
    private String originalTitle;
    private String slug;
    private String synopsis;
    private int duration;
    private String image;
    private int likes;
    private boolean published;
    private String actorsList;

    public Movie() {}

    public Movie(String title, String originalTitle, String slug,
                 String synopsis, int duration, String image,
                 int likes, boolean published, String actorsList) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.slug = slug;
        this.synopsis = synopsis;
        this.duration = duration;
        this.image = image;
        this.likes = likes;
        this.published = published;
        this.actorsList = actorsList;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getSlug() {
        return slug;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public String getImage() {
        return image;
    }

    public int getLikes() {
        return likes;
    }

    public boolean isPublished() {
        return published;
    }

    public String getActorsList() {
        return actorsList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setActorsList(String actorsList) {
        this.actorsList = actorsList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", slug='" + slug + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", duration='" + duration + '\'' +
                ", image='" + image + '\'' +
                ", likes=" + likes +
                ", published=" + published +
                ", actorsList='" + actorsList + '\'' +
                '}';
    }
}
