package io.github.DekkerDing.reactive.events.listener;

import io.github.DekkerDing.events.event.StoredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class StoredListener implements ApplicationListener<StoredEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(StoredEvent event) {

    }
}
