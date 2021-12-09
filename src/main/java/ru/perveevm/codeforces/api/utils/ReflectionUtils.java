package ru.perveevm.codeforces.api.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import ru.perveevm.codeforces.api.SessionException;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReflectionUtils {
    public static List<NameValuePair> encodeMethodParameters(final Method method, final Object... values) {
        Parameter[] parameters = method.getParameters();
        List<NameValuePair> requestParameters = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            if (values[i] != null) {
                requestParameters.add(new BasicNameValuePair(parameters[i].getName(), String.valueOf(values[i])));
            }
        }
        return requestParameters;
    }

    public static Method getMethodByName(final Class<?> clazz, final String name) throws SessionException {
        Optional<Method> foundMethod = Arrays.stream(clazz.getMethods())
                .filter(p -> p.getName().equals(name)).findFirst();
        if (foundMethod.isEmpty()) {
            throw new SessionException("There is no method with name: " + name);
        } else {
            return foundMethod.get();
        }
    }
}
