package commands;

import java.util.HashMap;
import java.util.Map;

public abstract class PostCommand<T> extends Command<T>{
    @Override
    protected Method getMethod() {
        return Method.POST;
    }

    protected abstract Map<String, String> getParams();

    @Override
    protected Map<String, String> getParamsInBody() {
        return getParams();
    }

    @Override
    protected Map<String, String> getParamsInLink() {
        return new HashMap<>();
    }
}
