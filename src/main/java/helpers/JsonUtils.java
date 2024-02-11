package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;


public class JsonUtils {
    private final static Logger LOG = Logger.getLogger(JsonUtils.class);

    public static String getValueForKey(String key, String jsonString) {
        LOG.info("Извлекаем значение из JSON: " + jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode responseNode = jsonNode.get("response");
            if (responseNode != null && responseNode.isArray() && responseNode.size() > 0) {
                JsonNode firstElement = responseNode.get(0);
                JsonNode valueNode = firstElement.get(key);
                if (valueNode != null && valueNode.isTextual()) {
                    return valueNode.asText();
                } else {
                    LOG.warn("Не удалось извлечь значение для ключа");
                }
            } else {
                LOG.warn("Отсутствует массив 'response' или он пуст в JSON");
            }
        } catch (Exception e) {
            LOG.error("Ошибка при обработке JSON", e);
        }
        return null;
    }

    public static String getKeyFromJson(String jsonString) {
        LOG.info("Извлекаем ключ из json: " + jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            if (jsonNode.isObject() && jsonNode.fields().hasNext()) {
                Map.Entry<String, JsonNode> entry = jsonNode.fields().next();
                return entry.getKey();
            } else {
                LOG.warn("Не удалось извлечь ключ из JSON");
            }
        } catch (IOException e) {
            LOG.error("Ошибка при обработке JSON", e);
        }
        return null;
    }




}
