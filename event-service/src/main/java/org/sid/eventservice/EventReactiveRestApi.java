package org.sid.eventservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@RestController
public class EventReactiveRestApi {

    @GetMapping(value = "/streamEvents/{id}",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Event> listEvents(@PathVariable String id){
        Flux<Long> interval = Flux.interval(Duration.ofMillis(1000));
        Flux<Event> events = Flux.fromStream(Stream.generate(()->{
            Event event = new Event();
            event.setInstant(Instant.now());
            event.setSocieteID(id);
            event.setValue(100+Math.random()*1000);
            return event;
        }));
        // combiner les deux flux
        return Flux.zip(interval,events)
                .map(data->{
                    return data.getT2();
                });
    }

}


class Event {
    private Instant instant ;
    private double value;
    private String societeID ;

    public Instant getInstant() {
        return instant;
    }

    public double getValue() {
        return value;
    }

    public String getSocieteID() {
        return societeID;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setSocieteID(String societeID) {
        this.societeID = societeID;
    }
}
