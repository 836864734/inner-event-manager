package leoli.eventer.handler;

import leoli.eventer.bean.SayEvent;
import leoli.event.spi.Event;
import leoli.event.spi.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 处理{@link SayEvent}消息
 *
 * @author leoli
 * @date 2020/2/26
 */
@Component
public class SayEventHandler extends EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SayEventHandler.class);

    @Override
    protected Class<?> regist() {
        return SayEvent.class;
    }

    @Override
    protected void process(Event obj) {
        SayEvent event = (SayEvent) obj;
        LOGGER.info("刚刚，有人说：{}", event.getMessage());
    }

}
