package com.elasticdemo.util;

import java.time.LocalDate;
import java.util.Random;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import com.elasticdemo.model.submission.Submission;
import com.elasticdemo.service.AWSElasticSearchService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomPoJoGenerator {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AWSElasticSearchService.class);

    static Random random = new Random();
    static LocalDate today = LocalDate.now();
    private static EasyRandomParameters parameters = new EasyRandomParameters().seed(123L)
                                                                               .objectPoolSize(100)
                                                                               .randomizationDepth(15)
                                                                               .stringLengthRange(5, 25)
                                                                               .collectionSizeRange(1, 10)
                                                                               .scanClasspathForConcreteTypes(true)
                                                                               .overrideDefaultInitialization(false)
                                                                               .dateRange(today.minusDays(7),
                                                                                       today.plusDays(3));

    static String getRandomSubmissionStatus() {
        return SubmissionStatus.ordered.get(random.nextInt(SubmissionStatus.ordered.size()));
    }

    static EasyRandom easyRandom = new EasyRandom(parameters);



    public static <T> T getObject(Class<T> className) {
        return easyRandom.nextObject(className);
    }

}
