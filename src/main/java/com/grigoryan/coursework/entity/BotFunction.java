package com.grigoryan.coursework.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bot_function")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BotFunction {

    @Id
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "command_start")
    private String commandStart;

    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "humidity")
    private String humidity;

    @Column(name = "main")
    private String main;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCommandStart() {
        return commandStart;
    }

    public void setCommandStart(String commandStart) {
        this.commandStart = commandStart;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
