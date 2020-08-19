package com.example.domain;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/8 09:44
 * @description:
 */
public class StudentScore {

    private String stuName;

    private String subject;

    private Integer score;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "stuName='" + stuName + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
