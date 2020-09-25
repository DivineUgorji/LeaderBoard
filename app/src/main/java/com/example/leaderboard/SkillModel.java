package com.example.leaderboard;

public class SkillModel  {
    private String name;
    private String score;
    private String country;
    private String badgeUrl;

    public SkillModel() {
    }

    public SkillModel(String name, String score, String country, String photo) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "SkillModel{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
