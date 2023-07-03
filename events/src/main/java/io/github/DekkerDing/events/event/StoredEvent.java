package io.github.DekkerDing.events.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 创建应用存储事件
 */
@Slf4j
public class StoredEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent} with its {@link #getTimestamp() timestamp}
     * set to {@link System#currentTimeMillis()}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public StoredEvent(Object source) {
        super(source);
    }

    /**
     * Create a new {@code ApplicationEvent} with its {@link #getTimestamp() timestamp}
     * set to the value returned by {@link Clock#millis()} in the provided {@link Clock}.
     * <p>This constructor is typically used in testing scenarios.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     * @param clock  a clock which will provide the timestamp
     * @since 5.3.8
     */
    public StoredEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
