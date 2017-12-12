
package hello.redditDTO;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "oembed",
    "type"
})
public class SecureMedia {

    @JsonProperty("oembed")
    private Oembed oembed;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The oembed
     */
    @JsonProperty("oembed")
    public Oembed getOembed() {
        return oembed;
    }

    /**
     * 
     * @param oembed
     *     The oembed
     */
    @JsonProperty("oembed")
    public void setOembed(Oembed oembed) {
        this.oembed = oembed;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
