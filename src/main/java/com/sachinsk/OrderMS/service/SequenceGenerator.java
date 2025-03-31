package com.sachinsk.OrderMS.service;

import com.sachinsk.OrderMS.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {

    @Autowired
    MongoOperations mongoOperations;

    //method to generate Id for the next order getting generated
    public int generateNextOrderId() {

        //logic to fetch the sequence from Sequence.java entity (Document) and update it to 1
        //Note: if the sequence Document is not available, then initialize the sequence with 1 & update , insert that document in MongoDB

        Sequence counter = mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                options().returnNew(true).upsert(true),
                Sequence.class
        );
        return counter.getSequence();
    }
}
