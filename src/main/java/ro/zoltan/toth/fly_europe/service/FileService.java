package ro.zoltan.toth.fly_europe.service;

import ro.zoltan.toth.fly_europe.domain.Country;

import java.util.List;

public interface FileService {

    List<String> readContent(String fileName);

    List<Country> transformContent(List<String> content);

    boolean insertAll(List<Country> countries);

}
