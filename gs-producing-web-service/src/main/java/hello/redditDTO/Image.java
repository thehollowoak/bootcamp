
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
    "source",
    "resolutions",
    "variants",
    "id"
})
public class Image {

    @JsonProperty("source")
    private Source source;
    @JsonProperty("resolutions")
    private List<Resolution> resolutions = new ArrayList<Resolution>();
    @JsonProperty("variants")
    private Variants variants;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The source
     */
    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The resolutions
     */
    @JsonProperty("resolutions")
    public List<Resolution> getResolutions() {
        return resolutions;
    }

    /**
     * 
     * @param resolutions
     *     The resolutions
     */
    @JsonProperty("resolutions")
    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    /**
     * 
     * @return
     *     The variants
     */
    @JsonProperty("variants")
    public Variants getVariants() {
        return variants;
    }

    /**
     * 
     * @param variants
     *     The variants
     */
    @JsonProperty("variants")
    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
