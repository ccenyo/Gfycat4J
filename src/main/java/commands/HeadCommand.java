package commands;

import java.util.HashMap;
import java.util.Map;

public abstract class HeadCommand<T> extends Command<T>{
    @Override
    protected Method getMethod() {
        return Method.HEAD;
    }

    @Override
    protected Map<String, String> getParamsInBody() {
        return new HashMap<>();
    }

    @Override
    protected Map<String, String> getParamsInLink() {
        return new HashMap<>();
    }
}
