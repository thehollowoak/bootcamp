
package hello.redditDTO;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "content",
    "width",
    "scrolling",
    "height"
})
public class MediaEmbed {

    @JsonProperty("content")
    private String content;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("scrolling")
    private Boolean scrolling;
    @JsonProperty("height")
    private Integer height;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The width
     */
    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The scrolling
     */
    @JsonProperty("scrolling")
    public Boolean getScrolling() {
        return scrolling;
    }

    /**
     * 
     * @param scrolling
     *     The scrolling
     */
    @JsonProperty("scrolling")
    public void setScrolling(Boolean scrolling) {
        this.scrolling = scrolling;
    }

    /**
     * 
     * @return
     *     The height
     */
    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
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
