package com.xmq.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xmq.exception.InvalidDataException;
import com.xmq.model.People;
import com.xmq.model.PeopleDESC;

public class AllowSkipProcessor implements ItemProcessor<People, PeopleDESC> {

    public PeopleDESC process(People item) throws Exception {
        System.out.println("process people desc");
        if ("xiaoti3".equals(item.getFirstName())) {
            System.out.println("skip invalid data!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new InvalidDataException("skip this data!!!!!!!!!!!!");
        }
        return new PeopleDESC(item.getLastName(), item.getFirstName(), Thread
                .currentThread().getName());
    }
}
