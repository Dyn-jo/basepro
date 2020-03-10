package  com.dyn.basepro.properties;

import lombok.Data;

/**
 *@description: 线程池prop
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
@Data
public class ThreadPoolProp {

    private Integer corePoolSize;

    private Integer maxPoolSize;

}
