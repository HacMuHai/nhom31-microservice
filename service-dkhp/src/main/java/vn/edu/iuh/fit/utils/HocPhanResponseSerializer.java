package vn.edu.iuh.fit.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

class HocPhanResponseSerializer implements JsonSerializer<Object> {

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        Arrays.stream(src.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(src);
                if (value != null && !isEmptyArray(value)) {
                    jsonObject.add(field.getName(), context.serialize(value));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return jsonObject;
    }

    private boolean isEmptyArray(Object object) {
        if (object instanceof List<?>) {
            return ((List<?>) object).isEmpty();
        } else if (object.getClass().isArray()) {
            return ((Object[]) object).length == 0;
        }
        return false;
    }

}
