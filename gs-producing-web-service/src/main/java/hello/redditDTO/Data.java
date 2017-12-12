
package hello.redditDTO;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "modhash",
    "children",
    "after",
    "before"
})
public class Data {

    @JsonProperty("modhash")
    private String modhash;
    @JsonProperty("children")
    private List<Child> children = new ArrayList<Child>();
    @JsonProperty("after")
    private String after;
    @JsonProperty("before")
    private Object before;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The modhash
     */
    @JsonProperty("modhash")
    public String getModhash() {
        return modhash;
    }

    /**
     * 
     * @param modhash
     *     The modhash
     */
    @JsonProperty("modhash")
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    /**
     * 
     * @return
     *     The children
     */
    @JsonProperty("children")
    public List<Child> getChildren() {
        return children;
    }

    /**
     * 
     * @param children
     *     The children
     */
    @JsonProperty("children")
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    /**
     * 
     * @return
     *     The after
     */
    @JsonProperty("after")
    public String getAfter() {
        return after;
    }

    /**
     * 
     * @param after
     *     The after
     */
    @JsonProperty("after")
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * 
     * @return
     *     The before
     */
    @JsonProperty("before")
    public Object getBefore() {
        return before;
    }

    /**
     * 
     * @param before
     *     The before
     */
    @JsonProperty("before")
    public void setBefore(Object before) {
        this.before = before;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
