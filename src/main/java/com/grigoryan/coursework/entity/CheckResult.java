package com.grigoryan.coursework.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "check_result")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CheckResult {

    @Id
    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "test_city")
    private String testCity;

    @Column(name = "test_intarface")
    private String testIntarface;

    @Column(name = "test_humidity")
    private String testHumidity;

    @Column(name = "test_main")
    private String testMain;

    @Column(name = "test_temperature")
    private String testTemperature;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private BotFunction botFunction;

    @OneToOne
    @JoinColumn(name = "id_intarface", referencedColumnName = "id_intarface")
    private Intarface intarface;

    @OneToOne
    @JoinColumn(name = "dependencies_id", referencedColumnName = "dependencies_id")
    private WritingCode writingCode;

    public BotFunction getBotFunction() {
        return botFunction;
    }

    public void setBotFunction(BotFunction botFunction) {
        this.botFunction = botFunction;
    }

    public Intarface getIntarface() {
        return intarface;
    }

    public void setIntarface(Intarface intarface) {
        this.intarface = intarface;
    }

    public WritingCode getWritingCode() {
        return writingCode;
    }

    public void setWritingCode(WritingCode writingCode) {
        this.writingCode = writingCode;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestCity() {
        return testCity;
    }

    public void setTestCity(String testCity) {
        this.testCity = testCity;
    }

    public String getTestIntarface() {
        return testIntarface;
    }

    public void setTestIntarface(String testIntarface) {
        this.testIntarface = testIntarface;
    }

    public String getTestHumidity() {
        return testHumidity;
    }

    public void setTestHumidity(String testHumidity) {
        this.testHumidity = testHumidity;
    }

    public String getTestMain() {
        return testMain;
    }

    public void setTestMain(String testMain) {
        this.testMain = testMain;
    }

    public String getTestTemperature() {
        return testTemperature;
    }

    public void setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
    }
}
