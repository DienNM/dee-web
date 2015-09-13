package com.dee.webdee.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */

@Embeddable
public class SSCompositeKey  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "id1")
    private String id1;
    
    @Column(name = "id2")
    private String id2;

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
    
}
