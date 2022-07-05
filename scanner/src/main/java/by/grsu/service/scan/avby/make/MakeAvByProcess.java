package by.grsu.service.scan.avby.make;

import by.grsu.model.autoscanner.Make;

import java.io.IOException;
import java.util.Set;

public interface MakeAvByProcess {
    Set<Make> getListOfMakes() throws IOException;
}
