package leoli.eventer.handler;

import leoli.event.spi.Event;
import leoli.event.spi.EventHandler;
import leoli.eventer.bean.SayEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 也处理SayEvent消息
 *
 * @author leoli
 * @date 2020/2/26
 */
@Component
public class SayEventHandler2 extends EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SayEventHandler2.class);

    @Override
    protected Class<?> regist() {
        return SayEvent.class;
    }

    @Override
    protected void process(Event event) {
        LOGGER.info("刚刚是不是有人说了啥子？");
    }

}
