package leoli.eventer.rest;

import leoli.event.spi.EventManager;
import leoli.eventer.bean.SayEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Say something...
 *
 * @author leoli
 * @date 2020/2/26
 */
@RestController
@RequestMapping("say")
public class Hello {

    @RequestMapping("{msg}")
    public String hello(@PathVariable String msg) {
        // Submit a Event to EventManager
        EventManager.get().send(new SayEvent(new Date(), msg));
        return msg;
    }

}
