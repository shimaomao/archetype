package com.siyu.controller;

import com.siyu.entity.Greeting;
import com.siyu.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/greetings")
@Slf4j
public class GreetingController {

    @Autowired
    @Setter
    private GreetingService greetingService;

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public Greeting create(@RequestBody final Greeting greeting, @RequestParam(required = false, defaultValue = "true") boolean hehe) {
        log.info("hehe:{}" + hehe);
        return this.greetingService.create(greeting);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable(name = "id") final Long id) {
        this.greetingService.delete(id);
    }

    @GetMapping("")
    public Page<Greeting> find(@PageableDefault(size = 20) final Pageable pageable) {
        return this.greetingService.find(pageable);
    }

    @GetMapping("/{id}")
    public Greeting findOne(@PathVariable(name = "id") final Long id) {
        return this.greetingService.findOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public Greeting update(@PathVariable(name = "id") final Long id, @RequestBody final Greeting greeting) {
        greeting.setId(id);
        return this.greetingService.update(greeting);
    }
}
