/*
 * Copyright 2015 Jean-Michel Tanguy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.auxeanne.data;

import com.auxeanne.data.ctrl.Record;
import java.io.Serializable;
import java.util.Objects;

/**
 * Default implementation to be extended by all POJOs managed by the framework.
 * Any field can then be added with the getters and setters.
 *
 * @author Jean-Michel Tanguy
 */
public abstract class AbstractRecord  implements Record, Serializable {

    @FieldExclusion
    private transient Long id;
    //@FieldExclusion
    //private transient byte[] document;
    //@FieldExclusion
    //private transient boolean documentChanged = false;

    /**
     * get the id of the record if persisted or null
     * @return unique database ID of the record
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Internal use only as the ID needs to me managed by a "Records" instance only. 
     * Set the database Id of the record.
     * @param recordId unique database ID of the record
     */
    @Override
    public void setId(Long recordId) {
        this.id = recordId;
    }

    /**
     * Hash code  of the item id
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = id.hashCode();
        return hash;
    }

    /**
     * 
     * @param obj POJO to compare to
     * @return equality status
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //if (getClass() != obj.getClass()) {
        //    return false;
        //}
        final AbstractRecord other = (AbstractRecord) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * using recordId only
     *
     * @return string value
     */
    @Override
    public String toString() {
        return "Record[ id=" + id + " ]";
    }

}
