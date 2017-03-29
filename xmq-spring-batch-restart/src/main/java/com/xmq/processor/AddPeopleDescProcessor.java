package com.xmq.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xmq.model.People;
import com.xmq.model.PeopleDESC;

public class AddPeopleDescProcessor implements
        ItemProcessor<People, PeopleDESC> {

    public PeopleDESC process(People item) throws Exception {
        // Thread.sleep(2000);
        System.out.println("process people desc");
        return new PeopleDESC(item.getLastName(), item.getFirstName(), Thread
                .currentThread().getName());
    }

}
