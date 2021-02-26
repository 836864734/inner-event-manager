package leoli.eventer.bean;

import leoli.event.spi.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author leoli
 * @date 2020/2/26
 */
@Data
@AllArgsConstructor
public class SayEvent extends Event {

    private Date time;
    private String message;

}
