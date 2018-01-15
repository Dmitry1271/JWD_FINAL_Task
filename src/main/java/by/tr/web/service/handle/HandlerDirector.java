package by.tr.web.service.handle;

import by.tr.web.service.handle.impl.*;
import by.tr.web.util.Transformator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cplus on 14.01.2018.
 */
public class HandlerDirector {
    private Map<HandlerName, PropertyHandler> handlers = new HashMap<>();

    public HandlerDirector() {
        handlers.put(HandlerName.FRIDGE, new FridgePropertyHandler());
        handlers.put(HandlerName.MICROWAVE, new MicrowavePropertyHandler());
        handlers.put(HandlerName.VACUUM_CLEANER, new VacuumCleanerPropertyHandler());
        handlers.put(HandlerName.TELEVISOR, new TelevisorPropertyHandler());
        handlers.put(HandlerName.WASHING_MASHINE, new WashingMashinePropertyHandler());
    }

    public PropertyHandler takeHandler(String name) {
        HandlerName handlerName = HandlerName.valueOf(Transformator.getEnumFromString(name));
        return handlers.get(handlerName);
    }
}
