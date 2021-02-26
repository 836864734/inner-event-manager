package leoli.event.spi;

import javax.annotation.PostConstruct;

/**
 * 抽象Event处理器，订阅并处理一个具体的Event
 *
 * @author leoli
 * @date 2020/2/26
 */
public abstract class EventHandler {

    @PostConstruct
    private void init() {
        EventManager.get().regist(this.regist(), this);
    }

    /**
     * 向EventManager中注册自己，同时声明自己要处理的消息类型
     */
    protected abstract Class<?> regist();

    /**
     * 事件处理方法
     *
     * @param event 订阅到的具体事件
     */
    protected abstract void process(Event event);

}
