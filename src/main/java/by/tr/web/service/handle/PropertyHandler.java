package by.tr.web.service.handle;

import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 14.01.2018.
 */
public interface PropertyHandler {
    Map<String, Object> selectNeedProperties(List allProperties);
    boolean isValidProperties(List allProperties);
}
