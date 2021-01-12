/**
 * @author MohammadAliMezzawi
 */
@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value=DateAdapter.class, type=Date.class)
})
package com.path.vo.alert.subscriber;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import com.path.lib.common.util.DateAdapter;
