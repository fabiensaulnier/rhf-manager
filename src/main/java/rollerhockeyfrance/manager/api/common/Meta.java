package rollerhockeyfrance.manager.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Meta {
    
    /**
     * PAGINATION
     */
    @JsonProperty private Long total;
    @JsonProperty private Long next;
    @JsonProperty private Long previous;
    
    public Long getTotal() {
        return total;
    }
    
    public void setTotal(Long total) {
        this.total = total;
    }
    
    public Long getNext() {
        return next;
    }
    
    public void setNext(Long next) {
        this.next = next;
    }
    
    public Long getPrevious() {
        return previous;
    }
    
    public void setPrevious(Long previous) {
        this.previous = previous;
    }
    
}
