package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StationDate {
    private String name;
    private String date;

    @Override
    public String toString() {
        return "StationsDates{" + "name='" + name + '\'' + ", date='" + date + '\'' + '}';
    }
}
