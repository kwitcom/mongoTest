package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.EmailModel;
import com.test.mongotest.Viz.repository.EmailModelRepository;
import com.test.mongotest.model.Domains;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Slf4j
@Service
public class EmailModelService {
    @Autowired
    private EmailModelRepository emailModelRepository;
    public void loadSampleData(Integer batchSize, Integer numBatches) {
        for (int i = 0; i < numBatches; i++) {
            generateSampleData(batchSize);
        }
    }
    private void generateSampleData(int numRecords) {

        IntStream.range(0, numRecords)
                // Use parallel stream to process the elements in parallel
                .parallel()
                // For each integer in the stream, generate a sample email model and save it
                .forEach(i -> {
                    EmailModel emailModel = EmailModel.builder()
                            .emailAddress(generateRandomEmail(Domains.selectRandomDomain()))
                            .build();
                    emailModelRepository.save(emailModel);
                });
    }
    private String generateRandomEmail(String domainName){

        String emailAddress = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (emailAddress.length() < 5) {
            int character = (int) (Math.random() * 26);
            emailAddress += alphabet.substring(character, character + 1);
            emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
            emailAddress += "@" + domainName;
        }
        return emailAddress;
    }


}
