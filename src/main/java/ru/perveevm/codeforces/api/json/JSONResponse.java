package ru.perveevm.codeforces.api.json;

import com.google.gson.JsonElement;

/**
 * Represents a JSON API response.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class JSONResponse {
    private JSONResponseStatus status;
    private String comment;
    private JsonElement result;

    /**
     * @return Response status.
     */
    public JSONResponseStatus getStatus() {
        return status;
    }

    /**
     * @return If the status is {@link JSONResponseStatus#FAILED}, then comment contains the reason why the request
     * failed. Otherwise, it's <code>null</code>.
     */
    public String getComment() {
        return comment;
    }

    /**
     * @return If the status is {@link JSONResponseStatus#OK}, then JSON-element which will be described for each method
     * separately. Otherwise, it's <code>null</code>.
     */
    public JsonElement getResult() {
        return result;
    }
}
