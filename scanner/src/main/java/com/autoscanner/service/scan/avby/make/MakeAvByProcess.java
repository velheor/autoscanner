package com.autoscanner.service.scan.avby.make;

import com.autoscanner.model.autoscanner.Make;

import java.io.IOException;
import java.util.Set;

public interface MakeAvByProcess {
    Set<Make> getListOfMakes() throws IOException;
}
