package requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dongliu.requests.Requests;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class GfycatAbstractRequest<T> {
    private static final Logger LOG = LoggerFactory.getLogger(GfycatAbstractRequest.class.getName());
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


    protected abstract Map<String, String> getParams();
    protected abstract Map<String, String> getParamsInBody();
    protected abstract Map<String, Object> getHeaders();
    protected abstract String getEndPoint();
    protected abstract Method getMethod();
    protected abstract Class<T> getClassForMapper();

    public T call() {
        defaultHeaders.putAll(getHeaders());
          String result = Requests.newRequest(getMethod().name(), getEndPoint())
                .headers(defaultHeaders)
                .params(getParams())
                .body(new JSONObject(getParamsInBody()).toString())
                .send().readToText();

        try {
            return unMashJson(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    private T unMashJson(String jsonAsString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonAsString, getClassForMapper());
    }


}
