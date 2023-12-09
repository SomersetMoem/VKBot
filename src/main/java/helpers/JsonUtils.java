package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;


public class JsonUtils {
    private final static Logger LOG = Logger.getLogger(JsonUtils.class);

    public static String getValueForKey(String jsonString) {
        LOG.info("Извлекаем значение из json: " + jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode firstValue = jsonNode.elements().next();
            if (firstValue != null && firstValue.isTextual()) {
                return firstValue.asText();
            } else {
                LOG.warn("Не удалось извлечь значение из JSON");
            }
        } catch (IOException e) {
            LOG.error("Ошибка при обработке JSON", e);
        }
        return null;
    }
}
