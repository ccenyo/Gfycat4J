package commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.GfycatException;
import net.dongliu.requests.Requests;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class Command<T> {
    private static final Logger LOG = LoggerFactory.getLogger(Command.class.getName());
    private Map<String, Object> defaultHeaders = new HashMap<>();

    {
        defaultHeaders.put("Content-Type", "application/json");
    }
    public enum Method {
        POST,
        GET,
        PUT,
        DELETE
    }


    protected abstract Map<String, String> getParamsInLink();
    protected abstract Map<String, String> getParamsInBody();
    protected abstract Map<String, Object> getHeaders();
    protected abstract String getEndPoint();
    protected abstract Method getMethod();
    protected abstract Class<T> getClassForMapper();
    protected  abstract void validate();

    public T call() {
        this.validate();
        defaultHeaders.putAll(getHeaders());
          String result = Requests.newRequest(getMethod().name(), getEndPoint())
                .headers(defaultHeaders)
                .params(getParamsInLink())
                .body(new JSONObject(getParamsInBody()).toString())
                .send().readToText();

        try {
            return unMashJson(result);
        } catch (JsonProcessingException e) {
            throw new GfycatException(e);
        }
    }

    private T unMashJson(String jsonAsString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonAsString, getClassForMapper());
    }


}
