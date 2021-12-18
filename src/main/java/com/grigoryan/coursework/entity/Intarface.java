package com.grigoryan.coursework.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "intarface")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Intarface {

    @Id
    @Column(name = "id")
    private Integer Id;

    @Column(name = "layout")
    private String layout;

    @Column(name = "button_position")
    private String buttonPosition;

    @Column(name = "weather_data_output")
    private String weatherDataOutput;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private BotFunction botFunction;

    public BotFunction getBotFunction() {
        return botFunction;
    }

    public void setBotFunction(BotFunction botFunction) {
        this.botFunction = botFunction;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getButtonPosition() {
        return buttonPosition;
    }

    public void setButtonPosition(String buttonPosition) {
        this.buttonPosition = buttonPosition;
    }

    public String getWeatherDataOutput() {
        return weatherDataOutput;
    }

    public void setWeatherDataOutput(String weatherDataOutput) {
        this.weatherDataOutput = weatherDataOutput;
    }
}
