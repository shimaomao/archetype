package com.siyu.service;

import com.siyu.entity.Greeting;
import com.siyu.repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    /**
     * create a greeting.
     *
     * @param greeting to create
     * @return created
     */
    public Greeting create(final Greeting greeting) {

        return this.greetingRepository.save(greeting);
    }

    /**
     * delete a greeting by id.
     *
     * @param id target id
     * @return deleted
     */
    public Greeting delete(Long id) {

        Greeting found = this.greetingRepository.findOne(id);
        this.greetingRepository.delete(id);
        return found;
    }

    /**
     * find paged greetings.
     *
     * @param pageable find condition
     * @return paged
     */
    public Page<Greeting> find(final Pageable pageable) {
        return this.greetingRepository.findAll(pageable);
    }

    /**
     * find a greeting.
     *
     * @param id target id
     * @return found
     */
    public Greeting findOne(final Long id) {

        return this.greetingRepository.findOne(id);
    }

    /**
     * update a greeting.
     *
     * @param greeting to update
     * @return updated
     */
    public Greeting update(final Greeting greeting) {

        final Greeting found = this.greetingRepository.findOne(greeting.getId());

        final Greeting toSave = Greeting.builder() //
                .id(greeting.getId()) //
                .toWhom(greeting.getToWhom()) //
                .version(greeting.getVersion() != null ? greeting.getVersion() : found.getVersion())
                .build();

        return this.greetingRepository.save(toSave);
    }
}
