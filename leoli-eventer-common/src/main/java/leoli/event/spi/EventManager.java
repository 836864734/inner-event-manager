package leoli.event.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Event Manager
 *
 * @author leoli
 * @date 2020/2/26
 */
public class EventManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventManager.class);
    private static EventManager instance = new EventManager();

    // 支持同一个事件，多个handler订阅
    private Map<String, List<EventHandler>> handlers = new HashMap<>();

    private EventManager() {
    }

    public static EventManager get() {
        return instance;
    }

    /**
     * 注册Event处理器
     *
     * @param cls     订阅的消息类类型
     * @param handler 对应的处理器
     */
    public void regist(Class<?> cls, EventHandler handler) {
        String key = cls.getName();
        if (handlers.containsKey(key)) {
            ((List) handlers.get(key)).add(handler);
        } else {
            handlers.put(key, new ArrayList<>(Arrays.asList(handler)));
        }
        LOGGER.debug("Event handler was registed: [event={}, handler={}]", key, handler.getClass().getName());
    }

    public void send(Event event) {
        this.dispatcher(event);
    }

    /**
     * Event routing and handler
     *
     * @param event
     */
    private void dispatcher(Event event) {
        LOGGER.debug("Event received: [{}]", event.toString());
        List<EventHandler> handlers = this.handlers.get(event.getClass().getName());

        if (handlers != null) {
            // 异步处理
            handlers.parallelStream().forEach(handler -> {
                LOGGER.debug("Event dispatch: [event={}, handler={}]", event.getClass().getName(), handler.getClass().getName());
                handler.process(event);
            });
        } else {
            LOGGER.debug("Event can not dispatch, because the handler is not registed!");
        }

    }

}
