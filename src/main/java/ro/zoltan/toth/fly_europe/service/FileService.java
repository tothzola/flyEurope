package ro.zoltan.toth.fly_europe.service;

import ro.zoltan.toth.fly_europe.domain.Flight;

import java.util.List;

public interface FileService {

    List<String> readContent(String fileName);

    List<Flight> transformContent(List<String> content);

    boolean insertAll(List<Flight> flights);

}
