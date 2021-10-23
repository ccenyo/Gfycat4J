package commands;

import java.util.HashMap;
import java.util.Map;

public abstract class GetCommand<T> extends Command<T>{
    @Override
    protected Method getMethod() {
        return Method.GET;
    }

    protected abstract Map<String, String> getParams();

    @Override
    protected Map<String, String> getParamsInBody() {
        return new HashMap<>();
    }

    @Override
    protected Map<String, String> getParamsInLink() {
        return  getParams();
    }
}
