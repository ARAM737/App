package com.grigoryan.coursework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "writing_code")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WritingCode {

    @Id
    @Column(name = "dependencies_id")
    private Integer dependenciesId;

    @Column(name = "writing_function")
    private String writingFunction;

    @Column(name = "import_library")
    private String importLibrary;

    @Column(name = "import_weather_data")
    private String importWeatherData;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private BotFunction botFunction;

    @OneToOne
    @JoinColumn(name = "id_intarface", referencedColumnName = "id_intarface")
    private Intarface intarface;

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

    public Integer getDependenciesId() {
        return dependenciesId;
    }

    public void setDependenciesId(Integer dependenciesId) {
        this.dependenciesId = dependenciesId;
    }

    public String getWritingFunction() {
        return writingFunction;
    }

    public void setWritingFunction(String writingFunction) {
        this.writingFunction = writingFunction;
    }

    public String  getImportLibrary() {
        return importLibrary;
    }

    public void setImportLibrary(String importLibrary) {
        this.importLibrary = importLibrary;
    }

    public String getImportWeatherData() {
        return importWeatherData;
    }

    public void setImportWeatherData(String importWeatherData) {
        this.importWeatherData = importWeatherData;
    }
}
