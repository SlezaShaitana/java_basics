package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class StationDepth {
    private String name;
    private String depth;

    @Override
    public String toString() {
        return "StationDepth{" + "name='" + name + '\'' + ", depth='" + depth + '\'' + '}';
    }
}
