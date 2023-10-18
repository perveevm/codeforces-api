package ru.perveevm.codeforces.api.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Some methods that help to perform requests easier.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class ReflectionUtils {
    /**
     * Takes a {@link Method} object of one of the API calling methods and an array of parameters. Encodes them into
     * {@link List} of {@link NameValuePair} objects.
     *
     * @param method A {@link Method} object of one of the API calling methods of
     *               {@link ru.perveevm.codeforces.api.CodeforcesSession} class.
     * @param values An array of {@link Object} values — the parameters of a request.
     * @return A {@link List} of {@link NameValuePair} objects — encoded parameters of a given method.
     */
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

    /**
     * Gets a {@link Method} object by method name and a {@link Class} object.
     *
     * @param clazz A descriptor of a given class.
     * @param name  Method name to find.
     * @return A {@link Method} object for a given method.
     */
    public static Method getMethodByName(final Class<?> clazz, final String name) {
        Optional<Method> foundMethod = Arrays.stream(clazz.getMethods())
                .filter(p -> p.getName().equals(name)).findFirst();
        if (foundMethod.isEmpty()) {
            throw new IllegalArgumentException("There is no API method with name: " + name);
        } else {
            return foundMethod.get();
        }
    }
}
