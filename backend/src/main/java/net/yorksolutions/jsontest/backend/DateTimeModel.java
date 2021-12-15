package net.yorksolutions.jsontest.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DateTimeModel {
    @JsonProperty
    private String date;

    @JsonProperty
    private String time;

    public DateTimeModel(String time, String date) {
        this.time = time;
        this.date = date;
    }
}
